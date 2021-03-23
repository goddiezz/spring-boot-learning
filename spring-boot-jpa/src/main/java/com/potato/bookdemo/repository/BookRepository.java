package com.potato.bookdemo.repository;

import com.potato.bookdemo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author PotatoRice
 * @description：
 * @date 2021/3/18 9:38 下午
 */
public interface BookRepository extends JpaRepository<Book, Integer> {
//    /**
//     * 根据书名查找并按id排序
//     * @return
//     */
//    List<Book> findBookByNameAndOrderById();
}
