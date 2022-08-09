package com.twoPay.payment.request.dataSearch;

import com.twoPay.payment.response.dataSearch.TranQueryResponse;

import com.twoPay.payment.request.RequestConstants;
import com.twoPay.payment.request.TwoPayRequest;

import net.sf.json.JSONObject;

public class TranQueryRequest extends TwoPayRequest<TranQueryResponse> {
	
	private String reference;							//商户支付流水号
	

	public String getReference() {
		return reference;
	}

	public TranQueryRequest setReference(String reference) {
		this.reference = reference;
		return this;
	}


	@Override
	protected void dataValidate() {
	}

	@Override
	protected String getAPIUrl(String env) {
		String urlPrefix = getUrlPrefix(env);
		String url = urlPrefix + RequestConstants.TRAN_QUERY;
		return url;
	}

	@Override
	public TranQueryResponse convertResponse(String ret) {
		TranQueryResponse response = new TranQueryResponse();
		JSONObject json = JSONObject.fromObject(ret);
		response.setRetCode(json.getString("ret_code"));
		response.setRetMsg(json.getString("ret_msg"));
		
		if (null != json.get("result")) {
			response.setResult(json.getJSONObject("result"));
		}
		return response;
	}
}
