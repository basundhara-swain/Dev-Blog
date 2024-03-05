package com.moblog.devblog.service;

import com.moblog.devblog.domain.Blog;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class BlogServiceClientImpl implements BlogService {

    private final JdbcClient jdbcClient;
    @Value("${prefix}")
    private String prefix;

    @Override
    public void addBlog(Blog blog) {
        var heading = prefix + " " + blog.getHeading();
        var description = blog.getDescription();
        String sql = "insert into moblog (heading, description) values(:h,:d)";// we use map.of
//        String sql = "insert into moblog (heading, description) values(?,?)";// we use list.of
        jdbcClient.sql(sql)//this method use to pass sql querry
                .param("h", heading)
                .param("d", description)
                .update();//it is  a non select satement we pass update method in select satement we pass querry
        //       jdbcClient.sql(sql).params(List.of(heading, description)).update();
//        jdbcClient.sql(sql).params(Map.of()("h",heading, "d",description)).update();
    }

    @Override
    public List<Blog> getBlogs() {
        String sql = "Select * from moblog";// it is select querry thats why we use querry method
        return jdbcClient.sql(sql).query(Blog.class).list();
    }

    @Override
    public Blog getBlog(int id) {
        String sql = "select * from moblog where id= :id";
        var optional = jdbcClient.sql(sql)
                .param("id",id)
                .query(Blog.class).optional();
        return optional.orElseThrow();
    }

    @Override
    public void deleteBlog(int id) {
        String sql = "delete from moblog where id = :id";
        jdbcClient.sql(sql).param("id",id).update();
    }

    @Override
    public void updateBlog(Blog blog) {
        var id=blog.getId();
        var heading=blog.getHeading();
        var description=blog.getDescription();
        String sql="update moblog set heading=:h, description=:d where id=:id";
        jdbcClient.sql(sql)
                .param("id",id)
                .param("h",heading)
                .param("d",description)
                .update();
    }
}
// in "GET" we are vound some limit of data can send and also we can not send without string type we can not send any type ofdat.
//but in "POST" we can send unlimited data.
//THE REASON BEHIND IT:-This is because the GET method sends data through the resource URL, which is limited in length,
// while the POST method sends data through the HTTP message body, which has no such limitation.