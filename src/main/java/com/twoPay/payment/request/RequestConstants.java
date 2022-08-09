package com.twoPay.payment.request;

public interface RequestConstants {
	
	/*
	 * 网关
	 */
	String SANDBOX_PREFIX = "https://api.2pay.co";
	String PRODUCT_PREFIX = "https://api.2pay.co";
	
	/*
	 * online接口后缀
	 */
	String ONLINE_SECUREPAY = "/online/v1/secure-pay";
	String UPDATE_RECURRING = "/creditpay/v3/update-recurring";
	String PROCESS = "/creditpay/v3/process";


	/*
	 * data-search
	 */
	String REFUND = "/app-data-search/v1/refund";
	String CANCEL = "/app-data-search/v1/cancel";
	String TRAN_QUERY = "/app-data-search/v1/tran-query";

	


	/*
	 * auto debit
	 */
	String AUTO_CONSULT = "/auto-debit/v1/consult";
	String AUTO_APPLY_TOKEN = "/auto-debit/v1/apply-token";
	String AUTO_PAY = "/auto-debit/v1/pay";
	String AUTO_REVOKE = "/auto-debit/v1/revoke";
	
}
