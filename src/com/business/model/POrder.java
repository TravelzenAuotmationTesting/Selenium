package com.business.model;

import java.util.List;

public class POrder {
	
	
	public String airline;
	public String landofftime;
	public String landtime;
	public String starting;
	public String destination;
	public List<PPrice> prices;


	/**
	 * @param airline
	 * @param landofftime
	 * @param landtime
	 * @param starting
	 * @param destination
	 * @param prices
	 */
	public POrder(String airline, String landofftime, String landtime, String starting, String destination,
			List<PPrice> prices) {
		super();
		this.airline = airline;
		this.landofftime = landofftime;
		this.landtime = landtime;
		this.starting = starting;
		this.destination = destination;
		this.prices = prices;
	}
	
	

}
