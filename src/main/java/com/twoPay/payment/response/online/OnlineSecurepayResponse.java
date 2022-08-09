package com.twoPay.payment.response.online;

import com.twoPay.payment.response.TwoPayResponse;

import net.sf.json.JSONObject;

public class OnlineSecurepayResponse extends TwoPayResponse {

	private static final long serialVersionUID = 2458591733625822127L;
	
	private JSONObject result;

	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}
	
	
}