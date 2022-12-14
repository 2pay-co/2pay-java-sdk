package com.twoPay.payment.request;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.twoPay.payment.exception.TwoPayException;
import org.apache.commons.lang.StringUtils;

public class ParamValidator {
	
	public static void numberValidate(String name, String value) {
		try {
			String el = "^[0-9]*[1-9][0-9]*$";
			Pattern pat = Pattern.compile(el);
			
			Matcher startMatcher = pat.matcher(value);
			boolean sflag = startMatcher.matches();
			
			if (!sflag) {
				throw new RuntimeException("data error: " + name);
			}
			
		} catch (Exception e) {
			throw new TwoPayException(e.getMessage());
		}
	}
	

	public static void dateValidate(String name, String value) {
		try {
			String eL= "^\\d{4}\\d{2}\\d{2}$"; 
			Pattern pat = Pattern.compile(eL);
			
			Matcher startMatcher = pat.matcher(value);
			boolean sflag = startMatcher.matches();
			
			if (!sflag) {
				throw new RuntimeException("data error: " + name);
			}
			
		} catch (Exception e) {
			throw new TwoPayException(e.getMessage());
		}
	}
	
	
	public static void amountValidate(String name, String value) { 
		if (StringUtils.isEmpty(value)) {
			throw new TwoPayException(name + " missing");
		} else {
			BigDecimal am = null;
			try {
				am = new BigDecimal(value);
			} catch (Exception e) {
				throw new TwoPayException("data error: " + name);
			}
			if (am.doubleValue() <= 0) {
				throw new TwoPayException("data error: " + name);
			}
		}
	}
}
