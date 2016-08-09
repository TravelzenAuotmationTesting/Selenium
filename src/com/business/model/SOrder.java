package com.business.model;

public class SOrder {

	public int index;
	public String operationtype;//
	public String orderstatus;//
	public String orderID;//
	public String PNRID;//
	public String airlineinfo;//
	public String voyage;//
	public String landofftime;//
	public String booktime;//
	public String efficiency;//
	public String total;
	public String price;//
	public String tax;//
	public String bonus;//
	public String passenagename;//
	public String operator;//
	public String original;
	public String comment;

	/**
	 * @param index
	 * @param operationtype
	 * @param orderstatus
	 * @param orderID
	 * @param pNRID
	 * @param airlineinfo
	 * @param voyage
	 * @param landofftime
	 * @param booktime
	 * @param efficiency
	 * @param total
	 * @param price
	 * @param tax
	 * @param bonus
	 * @param passenagename
	 * @param operator
	 * @param original
	 * @param comment
	 */
	public SOrder(int index, String operationtype, String orderstatus, String orderID, String pNRID, String airlineinfo,
			String voyage, String landofftime, String booktime, String efficiency, String total, String price,
			String tax, String bonus, String passenagename, String operator, String original, String comment) {
		this.index = index;
		this.operationtype = operationtype;
		this.orderstatus = orderstatus;
		this.orderID = orderID;
		this.PNRID = pNRID;
		this.airlineinfo = airlineinfo;
		this.voyage = voyage;
		this.landofftime = landofftime;
		this.booktime = booktime;
		this.efficiency = efficiency;
		this.total = total;
		this.price = price;
		this.tax = tax;
		this.bonus = bonus;
		this.passenagename = passenagename;
		this.operator = operator;
		this.original = original;
		this.comment = comment;
	}

}
