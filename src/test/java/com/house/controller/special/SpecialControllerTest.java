package com.house.controller.special;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * @author liuhaiming
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/resources/mvc-servlet.xml", "file:src/main/resources/spring-context.xml"})
public class SpecialControllerTest {

    private MockMvc mockMvc;
    private ObjectMapper mapper;

    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
        mapper = new ObjectMapper();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * 分页条件查询主题信息
     *
     * @throws Exception
     */
    @Test
    public void testIndex() throws Exception {
        MvcResult result = mockMvc.perform(
                get("/specials")
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    /**
     * 根据主键查询对应的专题详情
     * @throws Exception
     */
    @Test
    public void testGetById() throws Exception {
        MvcResult result = mockMvc.perform(
                get("/specials/1")
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

}
