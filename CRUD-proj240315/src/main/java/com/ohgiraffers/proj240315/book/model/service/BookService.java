package com.ohgiraffers.proj240315.book.model.service;

import com.ohgiraffers.proj240315.book.model.dao.BookMapper;
import com.ohgiraffers.proj240315.book.model.dto.BookDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    private final BookMapper bookMapper;

    public BookService(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }
    public List<BookDTO> findAllBook() {
        return bookMapper.findAllBook();
    }

    @Transactional
    public void registBook(BookDTO newBook) {
        bookMapper.registBook(newBook);
    }
}
