package com.coffit.demo.web;



import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// SpringRunner라는 스프링 실행자를 사용 (스프링부트테스트와JUnit사이를 연결)
//@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
/*
* @WebMvcTest
* - 여러 스프링 테스트 어노테이션 중 Web(Spring MVC)에 집중할 수 있는 어노테이션
* - 선언할 경우 @Controller, @ControllerAdvice등을 사용 가능
* - 단, @Service, @Component, @Repository등은 사용할 수 없음
*       여기서는 컨트롤러만 사용가능하기 때문에 선언
* */
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;
    /*
    * - 웹 API를 테스트할 때 사용
    * - 스프링 MVC 테스트의 시작점
    * - 이 클래스를 통해서 HTTP GET, POST 등에 대한 API 테스트가 가능
    * */

    @Test
    @DisplayName("hello-world가 리턴")
    public void hello() throws Exception {

        String helloWorld = "Hello World";

        mvc.perform(get("/hello")) // /hello 주소로 HTTP GET 요청
                .andExpect(status().isOk()) // mvc.perform의 결과를 검증, HTTP Header의 Status를 검증, 상태값이 200인지 검증
                .andExpect(content().string(helloWorld)); //mvc.perform의 결과를 검증, 응답 본문의 내용을 검증,
    }

    @Test
    @DisplayName("helloDto가 리턴")
    public void helloDto() throws Exception {

        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
