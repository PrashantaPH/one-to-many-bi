package com.ty.mobileandsim.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.mobileandsim.Mobile;
import com.ty.mobileandsim.Sim;

public class TestSaveMobileSim {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prashant");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Mobile mobile = new Mobile();
		mobile.setName("Vivo");
		mobile.setCost(24000);

		Sim sim = new Sim();
		sim.setProvider("TataDecomo");
		sim.setType("3g");
		sim.setImei("777ee");

		Sim sim1 = new Sim();
		sim1.setProvider("Idea");
		sim1.setType("5g");
		sim1.setImei("0988JHG");
		List<Sim> sims = new ArrayList();
		sims.add(sim);
		sims.add(sim1);

		mobile.setSim(sims);

		sim.setMobile(mobile);
		sim1.setMobile(mobile);

		entityTransaction.begin();
		entityManager.persist(mobile);
		entityManager.persist(sim);
		entityManager.persist(sim1);
		entityTransaction.commit();

	}

}
