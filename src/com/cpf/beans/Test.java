package com.cpf.beans;

import java.io.Serializable;

public class Test implements Serializable{
	private String id;
	private String name ;
	private String pvalue;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPvalue() {
		return pvalue;
	}
	public void setPvalue(String pvalue) {
		this.pvalue = pvalue;
	}

	
}
