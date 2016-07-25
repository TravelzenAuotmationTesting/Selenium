package com.data.generation;

import com.selemium.utility.IdCardGenerator;
import com.selemium.utility.Utility;

public class WhitePassenagerData {



	public String fullname;

	public String gender;

	public String IDType;

	public String documentID;

	public String PType;

	public String brithday;

	public String ContactPhone;


	public WhitePassenagerData(String fullname, String gender, String iDType, String documentID, String pType,
			String brithday, String contactPhone) {
		super();
		this.fullname = fullname;
		this.gender = gender;
		IDType = iDType;
		this.documentID = documentID;
		PType = pType;
		this.brithday = brithday;
		this.ContactPhone = contactPhone;
	}
	
	public WhitePassenagerData() {
		
		this.fullname= Utility.generateRandomString(3, 1)+'/'+Utility.generateRandomString(6, 1);
		this.gender=Math.random() > 0.5 ? "ÄÐ" : "Å®";
		this.brithday= (new IdCardGenerator()).randomBirthday(1);
		this.documentID=(new IdCardGenerator()).generate();
		this.ContactPhone=Utility.generateRandomString(11,2);

	}

}
