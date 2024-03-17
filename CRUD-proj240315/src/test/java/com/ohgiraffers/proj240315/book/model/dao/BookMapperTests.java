package com.ohgiraffers.proj240315.book.model.dao;

import com.ohgiraffers.proj240315.book.model.dto.BookDTO;
import com.ohgiraffers.proj240315.configuration.CrudProj240315Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = { CrudProj240315Application.class })
public class BookMapperTests {

    @Autowired
    private BookMapper bookMapper;

    @Test
    @Transactional
    public void 매퍼_인터페이스_의존성_주입_테스트() {
        assertNotNull(bookMapper);
    }

    @Test
    @Transactional
    public void 전체_도서_조회_매퍼_테스트() {
        List<BookDTO> bookList = bookMapper.findAllBook();
        assertNotNull(bookList);
    }

    @Test
    @DisplayName("신규 도서 추가 매퍼 인터페이스 확인")
    @Transactional
    public void testRegistBook() {
        BookDTO book = new BookDTO();
        book.setBookName("테스트2");
        book.setPublisher("출판사2");
        book.setReleaseDate(20240316);
        book.setAmount(2);
        book.setCategoryCode(2);
        book.setLoanableYN('N');

        assertDoesNotThrow(() -> bookMapper.registBook(book));
    }

    @Test
    @DisplayName("신규 도서 추가 실패 확인")
    public void testRegistBook2() {
        BookDTO book = new BookDTO();
        book.setBookName("추가실패");
        book.setPublisher("출판사3");
        book.setReleaseDate(20240316);
        book.setAmount(1);
        book.setCategoryCode(20);
        book.setLoanableYN('N');

        assertThrows(Exception.class, () -> bookMapper.registBook(book));
    }

}
