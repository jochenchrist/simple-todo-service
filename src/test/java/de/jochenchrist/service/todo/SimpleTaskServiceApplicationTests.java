package de.jochenchrist.service.todo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SimpleTaskServiceApplicationTests {

	@Autowired
	MockMvc mvc;

	@Test
	public void contextLoads() {
	}


	@Test
	public void thatTasksCanBeRetrieved() throws Exception {

		mvc.perform(post("/tasks")
				.content(" { \"name\": \"Unit Tests\" }")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isCreated());

		mvc.perform(get("/tasks"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$._embedded.tasks").isArray())
				.andExpect(jsonPath("$._embedded.tasks[0].name").value("Unit Tests"));
	}
}
