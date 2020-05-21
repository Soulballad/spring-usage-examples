package com.soulballad.usage.springboot.web;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soulballad.usage.springboot.SpringBoot04BeanValidateApplication;
import com.soulballad.usage.springboot.model.User;
import com.soulballad.usage.springboot.service.UserService;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : test
 * @since ：2020/5/21 21:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    classes = SpringBoot04BeanValidateApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testList() throws Exception {
        mockMvc.perform(get("/user/list")).andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void testGet() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/user/get/{id}", 1L)).andExpect(status().isOk())
            .andExpect(model().attribute("user", hasProperty("id", is(1))))
            .andExpect(model().attribute("user", hasProperty("name", is("zhangsan"))))
            .andExpect(model().attribute("user", hasProperty("age", is(23))))
            .andExpect(model().attribute("user", hasProperty("idCard", is("110101200303072399")))).andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        assertThat(response.getContentType()).isEqualTo("application/json;charset=UTF-8");

        Collection<String> headerNames = response.getHeaderNames();
        assertNotNull(headerNames);
        assertEquals(2, headerNames.size());
        assertEquals("Check for Content-Type header", "Accept-Language", headerNames.iterator().next());
        assertTrue(response.getContentAsString().contains("zhangsan"));
    }

    private User createUser() {
        User user = new User();
        user.setName("test user");
        user.setAge(33);
        user.setIdCard("210102199003072877");
        return userService.add(user);
    }
}
