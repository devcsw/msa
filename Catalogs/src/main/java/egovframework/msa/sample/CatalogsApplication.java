package egovframework.msa.sample;


import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig.SlidingWindowType;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;

@SpringBootApplication
@ComponentScan("egovframework.*")
@EnableFeignClients
@EnableEurekaClient
public class CatalogsApplication {
	public static void main(String[] args) {
		SpringApplication.run(CatalogsApplication.class);
	}
	@Bean
	public CircuitBreakerRegistry circuitBreakerRegistry() {
		return CircuitBreakerRegistry.of(CircuitBreakerConfig.custom()
		.minimumNumberOfCalls(10)
		.slidingWindowType(SlidingWindowType.COUNT_BASED)
		.slidingWindowSize(10)
		.failureRateThreshold(50)
		.waitDurationInOpenState(Duration.ofMillis(10000))
		.build());
	}
	@Bean
	public CircuitBreaker circuitBreaker(CircuitBreakerRegistry circuitBreakerRegistry) {
		return circuitBreakerRegistry.circuitBreaker("getCustomerDetail");
	}
}