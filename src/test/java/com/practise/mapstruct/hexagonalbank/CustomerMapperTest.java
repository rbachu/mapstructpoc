package com.practise.mapstruct.hexagonalbank;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.practise.mapstruct.hexagonalbank.entities.domain.Account;
import com.practise.mapstruct.hexagonalbank.entities.domain.Customer;
import com.practise.mapstruct.hexagonalbank.entities.domain.EnglishSalutationEnum;
import com.practise.mapstruct.hexagonalbank.entities.domain.KYCDocument;
import com.practise.mapstruct.hexagonalbank.entities.domain.KYCDocumentTypeEnum;
import com.practise.mapstruct.hexagonalbank.entities.dto.AccountDto;
import com.practise.mapstruct.hexagonalbank.entities.dto.CustomerDto;
import com.practise.mapstruct.hexagonalbank.entities.dto.FrenchSalutationEnum;
import com.practise.mapstruct.hexagonalbank.mapper.CustomerMapper;

public class CustomerMapperTest {

	private static final Long ID = 20L;
	private static final String NAME = "ABC";
	private static final String NATIONALITY ="Indian";
	
	
	
	@Test
	public void toDto() {
		Customer customer = new Customer();
		customer.setId(ID);
		customer.setName(NAME);
		customer.setNationality(NATIONALITY);
		customer.setSalutation(EnglishSalutationEnum.MISTER);
		Map<String,KYCDocument> documents = new HashMap<String,KYCDocument>();
		documents.put(KYCDocumentTypeEnum.PANCARD.name(), new KYCDocument("ABCD12345J",KYCDocumentTypeEnum.PANCARD, "pan card"));
		documents.put(KYCDocumentTypeEnum.AADHARCARD.name(), new KYCDocument("1733 9999 2345 9876",KYCDocumentTypeEnum.AADHARCARD, "aadhar card"));
		customer.setDocuments(documents);
		
	    Account account1 = new Account();
		account1.setAccountId(1234);
		account1.setBalance(new BigDecimal(100.50));

	    Account account2 = new Account();
		account2.setAccountId(5678);
		account2.setBalance(new BigDecimal(200.30));
        
        customer.setAccounts(Arrays.asList(account1,account2));

		
		CustomerDto customerDto = CustomerMapper.MAPPER.toDto(customer);
		
		assertThat(customerDto.getId()).isEqualTo(ID);
		assertThat(customerDto.getCustomerName()).isEqualTo(NAME);
		assertThat(customerDto.getNationality()).isEqualTo(NATIONALITY);
		assertThat(customerDto.getSalutation()).isEqualTo(FrenchSalutationEnum.MONSIEUR);
		assertThat(customerDto.getPanCard()).isEqualTo("ABCD12345J");
		assertThat(customerDto.getAadharCard()).isEqualTo("1733 9999 2345 9876");
		assertThat(customerDto.getCustomerAccounts()).isNotEmpty();
		assertThat(customerDto.getCustomerAccounts().size()).isEqualTo(2);
		assertThat(customerDto.getCustomerAccounts().get(0).getBalance()).isEqualTo(100.50d);
		
	}

	
	@Test
	public void toDomain() {
		CustomerDto customerDto = new CustomerDto();
		customerDto.setId(ID);
		customerDto.setCustomerName(NAME);
		customerDto.setSalutation(FrenchSalutationEnum.MADAME);
		customerDto.setNationality(NATIONALITY);
		
		AccountDto accountDto = new AccountDto();
		accountDto.setId("1234");
		accountDto.setBalance(200.589);
		customerDto.setCustomerAccounts(Arrays.asList(accountDto));
		
		Customer customer = CustomerMapper.MAPPER.toDomain(customerDto);
		
		assertThat(customer.getId()).isEqualTo(ID);
		assertThat(customer.getName()).isEqualTo(NAME);
		assertThat(customer.getSalutation()).isEqualTo(EnglishSalutationEnum.MISS);
		assertThat(customer.getNationality()).isEqualTo(NATIONALITY);
		assertThat(customer.getAccounts()).isNotEmpty();
		assertThat(customer.getAccounts().get(0).getAccountId()).isEqualTo(1234);
	}
}
