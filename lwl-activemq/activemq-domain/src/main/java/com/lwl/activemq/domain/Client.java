package com.lwl.activemq.domain;

import java.io.Serializable;
/**
 * 客户实体类
 *
 */
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;
	
	private String name;
	
	private String address;
	
	private String mobile;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", address=" + address
				+ ", mobile=" + mobile + "]";
	}
	
}
