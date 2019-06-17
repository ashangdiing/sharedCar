package cn.com.august.sharedCar.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RabbitListener(queues = "queuePeakClipping")
@Component
public class RabbitMqListenerQueuePeakClipping {
		 @RabbitHandler
	    public void process(String message) {
			 try {
	        log.info(message);
		 }catch (Exception e) {
			 log.info("RabbitMqListenerQueuePeakClipping error:",message);
		}
	    }
}
