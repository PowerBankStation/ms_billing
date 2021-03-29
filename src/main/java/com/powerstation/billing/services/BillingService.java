package com.powerstation.billing.services;

import com.powerstation.commonlibrary.OrderMessage;

public interface BillingService {

    int sendReservationRequest(OrderMessage orderMessage);

}
