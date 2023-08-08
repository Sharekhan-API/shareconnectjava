#   Sharekhan API Java 

    Sharekhan API is a set of REST-like APIs that expose many capabilities required to build a complete investment and 
    trading platform. Execute orders in real time, stream live market data (WebSockets), and 
    more, with the simple HTTP API collection.
    
#   Usage


[Download Sharekhan API jar file](https://github.com/Sharekhan-API/shareconnectjava/tree/main/target/sharekhan-0.0.1-SNAPSHOT.jar) and include it in your build path.

    Use Java JDK Version 8
    Include package com.sharekhan into build path from maven. Use version 3.8.1
	
#   API usage
//  Instantiate the SharekhanConnect class 
	
	SharekhanConnect sharekhanConnect = new SharekhanConnect();
	
//	Instantiate the Example class to perform the testing for all the methods.
	
	Example examples = new Example();
	
//	getLoginUrl --> this will provide you with the login url which can be used to login in the sharekhan account. In-case of customer login leave the vendorkey as null n same for versionId , if not required leave it as null.

	public void getLoginURL(SharekhanConnect sharekhanConnect) throws SharekhanAPIException, IOException {
		String apiKey = "Enter-your-apiKey";
		String vendor_key = "Enter-your-vendorKey";  //optional
		String version_id= "Enter-versionID";  //optional
		String state = "12345";
		String response = (sharekhanConnect).getLoginURL(apiKey,vendor_key,version_id,state);
		System.out.print(response); 
	}
	

	
//	GenerateSession--> provide the requestToken received after successful login with apiKey, state, secret key and vendorKey if it is a vendor login,in case of customer login leave it null.
    This will provide the accessToken after the decrypt and encrypt part. While providing the versionId the requestToken will be decrypted/encrypted through Base64.getUrlEncoder() n Base64.getUrlDecoder(). 
    VersionId allowed to be passed - 1005/1006.
	
	public void generateSession(SharekhanConnect sharekhanConnect) throws SharekhanAPIException, IOException {
		String apiKey = "Enter-your-apiKey";
		String requestToken = "Enter-your-requestToken";
		String vendor_key = "Enter-your-vendorKey";     //optional
		String state = "12345";
		String secretKey ="Enter-your-secretKey";
		Long versionId=(long) 11111;
		
		JSONObject response = sharekhanConnect.generateSession(apiKey,requestToken,vendor_key,state,secretKey,versionId);
		System.out.print(response.toString(4));
		
	}
	
//    GenerateSession without versionId--> provide the requestToken received after successful login with apiKey, state, secret key and vendorKey if it is a vendor login,in case of customer login leave it null.
    This will provide the accessToken after the decrypt and encrypt part. Without versionId you can decrypt/encrypt the requestToken using Base64.getDecoder() n Base64.getEncoder().
	
	public void generateSessionWithoutVersionId(SharekhanConnect sharekhanConnect) throws SharekhanAPIException, IOException {
		String apiKey = "Enter-your-apiKey";
		String requestToken = "Enter-your-requestToken";
		String vendor_key = "Enter-your-vendorKey";      //optional
		String state = "12345";
		String secretKey ="Enter-your-secretKey";
		
		JSONObject response = sharekhanConnect.generateSessionWithoutVersionId(apiKey,requestToken,vendor_key,state,secretKey);
		System.out.print(response.toString(4));
		
	}
	
//	add apiKey n accessToken n vendorKey(optional) in the SharekhanConnect constructor
	
	SharekhanConnect sharekhanConnect = new SharekhanConnect("<api-key>","<access-token>","<vendor-key>");
	
//	Place Order
	
	public void placeOrder(SharekhanConnect sharekhanConnect) throws SharekhanAPIException, IOException {
			OrderParams orderParams = new OrderParams();
		    orderParams.customerId = (long) XXXXXXXX;
			orderParams.scripCode = 2475;
			orderParams.disclosedQty = (long) 0;
			orderParams.validity = "GFD";
			orderParams.quantity = (long) 1;
			orderParams.symbolToken = "1660";
			orderParams.exchange = "NC";
			orderParams.orderType ="NORMAL";
			orderParams.tradingSymbol = "ONGC";
			orderParams.productType = "INV";      (INVESTMENT or (INV), BIGTRADE or (BT), BIGTRADEPLUS or (BT+))
			orderParams.transactionType = "B";    (B, S, BM, SM, SAM)
			orderParams.price = "139.85";
			orderParams.triggerPrice = "0";
			orderParams.rmsCode= "ANY";
			orderParams.afterHour= "N";
			orderParams.channelUser="XXXXXX";     //enter the customerid
			orderParams.requestType="NEW";
			// Below parameters need to be added for FNO trading
			orderParams.instrumentType="FUTCUR";  (Future Stocks(FS)/ Future Index(FI)/ Option Index(OI)/ Option Stocks(OS)/ Future Currency(FUTCUR)/ Option Currency(OPTCUR))        
			orderParams.strikePrice="-1";                                                                                                                   
			orderParams.optionType="XX";     (XX/PE/CE)       
			orderParams.expiry="31/03/2023";     

		    JSONObject order = sharekhanConnect.placeOrder(orderParams);
	
	}
	
//	Modify Order
	
	public void modifyOrder(SharekhanConnect sharekhanConnect) throws SharekhanAPIException, IOException {

		OrderParams orderParams = new OrderParams();
		orderParams.orderId = "XXXXX";
		 orderParams.customerId = (long) XXXXXXXX;
			orderParams.scripCode = 2475;
			orderParams.disclosedQty = (long) 0;
			orderParams.validity = "GFD";
			orderParams.quantity = (long) 1;
			orderParams.symbolToken = "1660";
			orderParams.exchange = "NC";
			orderParams.orderType ="NORMAL";
			orderParams.tradingSymbol = "ONGC";
			orderParams.productType = "INV";      (INVESTMENT or (INV), BIGTRADE or (BT), BIGTRADEPLUS or (BT+))
			orderParams.transactionType = "B";    ( B, S, BM, SM, SAM)
			orderParams.price = "139.85";
			orderParams.triggerPrice = "0";
			orderParams.rmsCode= "ANY";
			orderParams.afterHour= "N";
			orderParams.channelUser="XXXXXX";          //enter the customerid
			orderParams.requestType="MODIFY";
			// Below parameters need to be added for FNO trading
			orderParams.instrumentType="FUTCUR";  (Future Stocks(FS)/ Future Index(FI)/ Option Index(OI)/ Option Stocks(OS)/ Future Currency(FUTCUR)/ Option Currency(OPTCUR))        
			orderParams.strikePrice="-1";                                                                                                                   
			orderParams.optionType="XX";     (XX/PE/CE)       
			orderParams.expiry="31/03/2023"; 
	
		JSONObject order = sharekhanConnect.modifyorder(orderParams);
		
	}
	
//	Cancel order
	
	public void cancelOrder(SharekhanConnect sharekhanConnect) throws SharekhanAPIException, IOException {

		OrderParams orderParams = new OrderParams();
		orderParams.orderId = "XXXXXX";
		 orderParams.customerId = (long) XXXXXXXX;
			orderParams.scripCode = 2475;
			orderParams.disclosedQty = (long) 0;
			orderParams.validity = "GFD";
			orderParams.quantity = (long) 1;
			orderParams.symbolToken = "1660";
			orderParams.exchange = "NC";
			orderParams.orderType ="NORMAL";
			orderParams.tradingSymbol = "ONGC";
			orderParams.productType = "INV";      (INVESTMENT or (INV), BIGTRADE or (BT), BIGTRADEPLUS or (BT+))
			orderParams.transactionType = "B";    ( B, S, BM, SM, SAM)
			orderParams.price = "139.85";
			orderParams.triggerPrice = "0";
			orderParams.rmsCode= "ANY";
			orderParams.afterHour= "N";
			orderParams.channelUser="XXXXXX";         //enter the customerid
			orderParams.requestType="CANCEL";
			// Below parameters need to be added for FNO trading
			orderParams.instrumentType="FUTCUR";  (Future Stocks(FS)/ Future Index(FI)/ Option Index(OI)/ Option Stocks(OS)/ Future Currency(FUTCUR)/ Option Currency(OPTCUR))        
			orderParams.strikePrice="-1";                                                                                                                   
			orderParams.optionType="XX";     (XX/PE/CE)       
			orderParams.expiry="31/03/2023"; 
	
		JSONObject order = sharekhanConnect.cancelOrder(orderParams);
		
	}
	
//	Funds --> limit_statement
	
	public void getFunds(SharekhanConnect sharekhanConnect) throws SharekhanAPIException, IOException {
		String exchange = "NC";
		Long customerId = (long) XXXXXXX;
		JSONObject response = sharekhanConnect.getFunds(exchange,customerId);
	}
	
//	Order --> orders_history
	
	public void getOrder(SharekhanConnect sharekhanConnect) throws SharekhanAPIException, IOException {
		
		Long customerId = (long) XXXXXX;
		JSONObject response = sharekhanConnect.getOrder(customerId);
	}
	
//	Position --> trades_history
	
	public void getPosition(SharekhanConnect sharekhanConnect) throws SharekhanAPIException, IOException {
		
		Long customerId = (long) XXXXXXXX;
		JSONObject response = sharekhanConnect.getPosition(customerId);
	}
	
//	Order History -->order_history
	
	public void orderHistory(SharekhanConnect sharekhanConnect) throws SharekhanAPIException, IOException {
		String exchange = "NC";
		Long customerId = (long) XXXXXXX;
		String orderId="XXXXXX";
		JSONObject response = sharekhanConnect.orderHistory(exchange,customerId,orderId);
	}
	
//	Trade --> trade_history
	
	public void getTrades(SharekhanConnect sharekhanConnect) throws SharekhanAPIException, IOException {
		String exchange = "NC";
		Long customerId = (long) XXXXXXXX;
		String orderId="XXXXXX";
		JSONObject response = sharekhanConnect.getTrades(exchange,customerId,orderId);
	}
	
//	Holdings --> holdings
	
	public void getHolding(SharekhanConnect sharekhanConnect) throws SharekhanAPIException, IOException {
		
		Long customerId = (long) XXXXXXX;
		JSONObject response = sharekhanConnect.getHolding(customerId);
	}
	
//	Active Scripts --> master
	 
	 public void getActiveScript(SharekhanConnect sharekhanConnect) throws SharekhanAPIException, IOException {
		
    	String exchange = "NC";
    		JSONObject response = sharekhanConnect.getActiveScript(exchange);
    	}
    	

	
//	Historical
	
	public void getHistorical(SharekhanConnect sharekhanConnect) throws SharekhanAPIException, IOException {
		
    	String exchange = "MX";
    	String scripCode = "251800";
    	String interval="daily";
    		JSONObject response = sharekhanConnect.getHistorical(exchange,scripCode,interval);
    	}

#   WebSocket live streaming data

        public void sharekhanWebSocketUsage(String accessToken)
	
			throws SharekhanAPIException {

		final SharekhanWebsocket sharekhanWebsocket = new SharekhanWebsocket(accessToken);
		
//		Subscribe request

		JSONObject jsonObject = new JSONObject();
		JSONArray keyArray = new JSONArray();
		JSONArray valueArray = new JSONArray();

		jsonObject.put("action", "subscribe");
		keyArray.put("feed");
		valueArray.put("");
		jsonObject.put("key", keyArray);
		jsonObject.put("value", valueArray);
		final JSONObject subscribe = jsonObject;

//		Feed Request--> You can send the action as feed/ack as per as requirement.

		JSONObject jsonObject1 = new JSONObject();
		JSONArray keyArray1 = new JSONArray();
		JSONArray valueArray1 = new JSONArray();

		jsonObject1.put("action", "feed");
		keyArray1.put("ltp");
		valueArray1.put("MX250057");
		jsonObject1.put("key", keyArray1);
		jsonObject1.put("value", valueArray1);
		
		final JSONObject feed = jsonObject1;
		
		
//		Unsubscribe request

		JSONObject jsonObject2 = new JSONObject();
		JSONArray keyArray2 = new JSONArray();
		JSONArray valueArray2 = new JSONArray();

		jsonObject2.put("action", "unsubscribe");
		keyArray2.put("feed");
		valueArray2.put("NC22,NF37833,NF37834,MX253461,RN7719");
		jsonObject2.put("key", keyArray2);
		jsonObject2.put("value", valueArray2);
		
		final JSONObject unsubscribe = jsonObject2;

		sharekhanWebsocket.setOnConnectedListener(new  SharekhanWSOnConnect() {
			@Override
			public void onConnected() {
				sharekhanWebsocket.subscribe(subscribe);
				System.out.println("subscribe request sent!");
				sharekhanWebsocket.subscribe(feed);
				System.out.println("feed request sent!");
				
				sharekhanWebsocket.unsubscribe(unsubscribe);
				
    			System.out.println("unsubscribe request sent!");
		
			
			}
		});
		
		sharekhanWebsocket.setOnTickerArrivalListener(new SharekhanWSOnTicks() {
		    @Override
		    public void onTicks(JSONObject ticks) {
		    
		        System.out.println("Ticker data received: " + ticks.toString(4));
		        
		    }
		});

		
		sharekhanWebsocket.setOnDisconnectedListener(new SharekhanWSOnDisconnect() {
			@Override
			public void onDisconnected() {
				System.out.println("Disconnected");
			}
		});

		/** Set error listener to listen to errors. */
		sharekhanWebsocket.setOnErrorListener(new SharekhanWSOnError() {
			@Override
			public void onError(Exception exception) {
				System.out.println("onError: " + exception.getMessage());
			}

			@Override
			public void onError(SharekhanAPIException sharekhanAPIException) {
				System.out.println("onError: " + sharekhanAPIException.getMessage());
			}

			@Override
			public void onError(String error) {
				System.out.println("onError: " + error);
			}
		});

		
//		Connection	
	
	    /**
		 * connects to Sharekhan API ticker server for getting live quotes
		 */
		sharekhanWebsocket.connect();
		
		/**
		 * You can check, if websocket connection is open or not using the following
		 * method.
		 */
		boolean isConnected = sharekhanWebsocket.isConnectionOpen();
		System.out.println(isConnected);
		
//		Disconnection		

		// After using SharekhanAPI ticker, close websocket connection.
		sharekhanWebsocket.disconnect();
		
		
		
	}

	
	
	
	
