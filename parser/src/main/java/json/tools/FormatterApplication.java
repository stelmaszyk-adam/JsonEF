package json.tools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"json.tools.rest"})
public class FormatterApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormatterApplication.class, args);
	}
}
