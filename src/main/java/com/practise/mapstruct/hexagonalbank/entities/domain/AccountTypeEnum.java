package com.practise.mapstruct.hexagonalbank.entities.domain;


public enum AccountTypeEnum {

	SAVINGS(1), CURRENT(2), DEMAT(3);
	
	private final int code;
	
	private AccountTypeEnum(int code){
		this.code = code;
	}
	
	public int getCode(){
		return code;
	}
	
	public static AccountTypeEnum getEnumByCode(int code){
		switch(code){
		case 1 : return SAVINGS;
		case 2 : return CURRENT;
		case 3: return DEMAT;
		default: return null;
		}
	}
}
