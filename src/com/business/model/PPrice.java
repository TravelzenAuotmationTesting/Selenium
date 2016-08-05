package com.business.model;

public class PPrice {
	
	
	public String grade;
	public String fare;
	public String percent;
	public String preferential;
	public String total;
	public String serviceCharge;
	/**
	 * @param grade
	 * @param fare
	 * @param percent
	 * @param preferential
	 * @param total
	 * @param serviceCharge
	 */
	public PPrice(String grade, String fare, String percent, String preferential, String total, String serviceCharge) {
		super();
		this.grade = grade;
		this.fare = fare;
		this.percent = percent;
		this.preferential = preferential;
		this.total = total;
		this.serviceCharge = serviceCharge;
	}

}
