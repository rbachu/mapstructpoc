package com.practise.mapstruct.hexagonalbank.entities.domain;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Account {
	private int accountId;
	private BigDecimal balance;
	private AccountTypeEnum accountType;
}
