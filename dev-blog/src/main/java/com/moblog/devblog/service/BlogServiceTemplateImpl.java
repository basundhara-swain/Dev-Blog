package com.moblog.devblog.service;

import com.moblog.devblog.domain.Blog;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service// we can write @Componet, @Repository..
@RequiredArgsConstructor
@Primary//if qualifer is not avilable them it checks primery by default take primery class. it is use class in class.
public class BlogServiceTemplateImpl implements BlogService {
    // private final ArrayList<Blog> blogs;
    private final JdbcTemplate jdbcTemplate;
    @Value("${prefix}")
    private String prefix;

    public void addBlog(Blog blog) {
        var heading = prefix + " " + blog.getHeading();
        String sql = "insert into moblog (heading, description) values(?,?)";
        jdbcTemplate.update(sql, heading, blog.getDescription());
    }

    //spring data jdbc use HIKARI for connection pooling.// By default it avilable is 10
    public List<Blog> getBlogs() {
        String sql = "Select * from moblog";
        RowMapper<Blog> rwm = (resultSet, rowNum) -> new Blog(
                resultSet.getInt("id"),
                resultSet.getString("heading"),
                resultSet.getNString("description"));
        return jdbcTemplate.query(sql, rwm);//return jdbcTemplate.query(
    }

    @Override
    public Blog getBlog(int id) {
        String sql = "select * from moblog where id= ?";
        RowMapper<Blog> rwm = (resultSet, rowNum) -> new Blog(resultSet.getInt("id"),
                resultSet.getString("heading"),
                resultSet.getNString("description"));
        return jdbcTemplate.queryForObject(sql, rwm, id);
    }

    @Override
    public void deleteBlog(int id) {
        String sql = "delete from moblog where id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updateBlog(Blog blog) {
        var id = blog.getId();
        var heading = blog.getHeading();
        var description = blog.getDescription();
        String sql = "UPDATE moblog SET heading = ?, description = ? WHERE id = ?";
        jdbcTemplate.update(sql, heading, description,id);
    }

}
