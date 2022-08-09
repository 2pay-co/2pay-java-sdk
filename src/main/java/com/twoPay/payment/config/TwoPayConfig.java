package com.twoPay.payment.config;

import java.io.Serializable;
import java.util.Map;

import com.twoPay.payment.exception.TwoPayException;
import org.apache.commons.lang.StringUtils;

import com.twoPay.payment.enums.EnviromentEnums;

/**
 * 圆支付配置信息
 * @author zhoukai
 *
 */
public class TwoPayConfig implements Serializable {
	private static final long serialVersionUID = -4008739773524288292L;
	private String env;						//环境类型
	private Integer merGroupSwitch = 0;		//是否开启服务商功能
	private String merGroupNo;				//服务商号
	private String merchantNo;				//商户号
	private String storeAdminNo;			//店员号
	private String token;					//token
	
	//给param中增加账户相关信息
	public Map<String, String> basicParamSetting(Map<String, String> param) {
		if (1 == this.merGroupSwitch) {
			param.put("merGroupNo", this.merGroupNo);
		}
		param.put("merchantNo", this.merchantNo);

		if (StringUtils.isNotEmpty(this.storeAdminNo)) {
			param.put("storeAdminNo", this.storeAdminNo);
		}
		return param;
	}
	
	public void basicValidate() {
		if (StringUtils.isEmpty(this.env)) {
			throw new TwoPayException("env missing");
		} else {
			boolean flag = false;
			for (EnviromentEnums en : EnviromentEnums.values()) {
				if (en.getValue().equals(this.env)) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				throw new TwoPayException("data error: env");
			}
		}
		if (null == this.merGroupSwitch) {
			throw new TwoPayException("merGroupSwitch missing");
		}
		if (0 != this.merGroupSwitch && 1 != this.merGroupSwitch) {
			throw new TwoPayException("data error: merGroupSwitch");
		}
		if (1 ==  this.merGroupSwitch) {
			if (StringUtils.isEmpty(this.merGroupNo)) {
				throw new TwoPayException("merGroupNo missing");
			}
		}
		if (StringUtils.isEmpty(this.merchantNo)) {
			throw new TwoPayException("merchantNo missing");
		}
	}
	

	public String getMerGroupNo() {
		return merGroupNo;
	}

	public TwoPayConfig setMerGroupNo(String merGroupNo) {
		this.merGroupNo = merGroupNo;
		return this;
	}

	public Integer getMerGroupSwitch() {
		return merGroupSwitch;
	}

	public TwoPayConfig setMerGroupSwitch(Integer merGroupSwitch) {
		this.merGroupSwitch = merGroupSwitch;
		return this;
	}
	
	public String getMerchantNo() {
		return merchantNo;
	}
	public TwoPayConfig setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
		return this;
	}

	public String getEnv() {
		return env;
	}
	public TwoPayConfig setEnv(String env) {
		this.env = env;
		return this;
	}
	public String getStoreAdminNo() {
		return storeAdminNo;
	}
	public TwoPayConfig setStoreAdminNo(String storeAdminNo) {
		this.storeAdminNo = storeAdminNo;
		return this;
	}

	public String getToken() {
		return token;
	}

	public TwoPayConfig setToken(String token) {
		this.token = token;
		return this;
	}
}
