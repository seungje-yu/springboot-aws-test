package com.coffit.demo.web;

import com.coffit.demo.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/* @RestController
* - 컨트롤러 JSON을 반환하는 컨트롤러로 만들어 준다.
* - @ResponseBody를 각 메소드마다 선언해야하는걸 한번에 해주는기능을 한다.
* - @Controller + @ResponseBody라고보면된다.
* */
@RestController
public class HelloController {

    /*
    * @GetMapping
    * - HTTP Method인 Get요청을 받을 수 있는 API를 만들어줌
    * */
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
