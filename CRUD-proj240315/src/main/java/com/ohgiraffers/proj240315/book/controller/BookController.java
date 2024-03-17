package com.ohgiraffers.proj240315.book.controller;

import com.ohgiraffers.proj240315.book.model.dto.BookDTO;
import com.ohgiraffers.proj240315.book.model.service.BookService;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/book")
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    private final BookService bookService;

    private final MessageSource messageSource;

    public BookController(BookService bookService, MessageSource messageSource) {
        this.bookService = bookService;
        this.messageSource = messageSource;
    }

    @GetMapping("/list")
    public String findBookList(Model model) {

        List<BookDTO> bookList = bookService.findAllBook();
        model.addAttribute("bookList", bookList);
        return "book/list";
    }

    @GetMapping("/regist")
    public void registPage() {}

    @PostMapping("/regist")
    public String registBook(@ModelAttribute BookDTO newBook, RedirectAttributes rttr, Locale locale) {

        bookService.registBook(newBook);
        rttr.addFlashAttribute("successMessage", messageSource.getMessage("registBook", null, locale));

        return "redirect:/book/list";
    }
}
