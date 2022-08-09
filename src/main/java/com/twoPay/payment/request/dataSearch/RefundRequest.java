package com.twoPay.payment.request.dataSearch;

import com.twoPay.payment.response.dataSearch.RefundResponse;
import com.twoPay.payment.request.ParamValidator;
import com.twoPay.payment.request.RequestConstants;
import com.twoPay.payment.request.TwoPayRequest;

import net.sf.json.JSONObject;

public class RefundRequest extends TwoPayRequest<RefundResponse> {

	private String amount;							//美金金额	
	private String reference;						//商户支付流水号
	
	
	public String getamount() {
		return amount;
	}

	public RefundRequest setamount(String amount) {
		this.amount = amount;
		return this;
	}


	public String getReference() {
		return reference;
	}

	public RefundRequest setReference(String reference) {
		this.reference = reference;
		return this;
	}


	@Override
	protected void dataValidate() {
		ParamValidator.amountValidate("amount", this.amount);
	}

	@Override
	protected String getAPIUrl(String env) {
		String urlPrefix = getUrlPrefix(env);
		String url = urlPrefix + RequestConstants.REFUND;
		return url;
	}


	@Override
	public RefundResponse convertResponse(String ret) {
		RefundResponse response = new RefundResponse();
		JSONObject json = JSONObject.fromObject(ret);
		if (null != json.get("result")) {
			response.setResult(json.getJSONObject("result"));
		}
		response.setRetCode(json.getString("ret_code"));
		response.setRetMsg(json.getString("ret_msg"));
		return response;
	}

}
