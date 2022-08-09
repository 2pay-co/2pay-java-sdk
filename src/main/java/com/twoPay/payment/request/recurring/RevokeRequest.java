package com.twoPay.payment.request.recurring;

import com.twoPay.payment.exception.TwoPayException;
import com.twoPay.payment.response.recurring.RevokeResponse;
import org.apache.commons.lang.StringUtils;

import com.twoPay.payment.request.RequestConstants;
import com.twoPay.payment.request.TwoPayRequest;

import net.sf.json.JSONObject;

public class RevokeRequest extends TwoPayRequest<RevokeResponse> {

	private String autoDebitNo;

	public String getAutoDebitNo() {
		return autoDebitNo;
	}

	public RevokeRequest setAutoDebitNo(String autoDebitNo) {
		this.autoDebitNo = autoDebitNo;
		return this;
	}

	@Override
	protected void dataValidate() {
		if (StringUtils.isEmpty(this.autoDebitNo)) {
			throw new TwoPayException("autoDebitNo missing");
		}
	}

	@Override
	protected String getAPIUrl(String env) {
		String urlPrefix = getUrlPrefix(env);
		String url = urlPrefix + RequestConstants.AUTO_REVOKE;
		return url;
	}

	@Override
	public RevokeResponse convertResponse(String ret) {
		RevokeResponse response = new RevokeResponse();
		JSONObject json = JSONObject.fromObject(ret);
		if (null != json.get("result")) {
			response.setResult(json.getJSONObject("result"));
		}
		response.setRetCode(json.getString("ret_code"));
		response.setRetMsg(json.getString("ret_msg"));
		return response;
	}
	
	
	
}
