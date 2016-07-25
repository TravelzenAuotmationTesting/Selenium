package com.data.generation;

import com.selemium.utility.Utility;

public class IssueTicketData {
	
	public String ticketID;
	
	public String ticketType;

	/**
	 * @param ticketID
	 * @param ticketType
	 */
	public IssueTicketData(String ticketID, String ticketType) {
		super();
		this.ticketID = ticketID;
		this.ticketType = ticketType;
	}
	
	
	public IssueTicketData()
	{
		switch ((int)(Math.random()*3)) {
		case 0:
			this.ticketType="BSP";
			break;
		case 1:
			this.ticketType="B2B";
			break;
		case 2:
			this.ticketType="CRS";
			break;
		};
		this.ticketID= Utility.generateRandomString(13, 2);
	}

}
