package online;

import com.twoPay.payment.client.TwoPayClient;
import com.twoPay.payment.client.TwoPayV100Client;
import com.twoPay.payment.request.dataSearch.RefundRequest;
import com.twoPay.payment.request.dataSearch.TranQueryRequest;
import com.twoPay.payment.request.online.OnlineSecurepayRequest;
import com.twoPay.payment.response.dataSearch.RefundResponse;

import com.twoPay.payment.response.dataSearch.TranQueryResponse;
import com.twoPay.payment.response.online.OnlineSecurepayResponse;
import common.InitTwoPayConfig;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class OnlineTest {


	public static void main(String[] args) {

		TwoPayClient client = new TwoPayV100Client(InitTwoPayConfig.initMerchantConfig());
//		
//		JSONArray goods = new JSONArray();
//		JSONObject item = new JSONObject();
//		item.put("goods_name","name1");
//		item.put("quantity", "1");
//		goods.add(item);
//		OnlineSecurepayRequest request = new OnlineSecurepayRequest();
//		request.setAmount("0.01")
//				.setCurrency("USD")
//				.setVendor("alipay")
//				.setTerminal("WAP")
//				.setReference(System.nanoTime()+"")
//				.setIpnUrl("http://xxxxxx/ttest/test")
//				.setCallbackUrl("http://xxxxx/ttest/test")
//				.setDescription("testDescription")
//				.setGoodsInfo(goods.toString());
//		OnlineSecurepayResponse response = client.execute(request);
//		System.out.println(JSONObject.fromObject(response));
//
//		RefundRequest rfd = new RefundRequest();
//		rfd.setamount("1000000");
//		rfd.setReference("6ce3653f-5365-4bcd-b912596-e7b683bec");
//		RefundResponse rfs = client.execute(rfd);
//		System.out.println(JSONObject.fromObject(rfs));


		TranQueryRequest trq = new TranQueryRequest();
		trq.setReference("f194b314-298b-4024-910e-a8701316d");
		TranQueryResponse tfs = client.execute(trq);
		System.out.println(JSONObject.fromObject(tfs));


	}
}
