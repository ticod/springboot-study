package com.demo.community;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 *  오류 발생 이유?
 *  - @SpringBootTest의 value와 properties를 함께 사용
 *  - value : 테스트 실행 전 적용할 프로퍼티 주입 (기존 프로퍼티 오버라이드 가능)
 *  - properties : 테스트 실행 전 {key = value} 형식의 프로퍼티 추가 가능
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(
        value = "value=test",
        properties = {"property.value=propertyTest"},
        classes = {SpringBootTestApplicationTests.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class SpringBootTestApplicationTests {

    @Value("${value}")
    private String value;

    @Value("${property.value}")
    private String propertyValue;

    @Test
    public void contextLoads() {
        assertThat(value, is("test"));
        assertThat(propertyValue, is("propertyValue"));
    }

}
