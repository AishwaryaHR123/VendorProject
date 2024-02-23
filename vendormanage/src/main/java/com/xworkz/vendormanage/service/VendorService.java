package com.xworkz.vendormanage.service;

import org.springframework.stereotype.Service;

import com.xworkz.vendormanage.dto.VendorDTO;

@Service
public interface VendorService {
	VendorDTO save(VendorDTO dto);

	String isExistByGstOrMailOrSiteOrNo(String gst, Long contactNo,String email, String website);

	boolean sendEmail(String email);

}
