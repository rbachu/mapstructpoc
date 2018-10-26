package com.practise.mapstruct.hexagonalbank.entities.dto;

import java.util.List;

public class CustomerDto {
	private Long id;
	private String customerName;
	private String nationality;
	private List<AccountDto> customerAccounts;
	private FrenchSalutationEnum salutation;
	private String panCard;
	private String aadharCard;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public List<AccountDto> getCustomerAccounts() {
		return customerAccounts;
	}
	public void setCustomerAccounts(List<AccountDto> customerAccounts) {
		this.customerAccounts = customerAccounts;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public FrenchSalutationEnum getSalutation() {
		return salutation;
	}
	public void setSalutation(FrenchSalutationEnum salutation) {
		this.salutation = salutation;
	}
	public String getPanCard() {
		return panCard;
	}
	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}
	public String getAadharCard() {
		return aadharCard;
	}
	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}
	

}
