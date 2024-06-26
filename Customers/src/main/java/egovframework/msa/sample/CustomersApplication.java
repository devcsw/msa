package egovframework.msa.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("egovframework.*")
@EnableEurekaClient
public class CustomersApplication {
	public static void main(String[] args) {
		SpringApplication.run(CustomersApplication.class);
	}
}