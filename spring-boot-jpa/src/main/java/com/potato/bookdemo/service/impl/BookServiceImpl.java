package com.potato.bookdemo.service.impl;

import com.potato.bookdemo.entity.Book;
import com.potato.bookdemo.repository.BookRepository;
import com.potato.bookdemo.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author PotatoRice
 * @description：
 * @date 2021/3/18 10:01 下午
 */
@Service
@Transactional(rollbackFor = {RuntimeException.class})
public class BookServiceImpl implements BookService {
    @Resource
    private BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }
}
