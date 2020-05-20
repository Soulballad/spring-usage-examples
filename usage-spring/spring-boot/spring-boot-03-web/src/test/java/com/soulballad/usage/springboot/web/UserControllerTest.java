package com.soulballad.usage.springboot.web;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soulballad.usage.springboot.SpringBoot03WebApplication;
import com.soulballad.usage.springboot.model.User;
import com.soulballad.usage.springboot.service.UserService;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : test
 * @since ：2020/5/20 19:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SpringBoot03WebApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class UserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void getList_success() throws Exception {
        mockMvc.perform(get("/user/list").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void testAdd_success() throws Exception {
        User user = createUser();
        when(userService.addUser(user)).thenReturn(user);
        mockMvc.perform(post("/user/add").contentType(MediaType.APPLICATION_JSON).content(asJsonStr(user)))
            .andExpect(status().isCreated()).andExpect(header().string("location", containsString("/user/get/111")));
    }

    @Test
    public void testAdd_fail() throws Exception {
        User user = new User(112, "duplicated");
        when(userService.exist(user)).thenReturn(true);
        mockMvc.perform(post("/user/add").contentType(MediaType.APPLICATION_JSON).content(asJsonStr(user)))
            .andExpect(status().isAlreadyReported());
    }

    @Test
    public void testGet_success() throws Exception {
        User user = new User(1234, "lisi");
        when(userService.getUserById(1234)).thenReturn(user);
        mockMvc.perform(get("/user/get/{id}", 1234)).andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id", is(1234))).andExpect(jsonPath("$.name", is("lisi")));
    }

    @Test
    public void testGet_fail() throws Exception {
        when(userService.getUserById(1234)).thenReturn(null);
        mockMvc.perform(get("/user/get/{id}", 1234)).andExpect(status().isOk()).andExpect(content().string(""));
        verify(userService, times(1)).getUserById(1234);
        verifyNoMoreInteractions(userService);
    }

    @Test
    public void testUpdate_success() throws Exception {
        User user = createUser();
        when(userService.getUserById(user.getId())).thenReturn(user);
        mockMvc.perform(put("/user/update").contentType(MediaType.APPLICATION_JSON).content(asJsonStr(user)))
            .andExpect(status().isOk());
    }

    @Test
    public void testUpdate_fail() throws Exception {
        User user = new User(1234, "lisi");
        when(userService.getUserById(user.getId())).thenReturn(user);
        mockMvc.perform(put("/user/update").contentType(MediaType.APPLICATION_JSON).content(asJsonStr(user)))
            .andExpect(status().isOk()).andExpect(content().string(""));
    }

    @Test
    public void testDelete_success() throws Exception {
        User user = new User(1234, "lisi");
        when(userService.getUserById(user.getId())).thenReturn(user);
        doReturn(user).when(userService).delete(user.getId());
        mockMvc.perform(delete("/user/delete/{id}", user.getId())).andExpect(status().isOk());
    }

    @Test
    public void testDelete_fail() throws Exception {
        User user = new User(1234, "lisi");
        when(userService.getUserById(user.getId())).thenReturn(null);
        mockMvc.perform(delete("/user/delete/{id}", user.getId())).andExpect(status().isOk());
    }

    private static String asJsonStr(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private User createUser() {

        User user = new User();
        user.setId(111);
        user.setName("test create");
        return user;
    }
}
