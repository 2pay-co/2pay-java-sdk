package com.twoPay.payment.response.dataSearch;

import com.twoPay.payment.response.TwoPayResponse;

import net.sf.json.JSONObject;

public class ReverseResponse extends TwoPayResponse {

	private static final long serialVersionUID = 4617089503725402504L;

	private JSONObject result;

	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}

}
