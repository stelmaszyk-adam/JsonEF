package json.tools;

import json.tools.diffutil.TextDiff;
import json.tools.formatter.JSONBaseReader;
import json.tools.formatter.JSONBeautifier;
import json.tools.formatter.JSONMinifier;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FormatterApplicationTests {

	@Test
	void When_InputJsonString_Expect_ReturnBeautified() {
		String test ="{\"name\":\"sample name\",\"product\":\"sample product\",\"address\":\"sample address\"}";
		System.out.println(new JSONBeautifier(new JSONBaseReader()).read(test));
	}

	@Test
	void When_InputJsonString_Expect_ReturnMinified() {
		String test ="{\"name\":  \"sample name\"\n,\"product\":\"sample product\"\n,\"address\":\"sample address\"}";
		System.out.println(new JSONMinifier(new JSONBaseReader()).read(test));
	}

	@Test
	void When_InputBothJsonStrings_Expect_ReturnDiff() {
		String test1 ="{\"name1\":\"sample name1\",\"product1\":\"sample product\",\"address\":\"sample address\"}\n" +
				"		name3";
		String test2 ="{\"name2\":\"sample name2\",\"product1\":\"sample product\",\"address\":\"sample address\"}";
		System.out.println(TextDiff.diff(test1,test2));
	}

	@Test
	void When_InputFirstEmptyStringSecondJsonString_Expect_ReturnSecond() {
		String test1 = "";
		String test2 = "test2";
		System.out.println(TextDiff.diff(test1,test2));
	}

	@Test
	void When_InputBothEmptyStrings_Expect_ReturnEmpty() {
		String test1 = "";
		String test2 = "";
		System.out.println(TextDiff.diff(test1,test2));
	}
}
