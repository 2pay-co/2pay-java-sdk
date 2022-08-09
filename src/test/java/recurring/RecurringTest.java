package recurring;

import com.twoPay.payment.client.TwoPayClient;
import com.twoPay.payment.client.TwoPayV100Client;
import com.twoPay.payment.request.recurring.ApplyTokenRequest;
import com.twoPay.payment.request.recurring.AutoPayRequest;
import com.twoPay.payment.request.recurring.ConsultRequest;
import com.twoPay.payment.request.recurring.RevokeRequest;
import com.twoPay.payment.response.recurring.ApplyTokenResponse;
import com.twoPay.payment.response.recurring.AutoPayResponse;
import com.twoPay.payment.response.recurring.ConsultResponse;
import com.twoPay.payment.response.recurring.RevokeResponse;

import common.InitTwoPayConfig;
import net.sf.json.JSONObject;

public class RecurringTest {

	public static void main(String[] args) {
		TwoPayClient client = new TwoPayV100Client(InitTwoPayConfig.initMerchantConfig());
		
//		consult(client);
		
//		applyToken(client);
		
		autoPay(client);
		
//		revoke(client);
	}
	
	public static void consult(TwoPayClient client) {
		
		ConsultRequest request = new ConsultRequest();
		request.setOsType("IOS")
				.setOsVersion("14.0.1")
				.setAutoIpnUrl("http://zk-tys.yunkeguan.com/ttest/test")
				.setAutoRedirectUrl("http://zk-tys.yunkeguan.com/tteest/test2")
				.setTerminal("ONLINE")
				.setVendor("gcash")
				.setAutoReference(System.nanoTime()+"");
		
		ConsultResponse response = client.execute(request);
		System.out.println(JSONObject.fromObject(response));
	}
	
	public static void applyToken(TwoPayClient client) {
		ApplyTokenRequest request = new ApplyTokenRequest();
		
		request.setAutoDebitNo("391807487291286634")
				.setGrantType("AUTHORIZATION_CODE");
		
		ApplyTokenResponse response = client.execute(request);
		System.out.println(JSONObject.fromObject(response));
	}
	
	public static void autoPay(TwoPayClient client) {
		AutoPayRequest request = new AutoPayRequest();
		
		request.setAmount("1")
				.setAutoDebitNo("391807487291286634")
				.setCurrency("PHP")
				.setSettleCurrency("USD")
				.setIpnUrl("http://zk-tys.yunkeguan.com/ttest/test")
				.setReference(System.nanoTime()+"");
		
		AutoPayResponse response = client.execute(request);
		System.out.println(JSONObject.fromObject(response));
	}
	
	public static void revoke(TwoPayClient client) {
		RevokeRequest request = new RevokeRequest();
		
		request.setAutoDebitNo("391807487291286634");
		
		RevokeResponse response = client.execute(request);
		System.out.println(JSONObject.fromObject(response));
	}
}
