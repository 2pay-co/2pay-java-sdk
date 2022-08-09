package com.twoPay.payment.exception;

public class TwoPayException extends RuntimeException {
	private static final long serialVersionUID = -1177057547937718630L;

	public TwoPayException(String msg) {
		super(msg);
	}
}
