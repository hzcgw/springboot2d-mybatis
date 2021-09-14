package ga.hzcgw.springboot.controller;

import ga.hzcgw.springboot.Starter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Starter.class})
@AutoConfigureMockMvc
public class TestUserController {

    private final Logger logger = LoggerFactory.getLogger(TestUserController.class);

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void before() {
        logger.info("单元测试之前");
    }

    @Test
    public void apitest01() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/user/list")
                .contentType("text/html")
                .accept(MediaType.APPLICATION_JSON);
        ResultActions perform = mockMvc.perform(request);

        perform.andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult mvcResult = perform.andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();

        logger.info("用户状态 {}", response.getStatus());
        logger.info("用户信息 {}", response.getContentAsString());
    }

    @Test
    public void apitest02() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/user/name/admin"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        logger.info("用户状态 {}", mvcResult.getResponse().getStatus());
        logger.info("用户信息 {}", mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void apitest03() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/user/id/3"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        logger.info("用户状态 {}", mvcResult.getResponse().getStatus());
        logger.info("用户信息 {}", mvcResult.getResponse().getContentAsString());
    }

    @After
    public void after() {
        logger.info("单元测试之后");
    }

}
