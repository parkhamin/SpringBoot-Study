package com.example.restapi;

import com.example.restapi.model.UserRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestApiApplicationTests {
	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void contextLoads() throws JsonProcessingException {
		var user = new UserRequest();
		user.setUserName("홍길동");
		user.setUserAge(10);
		user.setEmail("hong@naver.com");
		user.setIsKorean(true);

		// 변수 기준이 아닌 get이라는 이름이 들어간 메서드를 참고한다.
		var json = objectMapper.writeValueAsString(user);
		System.out.println(json);

		// json을 dto로 바꿀 때는 setter 메서드를 참고하는데 setter 메서드가 없다면 get 메서드를 통해서도 세팅이 가능하다.
		var dto = objectMapper.readValue(json, UserRequest.class);
		System.out.println(dto);
	}

}
