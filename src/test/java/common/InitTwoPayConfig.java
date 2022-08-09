package common;
import com.twoPay.payment.config.TwoPayConfig;
import com.twoPay.payment.enums.EnviromentEnums;

public class InitTwoPayConfig {

	public static TwoPayConfig initMerchantConfig() {
		TwoPayConfig config = new TwoPayConfig();
		config.setEnv(EnviromentEnums.SANDBOX.getValue())
				.setMerchantNo("M1654291281867")
				.setToken("yjamsklaanwqjsct4psc2o8y3rr5q");
		return config;
	}
	
	
	public static TwoPayConfig initIsvConfig() {
		TwoPayConfig config = new TwoPayConfig();
		config.setEnv(EnviromentEnums.SANDBOX.getValue())
				.setMerGroupNo("99j00001")
				.setMerchantNo("2020043")
				.setToken("3kljklasnw");
		return config;
	}
}
