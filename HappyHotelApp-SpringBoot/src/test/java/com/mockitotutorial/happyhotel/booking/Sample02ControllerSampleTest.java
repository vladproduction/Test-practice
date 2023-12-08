package com.mockitotutorial.happyhotel.booking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.net.URL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Sample02ControllerSampleTest {

	@LocalServerPort
	private int port;
	private URL base;
	@MockBean
	private BookingService bookingService; //now we have mocked been, replaces the real bean
	//as usual, we can define custom return values for mocked beans using when/then pattern just like
	//for any other mocks

	@Autowired
	private TestRestTemplate template;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/greeting");
	}

	@Test
	public void getHello() throws Exception {
		// given
		String expected = "Greetings from The Happy Hotel. We've got enough beds for 10 guests!";
		when(bookingService.getAvailablePlaceCount()).thenReturn(10);
		/*now test passed - we injected the mocked bean with defined behaviour, and it used by controller
		* which is return the number of 10 guests*/

		// when
		ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
		String actual = response.getBody();

		// then
		assertEquals(expected, actual);
	}

}
