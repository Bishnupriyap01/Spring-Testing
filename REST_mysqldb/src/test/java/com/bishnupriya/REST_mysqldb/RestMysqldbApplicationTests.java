package com.bishnupriya.REST_mysqldb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class RestMysqldbApplicationTests {
	private Calculator c = new Calculator();

	@Test
	void contextLoads() {
	}
	@Test
	void testsum(){
		int expected = 6;
		int actual = c.sum(1,2,3);
		assertThat(actual).isEqualTo(expected);

	}
	@Test
	void testcomapre(){
		Boolean actual = c.compare(1,1);
		assertThat(actual).isTrue();
	}

}
