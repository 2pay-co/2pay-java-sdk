package com.twoPay.payment.response.dataSearch;

import com.twoPay.payment.response.TwoPayResponse;

import net.sf.json.JSONObject;

public class TranQueryResponse extends TwoPayResponse {

	private static final long serialVersionUID = -6886252858670465096L;
	
	private JSONObject result;

	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}
	
}	
