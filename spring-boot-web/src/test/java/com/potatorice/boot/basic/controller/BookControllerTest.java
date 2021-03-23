package com.potatorice.boot.basic.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j

class BookControllerTest {
    //mock对象
    private static MockMvc mockMvc;

    //在所有测试方法在、执行之前进行mock对象初始化
    @BeforeAll
    static void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new BookController()).build();
    }

    @Test
    void selectBooks() {

    }

    @Test
    void getBook() {
    }

    @Test
    void saveBook() throws Exception {
        String books = "{\"content\": \"从入门到精通\",\n" +
                "      \"title\": \"SpringBoot\",\n" +
                "      \"createTime\": \"2021-03-07 23:05:37\",\n" +
                "      \"readers\": [\n" +
                "        {\n" +
                "          \"name\": \"aaa\",\n" +
                "          \"age\": 21\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"bbb\",\n" +
                "          \"age\": 19\n" +
                "        }\n" +
                "      ],\n" +
                "      \"author\": \"PotatoRice\"}";
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders
                        .request(HttpMethod.POST, "/api/v1/books/")
                        .contentType("application/json")
                        .content(books)
        )

                .andExpect(MockMvcResultMatchers.status().isOk())

                .andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("PotatoRice"))

                .andExpect(MockMvcResultMatchers.jsonPath("$.data.readers[ 0].age").value(21))
                .andDo(print())
                .andReturn();
        result.getResponse().setCharacterEncoding("UTF8");

        log.info(result.getResponse().getContentAsString());
    }



    @Test
    void updateBook() {
    }

    @Test
    void deleteArticle() {
    }
}