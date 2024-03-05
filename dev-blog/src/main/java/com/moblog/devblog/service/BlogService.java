package com.moblog.devblog.service;

import com.moblog.devblog.domain.Blog;

import java.util.List;

public interface BlogService {// we create this to see which methods are implemented

    void addBlog(Blog blog);//document partteren.
    List<Blog> getBlogs();
    Blog getBlog(int id);
    void deleteBlog(int id);
    void updateBlog(Blog blog);
}
