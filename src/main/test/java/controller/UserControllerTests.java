package controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvca;

    @Test
    public void registerUserTest() throws Exception {

        this.mockMvc.perform(get("/user/forTest")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("reached test"));
    }
    
    @Test
    public void registerUserTest2() throws Exception {

        this.mockMvc.perform(get("/user/register").param("1", "Dvir"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Dvir"));
    }

}