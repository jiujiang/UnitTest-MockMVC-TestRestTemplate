package com.example.demo.springBootUnitTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class JunitTest {

    @MockBean
    private BossService bossService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private MockMvc mockMvc;

    private String baseUrl = "http://localhost:";

//    @Test
    public void test2() throws Exception {
        when(bossService.getInstance()).thenReturn(new Boss());
        this.mockMvc.perform(get("/hello")).andDo(print()).andExpect(content().string(containsString("hello"))).
                andExpect(status().isOk());
    }

   // @Test
    public void test3() throws Exception{
        this.mockMvc.perform(post("/tango")).andDo(print()).andExpect(content().string(containsString("hello")));
        stringRedisTemplate.opsForValue().set("a","hello");
        assertEquals(stringRedisTemplate.opsForValue().get("a"),"hello");
    }


    @Test
    public void test4() throws Exception{
        HttpHeaders headers = new HttpHeaders();
        headers.add("EnvId","1");
        headers.add("EnvName","SYS");
        this.mockMvc.perform(post("/tango").
                headers(headers)).
                andDo(print()).
                andExpect(content().string("hellopost"));
    }

}
