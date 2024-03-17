package com.ohgiraffers.proj240315.book.model.dao;

import com.ohgiraffers.proj240315.book.model.dto.BookDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    List<BookDTO> findAllBook();

    void registBook(BookDTO newBook);
}
