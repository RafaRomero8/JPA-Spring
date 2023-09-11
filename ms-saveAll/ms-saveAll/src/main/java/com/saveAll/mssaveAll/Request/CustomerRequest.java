package com.saveAll.mssaveAll.Request;

import java.util.List;
import com.saveAll.mssaveAll.Entity.CustomerEntity;

public class CustomerRequest {

	private List<CustomerEntity> listCustomer;

	public List<CustomerEntity> getListCustomer() {
		return listCustomer;
	}

	public void setListCustomer(List<CustomerEntity> listCustomer) {
		this.listCustomer = listCustomer;
	}
	
	
}
