package com.twoPay.payment.response.recurring;

import com.twoPay.payment.response.TwoPayResponse;

import net.sf.json.JSONObject;

public class ConsultResponse extends TwoPayResponse {

	private static final long serialVersionUID = 1407583342403492746L;
	
	private JSONObject result;

	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}
}
