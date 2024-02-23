package com.xworkz.vendormanage.service;

import org.springframework.stereotype.Service;

@Service
public interface VendorAjaxService {

	String isExistByGstNo(String gstNo);

	String isExistByContactNo(Long number);

	String isExistByEmail(String email);

	String isExistByWebsite(String website);

}
