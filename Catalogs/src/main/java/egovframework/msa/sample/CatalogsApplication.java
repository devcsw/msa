package egovframework.msa.sample;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("egovframework.*")
@EnableFeignClients
public class CatalogsApplication {
	public static void main(String[] args) {
		SpringApplication.run(CatalogsApplication.class);
	}
}