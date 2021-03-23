package com.potato.bookdemo.service;

import com.potato.bookdemo.entity.Book;

import java.util.List;

/**
 * @author PotatoRice
 * @description：
 * @date 2021/3/18 9:58 下午
 */
public interface BookService {
    /**
     * 新增book
     * @param book入参
     * @return 新增的book对象
     */
    Book save(Book book);

    /**
     * 查询所有book
     * @return图书集合
     */
    List<Book> getAll();
}
