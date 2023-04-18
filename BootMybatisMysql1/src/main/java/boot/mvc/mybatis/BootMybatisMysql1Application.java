package boot.mvc.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"data.*"})
@MapperScan({"data.*"})
public class BootMybatisMysql1Application {

	public static void main(String[] args) {
		SpringApplication.run(BootMybatisMysql1Application.class, args);
	}

}
