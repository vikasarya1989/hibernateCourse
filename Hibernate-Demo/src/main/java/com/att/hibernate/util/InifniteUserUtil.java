package com.att.hibernate.util;
import java.util.Date;

import com.att.main.pojos.User;

public class InifniteUserUtil {

	private static User user = buildUserObj();
	
	private static User buildUserObj() {
		java.sql.Date date = (java.sql.Date) new Date();
		user.setuserId(1L);
		user.setFirstName("vamsi");
		user.setLastName("Guttikonda");
		user.setBirthDate(date);
		user.setEmailId("vamsi.gpv@gmail.com");
		user.setLastUpdatedBy("vamsi");
		user.setLastUpdated(date);
		user.setUserAddressLineOne("585 S lincoln ave");
		user.setUserAddressLineTwo("Apartment 2");
		user.setCity("Woodbridge");
		user.setState("NY");
		user.setZipcode("13210");
		return user;
	}
	
	public static User getUserObjj() {
		return buildUserObj();
	}
}
