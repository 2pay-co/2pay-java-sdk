package com.twoPay.payment.client;

import java.util.Map;

import com.twoPay.payment.config.TwoPayConfig;
import com.twoPay.payment.exception.TwoPayException;
import com.twoPay.payment.request.RequestBody;
import com.twoPay.payment.request.TwoPayRequest;
import com.twoPay.payment.response.TwoPayResponse;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.twoPay.payment.utils.OkHttpUtils;

import net.sf.json.JSONObject;

/**
 * 
 * @author 2pay
 * 2pay客户端
 * 
 * @version 2.0.0
 */
public class TwoPayV100Client implements TwoPayClient {
	private static final Logger logger = LoggerFactory.getLogger(TwoPayV100Client.class);
	private TwoPayConfig twopayConfig;
	
	public TwoPayV100Client(TwoPayConfig twopayConfig) {
		this.twopayConfig = twopayConfig;
	}
	

	@Override
	public <T extends TwoPayResponse> T execute(TwoPayRequest<T> request) {
		try {
	        //关联配置
	        if (null == twopayConfig) {
	        	logger.error("missing config information.");
	        	throw new TwoPayException("missing config information.");
	        } else {
	        	//基础权限数据校验
	        	twopayConfig.basicValidate();
	        }

	        RequestBody requestBody = request.initRequestBody(twopayConfig);
	        String url = requestBody.getUrl();
			Map<String, String> params = requestBody.getParams();
			
	        //业务数据校验
			JSONObject jsonParams;
			if (MapUtils.isNotEmpty(params)) {
				jsonParams = JSONObject.fromObject(params);
			} else {
				jsonParams = new JSONObject();
			}
			String transJson = jsonParams.toString();
			String responseBody = OkHttpUtils.doJsonPost(url, transJson);
			logger.info("2pay return:" + responseBody);
			if (StringUtils.isEmpty(responseBody)) {
				logger.error("2pay return null");
				throw new TwoPayException("fail to connect");
			}
			//解析返回
			return request.convertResponse(responseBody);
		} catch (Exception e) {
			throw new TwoPayException(e.getMessage());
		} finally {
		}
	}
	
	
}
