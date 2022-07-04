package com.jdbcdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sp_Address {
	private int sp_addr_id;
	private int sp_id;
	private String addr_name;
	private String addr_1;
	private String addr_2;
	private String state;
    private int pincode;
    private String country;
    private int status;
	private  int lat  ;
	private  int lon;
}
