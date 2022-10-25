package com.spring.entity;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.spring.DoctorDao.DoctorDao;

public class Main {
	private final static Logger log = Logger.getLogger("Main");
	
	public static void main(String[] args) {
		log.setLevel(Level.ALL);
		while (true) {
			Scanner sc = new Scanner(System.in);
			log.info("Enter the type ");
			int type = sc.nextInt();
			DoctorDao dao = new DoctorDao();
			if (type == 1) {
				dao.list();
			} 
			else if (type == 2) {
				dao.insert();
			} 
			else if (type == 3) {
				dao.getDocById();
			} 
			else if (type == 4) {
				dao.deleteById();
			} 
			else if (type == 5) {
				dao.update();
			} 
			else {
				log.warning("not a defined type for a operation closing the entity");
				dao.closeEntity();
				break;
			}
			sc.close();
		}
	}
}
