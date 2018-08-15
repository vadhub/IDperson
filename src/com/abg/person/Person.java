package com.abg.person;

public class Person {
	private String name;
	private int pass;
	private int id;
	
	public Person(String name, int pass, int id) {
		this.setName(name);
		this.setPass(pass);
		this.setId(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPass() {
		return pass;
	}

	public void setPass(int pass) {
		this.pass = pass;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
