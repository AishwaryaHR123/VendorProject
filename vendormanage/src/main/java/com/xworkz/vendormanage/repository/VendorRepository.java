package com.xworkz.vendormanage.repository;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.xworkz.vendormanage.dto.VendorDTO;

@Repository
public interface VendorRepository {
	boolean validateAndSave(VendorDTO dto);
	
	VendorDTO isExistByGstOrMailOrWebSiteOrNumber(String gst,Long number,String email, String website);

	List<VendorDTO> findAll();
		
	

}
