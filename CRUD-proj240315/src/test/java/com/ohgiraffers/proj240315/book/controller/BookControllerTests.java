package com.ohgiraffers.proj240315.book.controller;

import com.ohgiraffers.proj240315.configuration.CrudProj240315Application;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@SpringBootTest
@ContextConfiguration(classes = { CrudProj240315Application.class })
public class BookControllerTests {

    @Autowired
    private BookController bookController;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    @Transactional
    public void 전체_도서_조회용_컨트롤러_테스트() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/book/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.forwardedUrl("book/list"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @Transactional
    public void 신규_도서_등록용_컨트롤러_테스트() throws Exception {

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("bookName", "테스트");
        params.add("publisher", "출판사1");
        params.add("releaseDate", "20240315");
        params.add("amount", "1");
        params.add("categoryCode", "1");
        params.add("loanableYN", "Y");

        mockMvc.perform(MockMvcRequestBuilders.post("/book/regist").params(params))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/book/list"))
                .andDo(MockMvcResultHandlers.print());
    }
}
