package com.twoPay.payment.request.online;

import com.twoPay.payment.exception.TwoPayException;
import com.twoPay.payment.response.online.OnlineSecurepayResponse;
import org.apache.commons.lang.StringUtils;

import com.twoPay.payment.request.RequestConstants;
import com.twoPay.payment.request.TwoPayRequest;
import com.twoPay.payment.utils.JSONUtils;

import net.sf.json.JSONObject;

/**
 * @author 2pay
 */
public class OnlineSecurepayRequest extends TwoPayRequest<OnlineSecurepayResponse> {
	 
	private String amount;						//美金金额
	private String currency;					//币种
	private String reference;					//商户支付流水号
	private String vendor;						//渠道
	private String terminal;					//客户端类型 包括 ONLINE，WAP
	private Integer timeout;					//过期时间
	private String ipnUrl;						//异步回调地址
	private String callbackUrl;					//同步回调地址
	private String goodsInfo;					//商品信息，要求json格式
	private String description;					//订单描述，会展示在收银台页面

	
	public String getAmount() {
		return amount;
	}
	public OnlineSecurepayRequest setAmount(String amount) {
		this.amount = amount;
		return this;
	}
	public String getCurrency() {
		return currency;
	}
	public OnlineSecurepayRequest setCurrency(String currency) {
		this.currency = currency;
		return this;
	}
	public String getVendor() {
		return vendor;
	}
	public OnlineSecurepayRequest setVendor(String vendor) {
		this.vendor = vendor;
		return this;
	}
	public String getIpnUrl() {
		return ipnUrl;
	}
	public OnlineSecurepayRequest setIpnUrl(String ipnUrl) {
		this.ipnUrl = ipnUrl;
		return this;
	}
	public String getCallbackUrl() {
		return callbackUrl;
	}
	public OnlineSecurepayRequest setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
		return this;
	}
	public String getTerminal() {
		return terminal;
	}
	public OnlineSecurepayRequest setTerminal(String terminal) {
		this.terminal = terminal;
		return this;
	}
	public String getDescription() {
		return description;
	}
	public OnlineSecurepayRequest setDescription(String description) {
		this.description = description;
		return this;
	}

	public Integer getTimeout() {
		return timeout;
	}
	public OnlineSecurepayRequest setTimeout(Integer timeout) {
		this.timeout = timeout;
		return this;
	}
	public String getGoodsInfo() {
		return goodsInfo;
	}
	public OnlineSecurepayRequest setGoodsInfo(String goodsInfo) {
		this.goodsInfo = goodsInfo;
		return this;
	}
	
	public String getReference() {
		return reference;
	}
	public OnlineSecurepayRequest setReference(String reference) {
		this.reference = reference;
		return this;
	}
	


	//数据校验
	@Override
	protected void dataValidate() {
		//金额校验
		if (StringUtils.isEmpty(this.amount)) {
			throw new TwoPayException("amount missing");
		}  
		
		
		if (StringUtils.isEmpty(this.reference)) {
			throw new TwoPayException("reference missing");
		}
		
		//币种校验
		if (StringUtils.isEmpty(this.currency)) {
			throw new TwoPayException("currency missing.");
		}
		

		
		//vendor校验
		if (StringUtils.isEmpty(this.vendor)) {
			throw new TwoPayException("vendor missing.");
		}
		
		//terminal校验
		if (StringUtils.isEmpty(this.terminal)) {
			throw new TwoPayException("terminal missing");
		}
		
		//description,note校验
		if (StringUtils.isNotEmpty(this.description)) {
			if (this.description.length() > 100) {
				throw new TwoPayException("description is too big");
			}
		}

		//goodsInfo校验
		if (StringUtils.isNotEmpty(this.goodsInfo)) {
			boolean jsonFlag = JSONUtils.isStringJsonArrFormat(this.goodsInfo);
			if (!jsonFlag) {
				throw new TwoPayException("goodsInfo should be json array format");
			}
		}
		
	}

	@Override
	protected String getAPIUrl(String env) {
		String urlPrefix = getUrlPrefix(env);
		String url = urlPrefix + RequestConstants.ONLINE_SECUREPAY;
		return url;
	}
	
	
	
	@Override
	public OnlineSecurepayResponse convertResponse(String ret) {
		OnlineSecurepayResponse response = new OnlineSecurepayResponse();
		JSONObject json = JSONObject.fromObject(ret);
		if (null != json.get("result")) {
			response.setResult(json.getJSONObject("result"));
		}
		response.setRetCode(json.getString("ret_code"));
		response.setRetMsg(json.getString("ret_msg"));
		return response;
	}
	
}
