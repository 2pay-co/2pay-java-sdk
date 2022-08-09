package com.twoPay.payment.response.recurring;

import com.twoPay.payment.response.TwoPayResponse;

import net.sf.json.JSONObject;

public class RevokeResponse extends TwoPayResponse {

	private static final long serialVersionUID = -4155223422252477939L;
	private JSONObject result;

	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}
}
