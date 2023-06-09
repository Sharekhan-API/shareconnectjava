package com.sharekhan.model;

public class OrderParams {
	
//	Exchange in which instrument is listed
	public String orderId;
	
//	CustomerId of the user
	public Long customerId;
	
//	Scripcode of the instrument
	public Integer scripCode;
	
//	TradingSymbol of the instrument
	public String tradingSymbol;
	
//	Name of the exchange. Allowed parameters NC/BC/NF/RN/MX
	public String exchange;
	
//	Buy, Sell ,BM ,SM or SAM order. Allowed parameters (B, S, BM, SM, SAM)
	public String transactionType;
	
//	Number of orders to transact
	public Long quantity;
	
//	Quantity to be disclosed
	public Long disclosedQty;
	
//	The price at which the order should execute. For Market orders, the price should be zero
	public String price;
	
//	The price at which the order should be triggered
	public String triggerPrice;
	
//	Represents the RMSat which the order sent to exchange.
//	For new order, the RMSCode should be ANY.
//	For modify/cancel, the RMS code should be specific RMSCode
	public String rmsCode;
	
//	After Hour order(N/Y). Y means After Hour order
	public String afterHour;
	
//	Order Type(Normal)
	public String orderType;
	
//	LoginId of the user
	public String channelUser;
	
//	Validity of an order (GFD/MyGTD/IOC)
	public String validity;
	
//	Date for MyGTD orders
	public String gtdd;
	
//	Request Type (New, Modify or Cancel)
	public String requestType;
	
//	Product Type-> (INVESTMENT or (INV), BIGTRADE or (BT), BIGTRADEPLUS or (BT+))
	public String productType;
	
	public String symbolToken;
	

// Order duration (DAY, IOC).
	public String duration;
	
	public Long executedQty;

//	InstrumentType -> (Future Stocks(FS)/ Future Index(FI)/ Option Index(OI)/ Option Stocks(OS)/ Future Currency(FUTCUR)/ Option Currency(OPTCUR))
	public String instrumentType;

	public String strikePrice;

//	OptionType-> (XX/PE/CE)     
	public String optionType;

	public String expiry;
	
	
	
	
}

