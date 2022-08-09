package com.twoPay.payment.response.payouts;

import com.twoPay.payment.response.TwoPayResponse;

import net.sf.json.JSONObject;

public class PayoutsPayResponse extends TwoPayResponse {

	private static final long serialVersionUID = -5374850524477752149L;
	private JSONObject result;

	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}
}
