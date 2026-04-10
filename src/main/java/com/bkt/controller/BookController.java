package com.bkt.controller;

import com.bkt.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private static List<Book> bookList = new ArrayList<>();

    static {
        bookList.add(new Book(1, "Java Core", "Phạm Thái Sơn", 150000));
        bookList.add(new Book(2, "Spring Boot Pro", "PTIT Expert", 350000));
        bookList.add(new Book(3, "Microservices", "Tech Lead", 400000));
        bookList.add(new Book(4, "React TSX", "TSQ", 200000));
    }

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookList);
        model.addAttribute("pageTitle", "DANH SÁCH SÁCH");
        return "book-list";
    }

    @GetMapping("/{id}")
    public String viewDetail(@PathVariable int id, Model model) {
        Book book = bookList.stream()
                .filter(b -> b.getId() == id)
                .findFirst().orElse(null);
        model.addAttribute("book", book);
        model.addAttribute("pageTitle", "CHI TIẾT SÁCH");
        return "book-detail";
    }
}
