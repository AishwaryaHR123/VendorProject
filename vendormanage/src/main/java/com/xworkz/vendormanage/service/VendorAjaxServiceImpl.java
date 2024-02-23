package com.xworkz.vendormanage.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xworkz.vendormanage.dto.VendorDTO;
import com.xworkz.vendormanage.repository.VendorRepository;

@Service
public class VendorAjaxServiceImpl implements VendorAjaxService {
	@Autowired
	private VendorRepository vrepo;

	public VendorAjaxServiceImpl() {
		System.out.println("Created VendorAjaxServiceImpl...");
	}

	@Override
	public String isExistByGstNo(String gstNo) {
		List<VendorDTO> list = this.vrepo.findAll();
		for (VendorDTO vendorDTO : list) {
			if (vendorDTO.getGstNo().equals(gstNo)) {
				return "GstNo already exist...";

			} else {
				System.out.println("Gst not Exist..");
			}

		}
		return null;
	}

	@Override
	public String isExistByContactNo(Long number) {
		List<VendorDTO> list = this.vrepo.findAll();
		for (VendorDTO vendorDTO : list) {
			if (vendorDTO.getContactNo().equals(number)) {
				return "ContactNo Already Exist...";
			} else {
				System.out.println("contactNo not Exist");
			}

		}
		return null;
	}

	@Override
	public String isExistByEmail(String email) {
		List<VendorDTO> list = this.vrepo.findAll();
		for (VendorDTO vendorDTO : list) {
			if (vendorDTO.getEmail().equals(email)) {
				return "Email Already Exist";
			} else {
				System.out.println("Email not Exist");
			}
		}
		return null;
	}

	@Override
	public String isExistByWebsite(String website) {
		List<VendorDTO> list = this.vrepo.findAll();
		for (VendorDTO vendorDTO : list) {
			if (vendorDTO.getWebsite().equals(website)) {
				return "Website Already Exist";
			} else {
				System.out.println("Website not Exist");
			}

		}
		return null;
	}

}
