package com.github.allanfs.dgapp;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.allanfs.dgapp.modelo.pizza.Recheio;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DgAppApplicationTests {

	private TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();
	// necessita que a aplicação esteja em execução
	@Test
	public void testCreateRecheio() {
		
		Recheio recheio = new Recheio();
		recheio.setNome("Molho");
		recheio.setDisponivel(true);
		recheio.setEspecial(false);
		
		HttpEntity<Recheio> entity = new HttpEntity<Recheio>(recheio, headers);
		
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/recheio"), HttpMethod.POST, entity, String.class);
		
		// obtem informações do HEADER
		String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);

		assertTrue(actual.contains("/recheio"));
		
	}
	
	private String createURLWithPort(final String uri) {
		return "http://localhost:" + 8080 + uri;
}

}
