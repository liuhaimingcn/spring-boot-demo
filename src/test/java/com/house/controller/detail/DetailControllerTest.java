package com.house.controller.detail;

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

import java.util.Date;

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
public class DetailControllerTest {

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
     * 添加详情
     *
     * @throws Exception
     */
    @Test
    public void testAdd() throws Exception {
        for (int i = 0; i < 20; i++) {
            ObjectNode detail = mapper.createObjectNode();
            detail.put("title", "这是主题！" + i);
            detail.put("introduce", "这是简介！");
            detail.put("picture", "http://b.hiphotos.baidu.com/image/pic/item/caef76094b36acaf6f9d91907fd98d1001e99c58.jpg");
            detail.put("photos", "[{\"pic\":\"http://www.iyi8.com/uploadfile/2014/1115/20141115115950458.jpg\",\"detail\":\"可爱妹妹户外玩水吊床\"},{\"pic\":\"http://www.iyi8.com/uploadfile/2014/1115/20141115115950458.jpg\",\"detail\":\"可爱妹妹户外玩水吊床\"},{\"pic\":\"http://www.iyi8.com/uploadfile/2014/1115/20141115115950458.jpg\",\"detail\":\"可爱妹妹户外玩水吊床\"},{\"pic\":\"http://www.iyi8.com/uploadfile/2014/1115/20141115115950458.jpg\",\"detail\":\"可爱妹妹户外玩水吊床\"},{\"pic\":\"http://www.iyi8.com/uploadfile/2014/1115/20141115115950458.jpg\",\"detail\":\"可爱妹妹户外玩水吊床\"}]");
            detail.put("type", 1);
            detail.put("specialId", 1);

            String result = this.mockMvc.perform(MockMvcRequestBuilders.post("/details", "json")
                    .characterEncoding("utf-8").contentType(MediaType.APPLICATION_JSON).content(detail.toString().getBytes()))
                    .andReturn().getResponse().getContentAsString();
            System.out.println(result);
        }

    }

    /**
     * 根据主键查询对应的详情
     * @throws Exception
     */
    @Test
    public void testGetById() throws Exception {
        MvcResult result = mockMvc.perform(
                get("/details/17bfdcdaabdd48dc8c113d5d0f5e6691")
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void testIndex() throws Exception {
        MvcResult result = mockMvc.perform(
                get("/details")
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

}
