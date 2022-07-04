package com.jdbcdemo.dao;

import java.util.List;

import com.jdbcdemo.entity.Sp_Address;


public interface Sp_AddressRepository {
	Sp_Address savesp_address(Sp_Address sp_address);

	Sp_Address updateSp_address(Sp_Address sp_address);

	Sp_Address getBySp_id(int sp_id);

    String deleteBySp_id(int sp_id);

    List<Sp_Address> allSp_Addresses();

}