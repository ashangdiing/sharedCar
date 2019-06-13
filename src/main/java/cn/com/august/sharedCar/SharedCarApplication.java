package cn.com.august.sharedCar;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;
@SpringBootApplication
@EnableJpaRepositories("cn.com.august.*.*")
@EntityScan(basePackages = "cn.com.august.*.*")
//发现客户端的注解
@EnableDiscoveryClient


//提供服务的注解
@EnableEurekaClient

// 对指定接口进行负载均衡
@RibbonClient(name = "SHAREDCAR")

@EnableHystrixDashboard
@EnableCircuitBreaker //开启断路器功能
@EnableTurbine
public class SharedCarApplication {
	 @Bean
	    @LoadBalanced
	    RestTemplate restTemplate() {
	        return new RestTemplate();
	    }
	public static void main(String[] args) {
		SpringApplication.run(SharedCarApplication.class, args);
	}

}
