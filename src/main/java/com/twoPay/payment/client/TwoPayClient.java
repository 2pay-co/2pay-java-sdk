package com.twoPay.payment.client;

import com.twoPay.payment.exception.TwoPayException;
import com.twoPay.payment.request.TwoPayRequest;
import com.twoPay.payment.response.TwoPayResponse;

public interface TwoPayClient {
	
	<T extends TwoPayResponse> T execute(TwoPayRequest<T> request) throws TwoPayException;
}
