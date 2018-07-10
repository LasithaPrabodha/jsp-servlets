package com.auction.web.jdbc;

import java.util.Date;

public class Item {

	private int id;
	private String name;
	private String category;
	private Double minBid;
	private Date dateAdded;


	public Item(String name, String category, Double minBid, Date dateAdded) {
		this.name = name;
		this.category = category;
		this.minBid = minBid;
		this.dateAdded = dateAdded;
	}
	
	public Item(int id, String name, String category, Double minBid, Date dateAdded) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.minBid = minBid;
		this.dateAdded = dateAdded;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getMinBid() {
		return minBid;
	}

	public void setMinBid(Double minBid) {
		this.minBid = minBid;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", category=" + category + ", minBid=" + minBid + ", dateAdded="
				+ dateAdded + "]";
	}

	
}
