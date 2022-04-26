package com.revature.user.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProfileControllerTests {

    private MockMvc mockMvc;

    @InjectMocks
    private ProfileController profileController;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(profileController).build();
    }

    /**
     * Is ProfileController is returning the correct response when a GET request is sent to the default endpoint?
     *
     * @throws Exception
     */
    @Test
    public void testHelloWorld() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.get("/profiles")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello, world!"));
    }
}
