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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;
import java.util.Date;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * @author liuhaiming
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/resources/mvc-servlet.xml","file:src/main/resources/spring-context.xml"})
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
	 * 添加券
	 * @throws Exception
	 */
	@Test
	public void testAdd() throws Exception {
		ObjectNode detail = mapper.createObjectNode();
        detail.put("title", "这是主题！");
        detail.put("introduce", "这是简介！");
        detail.put("picture", "这是主图！");
        detail.put("photos", "这是内容！");
        detail.put("type", 1);
        detail.put("styleType", 0);

       String result = this.mockMvc.perform(MockMvcRequestBuilders.post("/details", "json")
    		.characterEncoding("utf-8").contentType(MediaType.APPLICATION_JSON).content(detail.toString().getBytes()))
        	.andReturn().getResponse().getContentAsString();
       System.out.println(result);
	}
	
}
