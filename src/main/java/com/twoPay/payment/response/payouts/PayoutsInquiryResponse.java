package com.twoPay.payment.response.payouts;

import com.twoPay.payment.response.TwoPayResponse;

import net.sf.json.JSONObject;

public class PayoutsInquiryResponse extends TwoPayResponse {

	private static final long serialVersionUID = -8642884531692806921L;
	private JSONObject result;

	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}
}
