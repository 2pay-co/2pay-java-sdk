package com.twoPay.payment.response.recurring;

import com.twoPay.payment.response.TwoPayResponse;

import net.sf.json.JSONObject;

public class AutoPayResponse extends TwoPayResponse {

	private static final long serialVersionUID = 6783296011807467819L;
	private JSONObject result;

	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}
}
