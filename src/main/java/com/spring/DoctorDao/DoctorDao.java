package com.spring.DoctorDao;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.spring.entity.Doctor;

public class DoctorDao {
	private final static Logger logr = Logger.getLogger("DoctorDao");
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
	static EntityManager entityManager = entityManagerFactory.createEntityManager();
	Scanner sc = new Scanner(System.in);
	int id;
	String name;
	int experience;
	String place;
	Doctor doc;

	public void insert() {
		System.out.println("Starting Transaction");
		entityManager.getTransaction().begin();
		logr.info("Adding into Database");
		logr.info("Enter id,name,experience,place");
		id = sc.nextInt();
		name = sc.next();
		experience = sc.nextInt();
		place = sc.next();
		doc = new Doctor(id, name, experience, place);
		logr.info("Saving Doctor to Database");
		entityManager.persist(doc);
		entityManager.getTransaction().commit();
	}

	public void getDocById() {
		logr.info("Enter the ID to find the detalis of doctor");
		id = sc.nextInt();
		Doctor doctor = entityManager.find(Doctor.class, id);
		if (doctor != null) {
			logr.config("got Doctor by ID \n" + doctor.getDocName() + "\n" + doctor.getDocId() + "\n"
					+ doctor.getExperience() + "\n" + doctor.getPlace());
		} else {
			logr.warning("No details based on id");
			entityManager.getTransaction().rollback();
		}
	}

	public void list() {
		@SuppressWarnings("unchecked")
		List<Doctor> list = entityManager.createQuery("SELECT d FROM Doctor d").getResultList();

		if (list == null) {
			logr.warning("No doctor found . ");
			entityManager.getTransaction().rollback();
		} else {
			for (Doctor doc1 : list) {
				System.out.println("doctor name= " + doc1.getDocName() + ", doctor id=" + doc1.getDocId()
						+ ", doctor Experience=" + doc1.getExperience() + ", doctor place=" + doc1.getPlace());
			}
		}
	}

	public void deleteById() {
		System.out.println("Enter ID to delete the list");
		id = sc.nextInt();
		Doctor d = entityManager.find(Doctor.class, id);
		if (d != null) {
			entityManager.getTransaction().begin();
			logr.info("Deleting doctor with ID = " + id);
			entityManager.remove(d);
			entityManager.getTransaction().commit();
		} else {
			logr.warning("No doctor with ID " + id);
			entityManager.getTransaction().rollback();
		}

	}

	public void update() {
		logr.info("Enter ID to update the experience ");
		id = sc.nextInt();
		Doctor d = entityManager.find(Doctor.class, id);
		if (d != null) {
			logr.warning("No details based on Id found");
			entityManager.getTransaction().rollback();
		} else {
			entityManager.getTransaction().begin();
			logr.info("Enter experience to update");
			experience = sc.nextInt();
			d.setExperience(experience);
			entityManager.merge(d);
			entityManager.getTransaction().commit();
		}

	}

	public void closeEntity() {
		entityManager.close();
		entityManagerFactory.close();

	}
}
