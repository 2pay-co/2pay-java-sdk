package com.twoPay.payment.request.recurring;

import com.twoPay.payment.exception.TwoPayException;
import com.twoPay.payment.response.recurring.AutoPayResponse;
import org.apache.commons.lang.StringUtils;

import com.twoPay.payment.request.ParamValidator;
import com.twoPay.payment.request.RequestConstants;
import com.twoPay.payment.request.TwoPayRequest;

import net.sf.json.JSONObject;

public class AutoPayRequest extends TwoPayRequest<AutoPayResponse> {

	private String autoDebitNo;
	
	private String amount;
	
	private String currency;
	
	private String settleCurrency;
	
	private String reference;
	
	private String ipnUrl;

	public String getAutoDebitNo() {
		return autoDebitNo;
	}

	public AutoPayRequest setAutoDebitNo(String autoDebitNo) {
		this.autoDebitNo = autoDebitNo;
		return this;
	}

	public String getAmount() {
		return amount;
	}

	public AutoPayRequest setAmount(String amount) {
		this.amount = amount;
		return this;
	}

	public String getCurrency() {
		return currency;
	}

	public AutoPayRequest setCurrency(String currency) {
		this.currency = currency;
		return this;
	}

	public String getSettleCurrency() {
		return settleCurrency;
	}

	public AutoPayRequest setSettleCurrency(String settleCurrency) {
		this.settleCurrency = settleCurrency;
		return this;
	}

	public String getReference() {
		return reference;
	}

	public AutoPayRequest setReference(String reference) {
		this.reference = reference;
		return this;
	}

	public String getIpnUrl() {
		return ipnUrl;
	}

	public AutoPayRequest setIpnUrl(String ipnUrl) {
		this.ipnUrl = ipnUrl;
		return this;
	}

	@Override
	protected void dataValidate() {
		if (StringUtils.isEmpty(this.autoDebitNo)) {
			throw new TwoPayException("autoDebitNo missing");
		}
		
		ParamValidator.amountValidate("amount", this.amount);
		
		if (StringUtils.isEmpty(this.currency)) {
			throw new TwoPayException("currency missing");
		}
		
		if (StringUtils.isEmpty(this.settleCurrency)) {
			throw new TwoPayException("settleCurrency missing");
		}
		
		if (StringUtils.isEmpty(this.reference)) {
			throw new TwoPayException("reference missing");
		}
		
		
 	}

	@Override
	protected String getAPIUrl(String env) {
		String urlPrefix = getUrlPrefix(env);
		String url = urlPrefix + RequestConstants.AUTO_PAY;
		return url;
	}

	@Override
	public AutoPayResponse convertResponse(String ret) {
		AutoPayResponse response = new AutoPayResponse();
		JSONObject json = JSONObject.fromObject(ret);
		if (null != json.get("result")) {
			response.setResult(json.getJSONObject("result"));
		}
		response.setRetCode(json.getString("ret_code"));
		response.setRetMsg(json.getString("ret_msg"));
		return response;
	}
	
	
	
}
