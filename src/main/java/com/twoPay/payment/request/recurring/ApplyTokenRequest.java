package com.twoPay.payment.request.recurring;

import com.twoPay.payment.exception.TwoPayException;
import com.twoPay.payment.response.recurring.ApplyTokenResponse;
import org.apache.commons.lang.StringUtils;

import com.twoPay.payment.request.RequestConstants;
import com.twoPay.payment.request.TwoPayRequest;

import net.sf.json.JSONObject;

public class ApplyTokenRequest extends TwoPayRequest<ApplyTokenResponse> {

	private String autoDebitNo;
	
	private String grantType;

	public String getAutoDebitNo() {
		return autoDebitNo;
	}

	public ApplyTokenRequest setAutoDebitNo(String autoDebitNo) {
		this.autoDebitNo = autoDebitNo;
		return this;
	}

	public String getGrantType() {
		return grantType;
	}

	public ApplyTokenRequest setGrantType(String grantType) {
		this.grantType = grantType;
		return this;
	}

	@Override
	protected void dataValidate() {
		if (StringUtils.isEmpty(this.autoDebitNo)) {
			throw new TwoPayException("autoDebitNo missing");
		}
		if (StringUtils.isEmpty(this.grantType)) {
			throw new TwoPayException("grantType missing");
		}
	}

	@Override
	protected String getAPIUrl(String env) {
		String urlPrefix = getUrlPrefix(env);
		String url = urlPrefix + RequestConstants.AUTO_APPLY_TOKEN;
		return url;
	}

	@Override
	public ApplyTokenResponse convertResponse(String ret) {
		ApplyTokenResponse response = new ApplyTokenResponse();
		JSONObject json = JSONObject.fromObject(ret);
		if (null != json.get("result")) {
			response.setResult(json.getJSONObject("result"));
		}
		response.setRetCode(json.getString("ret_code"));
		response.setRetMsg(json.getString("ret_msg"));
		return response;
	}
	
	
	
}
