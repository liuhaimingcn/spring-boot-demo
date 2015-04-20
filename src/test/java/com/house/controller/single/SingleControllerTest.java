package com.house.controller.single;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
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
public class SingleControllerTest {

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

    @Test
    public void testIndex() throws Exception {
        MvcResult result = mockMvc.perform(
                get("/singles")
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void testGetById() throws Exception {
        MvcResult result = mockMvc.perform(
                get("/singles/04826181886941e1ab83114a791d452e")
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void testAdd() throws Exception {
        ObjectNode detail = mapper.createObjectNode();
        detail.put("title", "这是标题！");

        String result = this.mockMvc.perform(MockMvcRequestBuilders.post("/singles", "json")
                .characterEncoding("utf-8").contentType(MediaType.APPLICATION_JSON).content(detail.toString().getBytes()))
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);

    }

    @Test
    public void testUpdate() throws Exception {
        ObjectNode detail = mapper.createObjectNode();
        detail.put("id", "28ce0f00203f45ccb5fa435755c9ed44");
        detail.put("title", "这是");
        detail.put("status", 0);

        String result = this.mockMvc.perform(MockMvcRequestBuilders.put("/singles", "json")
                .characterEncoding("utf-8").contentType(MediaType.APPLICATION_JSON).content(detail.toString().getBytes()))
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);

    }

}
