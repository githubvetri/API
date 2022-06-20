package com.payloads;

import com.base.BaseClass;
import com.pojo.AddAddress_Input_pojo;
import com.pojo.DeleteAddress_Input_Pojo;
import com.pojo.UpdateAddress_Input_Pojo;

public class Payload extends BaseClass {
	

	public AddAddress_Input_pojo createAddress(String first_name, String last_name, String mobile, String apartment,
			String state, String city, String country, String zipcode, String address, String address_type) {

		AddAddress_Input_pojo addAddress_Input_pojo = new AddAddress_Input_pojo(first_name, last_name, mobile,
				apartment, Integer.parseInt(state), Integer.parseInt(city), Integer.parseInt(country), zipcode, address,
				address_type);
		return addAddress_Input_pojo;

	}

	public static UpdateAddress_Input_Pojo updateAddress(String address_id,String first_name, String last_name, String mobile, String apartment,
			String state, String city, String country, String zipcode, String address, String address_type) {

		UpdateAddress_Input_Pojo updateAddress_Input_Pojo = new UpdateAddress_Input_Pojo(String.valueOf(address_id),
				first_name, last_name, mobile, apartment, Integer.parseInt(state), Integer.parseInt(city),
				Integer.parseInt(country), zipcode, address, address_type);
		return updateAddress_Input_Pojo;

	}

	public static DeleteAddress_Input_Pojo deleteAddress(String address_id) {

		DeleteAddress_Input_Pojo deleteAddress_Input_Pojo = new DeleteAddress_Input_Pojo(String.valueOf(address_id));
		return deleteAddress_Input_Pojo;

	}

}