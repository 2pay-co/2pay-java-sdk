package com.twoPay.payment.request.dataSearch;

import com.twoPay.payment.exception.TwoPayException;
import com.twoPay.payment.response.dataSearch.ReverseResponse;
import org.apache.commons.lang.StringUtils;

import com.twoPay.payment.request.RequestConstants;
import com.twoPay.payment.request.TwoPayRequest;

import net.sf.json.JSONObject;

public class ReverseRequest extends TwoPayRequest<ReverseResponse> {

	private String transactionNo;
	private String reference;

	public String getTransactionNo() {
		return transactionNo;
	}

	public ReverseRequest setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
		return this;
	}

	public String getReference() {
		return reference;
	}

	public ReverseRequest setReference(String reference) {
		this.reference = reference;
		return this;
	}


	@Override
	protected void dataValidate() {
		if (StringUtils.isEmpty(this.transactionNo) && StringUtils.isEmpty(this.reference)) {
			throw new TwoPayException("transaction and reference cannot be null at the same time");
		}
		if (StringUtils.isNotEmpty(this.transactionNo) && StringUtils.isNotEmpty(this.reference)) {
			throw new TwoPayException("transaction and reference cannot exist at the same time");
		}
	}

	@Override
	protected String getAPIUrl(String env) {
		String urlPrefix = getUrlPrefix(env);
		String url = urlPrefix + RequestConstants.CANCEL;
		return url;
	}


	@Override
	public ReverseResponse convertResponse(String ret) {
		ReverseResponse response = new ReverseResponse();
		JSONObject json = JSONObject.fromObject(ret);
		if (null != json.get("result")) {
			response.setResult(json.getJSONObject("result"));
		}
		response.setRetCode(json.getString("ret_code"));
		response.setRetMsg(json.getString("ret_msg"));
		return response;
	}

	
}
