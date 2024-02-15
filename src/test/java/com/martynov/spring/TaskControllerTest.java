package com.martynov.spring;

import com.martynov.spring.controllers.TaskController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetLetterInfo() throws Exception {
        String testString = "hello";
        String expectedContent = "{\"e\": 1, \"h\": 1, \"l\": 2, \"o\": 1}";

        mockMvc.perform(get("/?string=" + testString)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedContent));
    }

    @Test
    public void testGetLetterInfoWithMultipleCharacters() throws Exception {
        String testString = "teststring";
        String expectedContent = "{\"t\": 3, \"s\": 2, \"e\": 1, \"g\": 1, \"i\": 1, \"n\": 1, \"r\": 1}";
        mockMvc.perform(get("/?string=" + testString)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedContent));
    }
}
