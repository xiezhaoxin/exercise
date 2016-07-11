package cn.xiezhaoxin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
@EnableAutoConfiguration
public class ExerciseApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ExerciseApplication.class, args);
	}
	
}
