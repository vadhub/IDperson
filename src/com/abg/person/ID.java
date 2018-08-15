package com.abg.person;

public class ID {
	private int id;
	
	public int idPerson() {		
		return setId((int) (Math.random()*100000));		
	}

	public int getId() {
		return id;
	}

	public int setId(int id) {
		this.id = id;
		return id;
	}
}
