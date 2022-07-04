package com.jdbcdemo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jdbcdemo.dao.Sp_AddressRepositoryImpl;
import com.jdbcdemo.entity.Sp_Address;


@RestController
public class Sp_AddressController {

	 @Autowired
	 Sp_AddressRepositoryImpl sp_addressRepository;
	 
	    @PostMapping("/service_provider/add_address")
	    public Sp_Address addSp_Address(@RequestBody Sp_Address sp_address) {

	        return sp_addressRepository.saveSp_Address(sp_address);
	    }
        
	    @PutMapping("/service_provider/update_address")// /{sp_id"}
	    public Sp_Address updateSp_Address(@RequestBody Sp_Address sp_address) { //,@PathVariable("sp_id") int sp_id) {
            //sp_address.setSp_id(sp_id);
	        return sp_addressRepository.updateSp_Address(sp_address);
	    }

	    @GetMapping("/service_provider/get_address_by_service_provider/{sp_id}")
	    public Sp_Address getSp_Address(@PathVariable("sp_id") int sp_id) {
	        return sp_addressRepository.getBySp_id(sp_id);
	    }

	    @GetMapping("/service_provider/get_address_by_service_provider")
	    public List<Sp_Address> getSp_Addresses() {
	        return sp_addressRepository.allSp_Addresses();
	    }

	    @DeleteMapping("/service_provider/delete_address/{sp_id}")
	    public String deleteSp_Address(@PathVariable("sp_id") int sp_id){
	        return sp_addressRepository.deleteBySp_id(sp_id);
	    }

}