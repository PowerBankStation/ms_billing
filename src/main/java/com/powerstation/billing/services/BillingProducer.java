package com.powerstation.billing.services;

import com.powerstation.commonlibrary.OrderMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BillingProducer {

    private static final String PROVISION_TOPIC = "BILLING";
    private  KafkaTemplate kafkaTemplate;

    public BillingProducer(KafkaTemplate kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }


    public void sendMessage(OrderMessage orderMessage){
        System.out.println("Billing order message "+orderMessage.toString());
        this.kafkaTemplate.send(PROVISION_TOPIC, orderMessage);
    }

}
