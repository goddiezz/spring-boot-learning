package com.potato.bookdemo.controller;

import com.potato.bookdemo.entity.Book;
import com.potato.bookdemo.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author PotatoRice
 * @description：
 * @date 2021/3/18 10:26 下午
 */
@Controller
@RequestMapping(value = "/")
public class BookController {
    @Resource
    private BookService bookService;

    @GetMapping()
    public String bookPage(Model model) {
        model.addAttribute("message", "Hello SpringBoot");
        List<Book> bookList = bookService.getAll();
        model.addAttribute("BookList", bookList);
        return "Book";
    }
}
