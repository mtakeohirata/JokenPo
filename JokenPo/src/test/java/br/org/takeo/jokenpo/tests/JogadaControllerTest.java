package br.org.takeo.jokenpo.tests;

import java.io.IOException;
import java.net.http.HttpResponse;

import org.junit.Test;
import org.springframework.http.HttpStatus;

public class JogadaControllerTest {
	
	@Test
	public void givenUserDoesNotExists_whenUserInfoIsRetrieved_then404IsReceived()
	  throws IOException {
	 
	    // Given
	    String name = RandomStringUtils.randomAlphabetic( 8 );
	    HttpUriRequest request = new HttpGet( "https://api.github.com/users/" + name );
	 
	    // When
	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
	 
	    // Then
	    assertThat(
	      httpResponse.getStatusLine().getStatusCode(),
	      equalTo(HttpStatus.SC_NOT_FOUND));
	}
}
