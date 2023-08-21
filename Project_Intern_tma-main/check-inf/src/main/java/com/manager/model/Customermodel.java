package com.manager.model;

public class Customermodel {

	private int id_customer;
	private String name_customer;
	private String phone_number;
	private String add_customer;
	private String id_card;
	private int id_room;

	public int getId_customer() {
		return id_customer;
	}

	public void setId_customer(int id_customer) {
		this.id_customer = id_customer;
	}

	public String getName_customer() {
		return name_customer;
	}

	public void setName_customer(String name_customer) {
		this.name_customer = name_customer;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getAdd_customer() {
		return add_customer;
	}

	public void setAdd_customer(String add_customer) {
		this.add_customer = add_customer;
	}

	public String getId_card() {
		return id_card;
	}

	public void setId_card(String id_card) {
		this.id_card = id_card;
	}
	
	public int getId_room() {
		return id_room;
	}

	public void setId_room(int id_room) {
		this.id_room = id_room;
	}

	@Override
	public String toString() {
		return "customerModel [id_customer=" + id_customer + ", name_customer=" + name_customer + ", phone_number="
				+ phone_number + ", add_customer=" + add_customer  + ", id_card=" + id_card + ", id_room=" + id_room
				+ "]";
	}


}
