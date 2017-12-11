package es.caser.spring.mvc.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import es.caser.spring.mvc.model.User;
import es.caser.spring.mvc.repository.IUserRepository;

public class UserControllerTest {

	@Test
	public void should_FindUser_whenRequestingByUsername() throws Exception {
		User user = createUser("bilbo","bolson","bbolson","comarca");
		IUserRepository mockRepository = mock(IUserRepository.class);
		when(mockRepository.findByUsername("bbolson")).thenReturn(user);

		UserController controller = new UserController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/users/bbolson")
		.accept(MediaType.APPLICATION_JSON))
    	.andExpect(status().isOk())    	
    	.andExpect(jsonPath("$.name", is(user.getName())))
    	.andExpect(jsonPath("$.surname", is(user.getSurname())))
    	.andExpect(jsonPath("$.username", is(user.getUsername())));
    	

	}
	private User createUser(String name, String surname, String username, String password) {
		return new User(name, surname, username, password);
	}
}
