package com.twoPay.payment.request.online;

import com.twoPay.payment.exception.TwoPayException;
import com.twoPay.payment.response.online.UpdateRecurringResponse;
import org.apache.commons.lang.StringUtils;

import com.twoPay.payment.request.RequestConstants;
import com.twoPay.payment.request.TwoPayRequest;

import net.sf.json.JSONObject;

public class UpdateRecurringRequest extends TwoPayRequest<UpdateRecurringResponse> {

	private Integer paymentCount;
	private String status;
	
	
	
	public Integer getPaymentCount() {
		return paymentCount;
	}

	public UpdateRecurringRequest setPaymentCount(Integer paymentCount) {
		this.paymentCount = paymentCount;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public UpdateRecurringRequest setStatus(String status) {
		this.status = status;
		return this;
	}

	
	@Override
	protected void dataValidate() {
		if (null == this.paymentCount) {
			throw new TwoPayException("paymentCount missing");
		}
		if (this.paymentCount <= 0) {
			throw new TwoPayException("data error: paymentCount");
		}
		if (StringUtils.isEmpty(this.status)) {
			throw new TwoPayException("status missing");
		}
	}

	@Override
	protected String getAPIUrl(String env) {
		String urlPrefix = getUrlPrefix(env);
		String url = urlPrefix + RequestConstants.UPDATE_RECURRING;
		return url;
	}


	@Override
	public UpdateRecurringResponse convertResponse(String ret) {
		UpdateRecurringResponse response = new UpdateRecurringResponse();
		JSONObject json = JSONObject.fromObject(ret);
		response.setRetCode(json.getString("ret_code"));
		response.setRetMsg(json.getString("ret_msg"));
		return response;
	}
	
	
}
