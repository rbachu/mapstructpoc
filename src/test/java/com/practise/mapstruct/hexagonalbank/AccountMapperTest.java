package com.practise.mapstruct.hexagonalbank;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

import com.practise.mapstruct.hexagonalbank.entities.domain.Account;
import com.practise.mapstruct.hexagonalbank.entities.domain.AccountTypeEnum;
import com.practise.mapstruct.hexagonalbank.entities.dto.AccountDto;
import com.practise.mapstruct.hexagonalbank.mapper.AccountMapper;
import static org.assertj.core.api.Assertions.assertThat;

public class AccountMapperTest {

	private static final int ACCOUNT_ID = 1234;
	private static final double ACCOUNT_BALANCE = 123.565686d;

	


	
	@Test
	public void toDomain() {
		AccountDto accountDto  = new AccountDto();
		accountDto.setId(String.valueOf(ACCOUNT_ID));
		accountDto.setBalance(ACCOUNT_BALANCE);
		accountDto.setAccountType(AccountTypeEnum.CURRENT.getCode());
		
		Account account = AccountMapper.MAPPER.toDomain(accountDto);
		assertThat(account.getAccountId()).isEqualTo(ACCOUNT_ID);
		assertThat(account.getBalance()).isEqualTo(new BigDecimal(ACCOUNT_BALANCE).setScale(3,RoundingMode.DOWN));
		assertThat(account.getAccountType()).isEqualTo(AccountTypeEnum.CURRENT);
		
	}
	
	
	@Test
	public void toDto() {
		Account account = new Account();
		
		account.setAccountId(ACCOUNT_ID);
		account.setBalance(new BigDecimal(ACCOUNT_BALANCE));
		account.setAccountType(AccountTypeEnum.SAVINGS);
		
		
		AccountDto accountDto = AccountMapper.MAPPER.toDto(account);
		assertThat(accountDto.getId()).isEqualTo(String.valueOf(ACCOUNT_ID));
		assertThat(accountDto.getBalance()).isEqualTo(123.56d);
		assertThat(accountDto.getAccountType()).isEqualTo(AccountTypeEnum.SAVINGS.getCode());
		
	
	}
}
