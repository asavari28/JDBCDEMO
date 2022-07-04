package com.jdbcdemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jdbcdemo.entity.Sp_Address;


@Repository
public class Sp_AddressRepositoryImpl  {

	private static final String INSERT_Sp_Address_QUERY = "INSERT INTO Sp_Address(sp_addr_id,sp_id,addr_name,addr_1,addr_2,state,pincode,country,status,lat,lon) values(?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE_Sp_Address_BY_SP_ID_QUERY =  "UPDATE Sp_Address SET sp_addr_id=?,addr_name=?,addr_1=?,addr_2=?,state=?,pincode=?,country=?,status=?,lat=?,lon=? WHERE SP_ID=?";	
    private static final String GET_Sp_Address_BY_SP_ID_QUERY ="SELECT *FROM Sp_Address WHERE SP_ID=?";
    private static final String DELETE_Sp_Address_BY_SP_ID = "DELETE FROM Sp_Address WHERE SP_ID=?";
    private static final String GET_Sp_Addresses_QUERY = "SELECT * FROM Sp_Address";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public Sp_Address saveSp_Address(Sp_Address sp_address) {
		jdbcTemplate.update(INSERT_Sp_Address_QUERY,sp_address.getSp_addr_id(), sp_address.getSp_id(), sp_address.getAddr_name(),sp_address.getAddr_1(),sp_address.getAddr_2(),sp_address.getState(),sp_address.getPincode(),sp_address.getCountry(),sp_address.getStatus(),sp_address.getLat(),sp_address.getLon());
		return sp_address;
	}

	
	public Sp_Address updateSp_Address(Sp_Address sp_address) {
		jdbcTemplate.update(UPDATE_Sp_Address_BY_SP_ID_QUERY,sp_address.getSp_addr_id(), sp_address.getAddr_name(),sp_address.getAddr_1(),sp_address.getAddr_2(),sp_address.getState(),sp_address.getPincode(),sp_address.getCountry(),sp_address.getStatus(),sp_address.getLat(),sp_address.getLon(), sp_address.getSp_id());
        return sp_address;
	}

	
	public Sp_Address getBySp_id(int sp_id) {
		return jdbcTemplate.queryForObject(GET_Sp_Address_BY_SP_ID_QUERY, (rs, rowNum) -> {
          
		 return new Sp_Address(rs.getInt("sp_addr_id"),rs.getInt("sp_id"),rs.getString("addr_name"),rs.getString("addr_1"),rs.getString("addr_2"),rs.getString("state"),rs.getInt("pincode"),rs.getString("country"),rs.getInt("status"),rs.getInt("lat"),rs.getInt("lon"));
        },sp_id);
	}

	
	public String deleteBySp_id(int sp_id) {
		jdbcTemplate.update(DELETE_Sp_Address_BY_SP_ID, sp_id);
        return "Sp_Address got deleted with id " + sp_id;
	}

	
	public List<Sp_Address> allSp_Addresses() {
		return jdbcTemplate.query(GET_Sp_Addresses_QUERY, (rs, rowNum) -> {
			 return new Sp_Address(rs.getInt("sp_addr_id"),rs.getInt("sp_id"),rs.getString("addr_name"),rs.getString("addr_1"),rs.getString("addr_2"),rs.getString("state"),rs.getInt("pincode"),rs.getString("country"),rs.getInt("status"), rs.getInt("lat"),rs.getInt("lon"));
        });
	}

}