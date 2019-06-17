package cn.com.august.sharedCar.service;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RabbitMqExchangeConfig {
	 private static final String topicExchangeName = "appUserTopciExchange";
	 private static final String topicQueueData = "queueData";
	 private static final String topicQueueLog = "queueLog";
	 private static final String topicQueuePeakClipping = "queuePeakClipping";
	 private static final String topicQueueDataRoutingKey = "appuser.data.#";
	 private static final String topicQueueLogRoutingKey = "appuser.#";
	 private static final String topicQueuePeakClippingRoutingKey = "appuser.data.*";
	 
	/*
	 * // 是否持久化 boolean durable = true; 
	 * // 仅创建者可以使用的私有队列，断开后自动删除 boolean exclusive = false; 
	 * // 当所有消费客户端连接断开后，是否自动删除队列 boolean autoDelete = false;
	 */
	 
	 
	@Autowired
	private RabbitTemplate rabbitTemplate;
 
 
	
	@Bean
	RabbitAdmin appRabbitAdmin() {
		 
		RabbitAdmin admin = new RabbitAdmin(rabbitTemplate.getConnectionFactory());
		 
		return admin;
	}
	
	 // 话题性 交换机  
    //testAppUserFeignService
    @Bean
    TopicExchange appUserTopciExchange(@Qualifier("appRabbitAdmin") RabbitAdmin appRabbitAdmin){
    	
        TopicExchange contractTopicExchange =  new TopicExchange(topicExchangeName,true,false);
        
          appRabbitAdmin.declareExchange(contractTopicExchange);
        
        log.debug("完成主题型交换机bean实例化");
        return contractTopicExchange;
    }
    
    
    
    
    
    @Bean
    Queue queueTopicAppUserData(@Qualifier("appRabbitAdmin") RabbitAdmin appRabbitAdmin,@Qualifier("appUserTopciExchange") TopicExchange exchange){
        Queue queue = new Queue(topicQueueData, true, false, false);
         appRabbitAdmin.declareQueue(queue);
         appRabbitAdmin.declareBinding(BindingBuilder.bind(queue).to(exchange).with(topicQueueDataRoutingKey));
        log.debug("queueTopicAppUserData 实例化完成");
        return queue;
    }
    @Bean
    Queue queueTopicAppUserLog(@Qualifier("appRabbitAdmin") RabbitAdmin appRabbitAdmin,@Qualifier("appUserTopciExchange") TopicExchange exchange){
    	Queue queue = new Queue(topicQueueLog, true, false, false);
    	 appRabbitAdmin.declareQueue(queue);
    	 appRabbitAdmin.declareBinding(BindingBuilder.bind(queue).to(exchange).with(topicQueueLogRoutingKey));
    	log.debug("queueTopicAppUserLog 实例化完成");
    	return queue;
    }
    @Bean
    Queue queueTopicAppUserPeakClipping(@Qualifier("appRabbitAdmin") RabbitAdmin appRabbitAdmin,@Qualifier("appUserTopciExchange") TopicExchange exchange){
    	Queue queue = new Queue(topicQueuePeakClipping, true, false, false);
    	 appRabbitAdmin.declareQueue(queue);
    	 appRabbitAdmin.declareBinding(BindingBuilder.bind(queue).to(exchange).with(topicQueuePeakClippingRoutingKey));
    	log.debug("queueTopicAppUserPeakClipping 实例化完成");
    	return queue;
    }
    
 
    @Autowired
	 private ObjectMapper objectMapper;
    
    public void sendAppUserData(Object object)  {
    	String temp="";
    	
    	try {
			temp=objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			 log.debug("JsonProcessingException ",e);
		}
    	log.debug("sendAppUserData {}",temp);
    	rabbitTemplate.convertAndSend(topicExchangeName,topicQueueDataRoutingKey, temp);
    }
    public void sendAppUserLog(Object object) {
    	String temp="";
    	
    	try {
			temp=objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			 log.info("JsonProcessingException ",e);
		}
    	log.info("sendAppUserLog {}",temp);
    	rabbitTemplate.convertAndSend(topicExchangeName,topicQueueLogRoutingKey, temp);
    }
    public void sendAppAppUserPeakClipping(Object object) {
    	String temp="";
    	
    	try {
			temp=objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			 log.debug("JsonProcessingException ",e);
		}
    	
    	
    	log.debug("sendAppAppUserPeakClipping {}",temp);
    	rabbitTemplate.convertAndSend(topicExchangeName,topicQueuePeakClippingRoutingKey, temp);
    }
    
    
    
}
