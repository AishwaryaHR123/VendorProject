package com.xworkz.vendormanage.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.vendormanage.dto.VendorDTO;

@Repository
public class VendorRepositoryImpl implements VendorRepository{
	
	@Autowired
	private EntityManagerFactory emf;

	public VendorRepositoryImpl() {
		System.out.println("created VendorRepositoryImpl....");
	}
	@Override
	public boolean validateAndSave(VendorDTO dto) {
		System.out.println("Running in validateAndSave in VendorRepositoryImpl");
		EntityManager em=emf.createEntityManager();
		System.out.println("Created EntityManager:"+em);
		EntityTransaction et=em.getTransaction();
		System.out.println("EntityTransaction Created:"+et);
		try {
			et.begin();
			em.persist(dto);
			System.out.println("persisted...");
			et.commit();
		}
		catch (PersistenceException e) {
			System.err.println("Persistence Exception:"+e.getMessage());
			et.rollback();
		}
		finally {
			em.close();
			System.out.println("EntityManager Closed...");
		}
		return true;
	}

	@Override
	public VendorDTO isExistByGstOrMailOrWebSiteOrNumber(String gst,Long number,String email, String website) {
		EntityManager entityManager = emf.createEntityManager();
		System.out.println("EM created.");
		VendorDTO dto=null;

		try {
			Query query = entityManager.createNamedQuery("isExist");
			query.setParameter("gstNo", gst);
			query.setParameter("cNumber", number);
			query.setParameter("vMail", email);
			query.setParameter("vWebsite", website);
			dto=(VendorDTO)query.getSingleResult();
     
		} catch (PersistenceException e) {
			System.err.println("PersistenceException: "+e.getMessage());
		}
		finally {
			entityManager.close();
			System.out.println("EM closed.");
		}
		
		return dto ;		
	}
	@Override
	public List<VendorDTO> findAll() {
		System.out.println("saved List");
		EntityManager manager=emf.createEntityManager();
		System.out.println("Created EntityManager....");
		List<VendorDTO> list=new ArrayList<VendorDTO>();
		
		
		try {
			Query query = manager.createNamedQuery("findAll");
			list=query.getResultList();
			System.out.println("List Saved SuccessFully");
		} catch (PersistenceException e) {
			System.out.println("Persistence Exception "+e.getMessage());
			
		}
		finally {
			System.out.println("Closing the resources...");
			manager.close();
		}
		return list;
		
	}
	}




