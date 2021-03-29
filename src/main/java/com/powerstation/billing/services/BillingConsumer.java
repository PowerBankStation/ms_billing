package com.powerstation.billing.services;

import com.powerstation.commonlibrary.OrderMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class BillingConsumer {

    private static final Logger logger = LoggerFactory.getLogger(BillingConsumer.class);

    private static final String PROVISION_TOPIC = "PROVISIONING";
    private static final String ERROR_TOPIC = "ERROR";
    private BillingService billingService;


        public BillingConsumer(BillingService billingService){
            this.billingService = billingService;
        }


    @KafkaListener(topics = "BILLING")
    @SendTo("PROVISIONING")
    public Message<OrderMessage> consume(OrderMessage message){


        logger.info("MS_BILLING: Consumed message "+message);

        logger.info("MS_BILLING: Reserving subscription account...  ");
       int responseCode =  billingService.sendReservationRequest(message);


        if (responseCode == 200){
           message.setBillingState("SUCCESS");
            logger.info("MS_BILLING: Reserved subscription account "+message.toString());
            return MessageBuilder.withPayload(message).setHeader(KafkaHeaders.TOPIC, PROVISION_TOPIC).build();
       }else {
            message.setBillingState("ERROR");
            logger.info("MS_BILLING: Reservation failed "+message.toString());
            return MessageBuilder.withPayload(message).setHeader(KafkaHeaders.TOPIC, ERROR_TOPIC).build();
       }



    }


}
