package org.laki.filtertest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void loggedInUserNameAndHeaderEqualTest() throws Exception {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("user-name", "lakshman");
        ResponseEntity<String> responseEntity = this.restTemplate.withBasicAuth("lakshman", "123")
                .exchange("http://localhost:" + port + "/users/admin", HttpMethod.GET, new HttpEntity<Object>(headers), String.class);
        assertThat(responseEntity.getBody().contains("lakshman"));
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void loggedInUserNameAndHeaderDifferentTest() throws Exception {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("user-name", "lakshman");
        ResponseEntity<String> responseEntity = this.restTemplate.withBasicAuth("admin", "admin")
                .exchange("http://localhost:" + port + "/users/admin", HttpMethod.GET, new HttpEntity<Object>(headers), String.class);
        Assertions.assertNull(responseEntity.getBody());
    }

    @Test
    public void incorrectUserNamePasswordTest() throws Exception {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("user-name", "lakshman");
        ResponseEntity<String> responseEntity = this.restTemplate.withBasicAuth("admin", "123")
                .exchange("http://localhost:" + port + "/users/admin", HttpMethod.GET, new HttpEntity<Object>(headers), String.class);
        Assertions.assertEquals(HttpStatus.UNAUTHORIZED, responseEntity.getStatusCode());
    }
}
