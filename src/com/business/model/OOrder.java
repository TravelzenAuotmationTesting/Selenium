package com.business.model;

public class OOrder {

	public int index;
	public String operationtype;
	public String orderstatus;
	public String orderID;
	public String operator;
	public String efficiency;
	public String customername;
	public String PNRID;
	public String airline;
	public String airlineID;
	public String space;
	public String landofftime;
	public String passenagename;
	public String price;
	public String bonus;
	public String tax;
	public String total;
	public String supplier;
	public String autoapply;
	
	/**
	 * @param operationtype
	 * @param orderstatus
	 * @param orderID
	 * @param operator
	 * @param efficiency
	 * @param customername
	 * @param pNRID
	 * @param airline
	 * @param airlineID
	 * @param space
	 * @param landofftime
	 * @param passenagename
	 * @param price
	 * @param bonus
	 * @param tax
	 * @param total
	 * @param supplier
	 * @param autoapply
	 */
	public OOrder(int index, String operationtype, String orderstatus, String orderID, String operator, String efficiency,
			String customername, String pNRID, String airline, String airlineID, String space, String landofftime,
			String passenagename, String price, String bonus, String tax, String total, String supplier,
			String autoapply) {
		super();
		this.operationtype = operationtype;
		this.orderstatus = orderstatus;
		this.orderID = orderID;
		this.operator = operator;
		this.efficiency = efficiency;
		this.customername = customername;
		this.PNRID = pNRID;
		this.airline = airline;
		this.airlineID = airlineID;
		this.space = space;
		this.landofftime = landofftime;
		this.passenagename = passenagename;
		this.price = price;
		this.bonus = bonus;
		this.tax = tax;
		this.total = total;
		this.supplier = supplier;
		this.autoapply = autoapply;
	}

}
