package com.xing.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xing.constant.ErrorMessages;
import com.xing.entity.Result;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class RomanNumberControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetRamanNumberNormal() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .get("/romannumeral")
                .param("query", "32"));
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        String response = resultActions.andReturn().getResponse().getContentAsString();
        Result ret = objectMapper.readValue(response, Result.class);
        Assert.assertEquals("XXXII",  ret.getData().get("output"));
    }

    @Test
    public void testGetRamanNumberOutOfRange() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .get("/romannumeral")
                .param("query", "-12"));
        resultActions.andExpect(MockMvcResultMatchers.status().isBadRequest());
        String response = resultActions.andReturn().getResponse().getContentAsString();
        Result ret = objectMapper.readValue(response, Result.class);
        Assert.assertEquals(ErrorMessages.OUT_OF_RANGE_NUMBER,  ret.getMessage());
    }
}
