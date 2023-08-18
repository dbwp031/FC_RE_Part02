package com.example.fc_re_part02.controller;

import com.example.fc_re_part02.config.SecurityConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import(SecurityConfig.class)
@WebMvcTest(MainController.class)
class MainControllerTest {
    private final MockMvc mvc;

    MainControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }
    @DisplayName("[view] [GET] 루트 페이지에 접근 시 올바르게 동작하는지 확인합니다.")
    @Test
    void givenNothing_whenRequestingRootPage_thenRedirectsToArticlePage() throws Exception {
        mvc.perform(get("/"))
                .andExpect(status().isOk());
    }
}