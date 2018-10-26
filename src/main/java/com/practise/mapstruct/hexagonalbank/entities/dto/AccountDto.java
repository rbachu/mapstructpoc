package com.practise.mapstruct.hexagonalbank.entities.dto;

import lombok.Data;

@Data
public class AccountDto {
	private String id;
	private double balance;
	private int accountType;
}
