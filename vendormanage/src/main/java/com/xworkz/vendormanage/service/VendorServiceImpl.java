package com.xworkz.vendormanage.service;

import java.time.LocalDate;
import java.util.Properties;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.vendormanage.dto.VendorDTO;
import com.xworkz.vendormanage.repository.VendorRepository;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class VendorServiceImpl implements VendorService{
	@Autowired
	private VendorRepository repo;
	public VendorServiceImpl() {
		System.out.println("Created VendorServiceImpl....");
	}

	@Override
	public VendorDTO save(VendorDTO dto) {
		dto.setCreatedBy(dto.getOwnerName());
		dto.setCreatedDate(LocalDate.now());
		this.repo.validateAndSave(dto);
		return dto;
	}

	@Override
	public String isExistByGstOrMailOrSiteOrNo(String gst,Long contactNo,String email, String website) {
		VendorDTO dto = repo.isExistByGstOrMailOrWebSiteOrNumber(gst, contactNo,email, website);
		if (dto != null) {
			if (dto.getGstNo().equals(gst)) {
				return "gstNo already exist.";
			} 
			 else if (dto.getContactNo().equals(contactNo)) {
					return "contactNo already exist";
				}
			else if (dto.getEmail().equals(email)) {
				return "Email already exist";
			}
			else if (dto.getWebsite().equals(website)) {
				return "Website already exist";
			}
		}

		return null;
	}

	@Override
	public boolean sendEmail(String email) {
		String portNumber="587";
		String hostName="smtp.office365.com";
		String fromEmail="aishu3630@outlook.com";
		String password="Aishu@3630";
		String to =email;
		Properties prop=System.getProperties();
		prop.put("mail.smtp.host", hostName);
		prop.put("mail.smtp.port", portNumber);
		prop.put("mail.smtp.starttls.enable", true);
		prop.put("mail.debug", true);
		prop.put("mail.smtp.auth", true);
		prop.put("mail.transport.protocol", "smtp");
		Session session=Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication(fromEmail, password);
			}
		});
		MimeMessage message=new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(fromEmail));
			message.setSubject("verification is successfull");
			message.setText("your registration is submitted");
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			Transport.send(message);
			return true;
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
		return false;
	}

	
}
	

