package com.regnant.dto;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Client")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "gst")
	private String gst;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CreatedDate")
	private Date date;
	
	@Embedded
	@Column(name = "Client_Address")
	private Address address;

	public Client() {
		super();
	}

	public Client(int id, String name, String gst, Date date, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.gst = gst;
		this.date = date;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGst() {
		return gst;
	}

	public void setGst(String gst) {
		this.gst = gst;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", gst=" + gst + ", date=" + date + ", address=" + address + "]";
	}

	


}
