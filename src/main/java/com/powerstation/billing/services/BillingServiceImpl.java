package com.powerstation.billing.services;

import com.powerstation.commonlibrary.OrderMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BillingServiceImpl implements BillingService {


    private RestTemplate restTemplate;
    private BillingProducer billingProducer;

    public BillingServiceImpl(RestTemplate restTemplate
            , BillingProducer billingProducer
    ) {

        this.restTemplate = restTemplate;
        this.billingProducer = billingProducer;
    }

    @Override
    public int sendReservationRequest(OrderMessage orderMessage) {
        ResponseEntity<String> userDTOResponseEntity = restTemplate.getForEntity("http://localhost:8386/api/v1/reserv?username=sako", String.class);
        return userDTOResponseEntity.getStatusCodeValue();
    }
}
