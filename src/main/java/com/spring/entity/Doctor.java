package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {

	@Id
	private int doc_id;
	@Column(name = "doc_name")
	private String docName;
	@Column(name = "experience")
	private int experience;
	@Column(name = "place")
	private String place;

	public Doctor() {
	}

	public Doctor(int doc_id, String docName, int experience, String place) {
		super();
		this.doc_id = doc_id;
		this.docName = docName;
		this.experience = experience;
		this.place = place;
	}

	public int getDocId() {
		return doc_id;
	}

	public void setDocId(int doc_id) {
		this.doc_id = doc_id;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Override
	public String toString() {
		return "Doctor doc_id= " + doc_id + ", docName=" + docName + ", experience=" + experience + ", place=" + place
				;
	}

}
