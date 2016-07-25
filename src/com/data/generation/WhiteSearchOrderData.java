package com.data.generation;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WhiteSearchOrderData {

	public int singleTrip;
	public int shuttleTrip;
	public String startCity;
	public String endCity;
	public String startDate;
	public String backDate;
	public String departureTimeFrom;
	public String departureTimeTo;
	public String airLine;
	public String customerName;

	public WhiteSearchOrderData() {
		this.singleTrip = Math.random() > 0.5 ? 1 : 0;
		
		//Temporary
		this.startCity = "PVG";
		this.endCity = "CTU";

		// startDate = Date + 3Month
		SimpleDateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 3);
		cal.set(Calendar.DAY_OF_MONTH, (int)(Math.random()*29)+1);
		this.startDate = dateFormate.format(cal.getTime());

		// backDate = startDate+1Day
		cal.add(Calendar.DAY_OF_MONTH, 1);
		this.backDate = dateFormate.format(cal.getTime());
		
		int departureTime =(int)(Math.random()*25);
		this.departureTimeTo= String.valueOf(departureTime)+":00";
		this.departureTimeFrom=String.valueOf((int)(Math.random()*departureTime))+":00";
		
		//Temporary
		this.airLine="MU";
		this.customerName="CW";

	}

	public WhiteSearchOrderData(int singleTrip, int shuttleTrip, String startCity, String endCity, String startDate,
			String backDate, String departureTimeFrom, String departureTimeTo, String airLine, String customerName) {
		super();
		this.singleTrip = singleTrip;
		this.shuttleTrip = shuttleTrip;
		this.startCity = startCity;
		this.endCity = endCity;
		this.startDate = startDate;
		this.backDate = backDate;
		this.departureTimeFrom = departureTimeFrom;
		this.departureTimeTo = departureTimeTo;
		this.airLine = airLine;
		this.customerName = customerName;
	}
}
