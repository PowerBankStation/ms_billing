package com.powerstation.billing.controller;

import com.powerstation.billing.services.BillingProducer;
import com.powerstation.billing.services.BillingServiceImpl;
import com.powerstation.commonlibrary.OrderMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class BillingController {

    private BillingServiceImpl billingService;


    public BillingController(BillingServiceImpl billingService){
        this.billingService = billingService;
    }

    @GetMapping("/test")
    public void test(){
        System.out.println("cccccccccccccccccccc");
        OrderMessage orderMessage = new OrderMessage();
        orderMessage.setOrderId(2);
        orderMessage.setSubscriptionId(2);
        billingService.sendReservationRequest(orderMessage);

    }
}
