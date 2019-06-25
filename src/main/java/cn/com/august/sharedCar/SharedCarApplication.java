package cn.com.august.sharedCar;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;
@SpringBootApplication
@EnableJpaRepositories("cn.com.august.*.*")
@EntityScan(basePackages = "cn.com.august.*.*")
 
public class SharedCarApplication {
	 @Bean
	    RestTemplate restTemplate() {
	        return new RestTemplate();
	    }
	public static void main(String[] args) {
		SpringApplication.run(SharedCarApplication.class, args);
	}

}
