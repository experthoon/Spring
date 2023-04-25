package boot.mvc.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"quiz.jshop"})
@EntityScan({"mycar.data","quiz.jshop"}) //dto인식
@EnableJpaRepositories({"mycar.data","quiz.jshop"}) //dao인식
public class BootJpaProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(BootJpaProject1Application.class, args);
	}

}
