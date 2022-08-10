# 2Pay JAVA SDK

[2Pay API](https://2pay.gitbook.io/2pay-api-docs-en/)


## Requirements

- JAVA >= 1.8


### 1. Init
```java
TwoPayConfig config = new TwoPayConfig();
config.setEnv(EnviromentEnums.SANDBOX.getValue())
        .setMerchantNo("M1659370481867")
        .setToken("yjmsy9v5o2kam2sjsct4psc2o8y3rr5q");
TwoPayClient client = new TwoPayV100Client(InitTwoPayConfig.initMerchantConfig()); 
```



### 2. Online API
```java
		TwoPayClient client = new TwoPayV100Client(InitTwoPayConfig.initMerchantConfig());
		
		JSONArray goods = new JSONArray();
		JSONObject item = new JSONObject();
		item.put("goods_name","name1");
		item.put("quantity", "1");
		goods.add(item);
		OnlineSecurepayRequest request = new OnlineSecurepayRequest();
		request.setAmount("0.01")
				.setCurrency("USD")
				.setVendor("alipay")
				.setTerminal("WAP")
				.setReference(System.nanoTime()+"")
				.setIpnUrl("http://xxxxxx/ttest/test")
				.setCallbackUrl("http://xxxxx/ttest/test")
				.setDescription("testDescription")
				.setGoodsInfo(goods.toString());
		OnlineSecurepayResponse response = client.execute(request);
		System.out.println(JSONObject.fromObject(response));

		RefundRequest rfd = new RefundRequest();
		rfd.setamount("1000000");
		rfd.setReference("6ce3653f-5365-4bcd-b596-e9007b683bec");
		RefundResponse rfs = client.execute(rfd);
		System.out.println(JSONObject.fromObject(rfs));
```

### 2. Refund API
```java 
RefundRequest rfd = new RefundRequest();
        rfd.setamount("1000000");
        rfd.setReference("6ce3653f-5365-4bcd-b596-e9007b683bec");
        RefundResponse rfs = client.execute(rfd);
        System.out.println(JSONObject.fromObject(rfs));
```

### 2. Trans Query API
```java
TranQueryRequest trq = new TranQueryRequest();
trq.setReference("f194b314-298b-4023-970e-a8701f77316d");
TranQueryResponse tfs = client.execute(trq);
System.out.println(JSONObject.fromObject(tfs)); 

```


