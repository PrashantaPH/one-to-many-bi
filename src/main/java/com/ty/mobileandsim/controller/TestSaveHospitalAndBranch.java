package com.ty.mobileandsim.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.mobileandsim.Branch;
import com.ty.mobileandsim.Hospital;

public class TestSaveHospitalAndBranch {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("prashant");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Hospital hospital=new Hospital();
		hospital.setName("apolo");
		hospital.setGstNo("PPAA123");
		hospital.setWebsite("WWW.apolo");
		
		Branch branch1=new Branch();
		branch1.setName("apolo");
		branch1.setAddress("raj nagar");
		branch1.setPhone(554422772l);

		Branch branch2=new Branch();
		branch2.setName("multi special");
		branch2.setAddress("jp nagar");
		branch2.setPhone(554488872l);

		branch1.setHospital(hospital);
		branch2.setHospital(hospital);
		
		entityTransaction.begin();
		entityManager.persist(hospital);
		entityManager.persist(branch1);
		entityManager.persist(branch2);
		entityTransaction.commit();
		
		
		
	}
}
