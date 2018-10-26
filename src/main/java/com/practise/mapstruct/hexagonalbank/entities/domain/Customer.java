package com.practise.mapstruct.hexagonalbank.entities.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Customer extends Person {

	private Long id;
	private String name;	
	private List<Account> accounts;
	private Map<String, KYCDocument > documents;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	public Map<String, KYCDocument> getDocuments() {
		return Collections.unmodifiableMap(documents);
	}
	public void setDocuments(Map<String, KYCDocument> documents) {
		this.documents = documents;
	}
	
	
}
