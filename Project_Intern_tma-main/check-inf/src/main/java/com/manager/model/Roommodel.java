package com.manager.model;

public class Roommodel {
	private int id_room;
	private String name_apartment;
	private int id_customer;

	
	public int getId_room() {
		return id_room;
	}
	public void setId_room(int id_room) {
		this.id_room = id_room;
	}
	public String getName_apartment() {
		return name_apartment;
	}

	public void setName_apartment(String name_apartment) {
		this.name_apartment = name_apartment;
	}
	public int getId_customer() {
		return id_customer;
	}

	public void setId_customer(int id_customer) {
		this.id_customer = id_customer;
	}
	@Override
	public String toString() {
		return "Roommodel [id_room=" + id_room + ", name_apartment=" + name_apartment + ", id_customer=" + id_customer
				+ "]";
	}

}
