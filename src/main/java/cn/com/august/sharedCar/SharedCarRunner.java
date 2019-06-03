package cn.com.august.sharedCar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SharedCarRunner  implements ApplicationRunner{

	@Autowired
	Config config;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.debug("SharedCarRunner -------------------------------------------->"+config.getTest());
	}

}
