package cn.com.august.sharedCar;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

 

@Data
@Component
@ConfigurationProperties(prefix = "shared-car")
public class Config {
	private String test;
	private String nodeName;
}
