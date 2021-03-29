package com.powerstation.billing;

import com.powerstation.billing.services.BillingProducer;
import com.powerstation.commonlibrary.OrderMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class MsBillingApplication {

    @Autowired
    BillingProducer billingProducer;

    @Bean
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

	public static void main(String[] args) {

        SpringApplication.run(MsBillingApplication.class, args);
//
//        MsBillingApplication msBillingApplication = new MsBillingApplication();
//
//msBillingApplication.billingProducer.sendMessage(new OrderMessage());
	}

}
