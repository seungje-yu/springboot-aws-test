package com.coffit.demo.web;

import com.coffit.demo.web.dto.HelloResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    @DisplayName("롬복 기능 테스트")
    public void test() {

        // given
        String name = "test";
        int amount = 1000;
        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);
        // then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }


}
