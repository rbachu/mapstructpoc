package com.practise.mapstruct.hexagonalbank.entities.domain;

public enum EnglishSalutationEnum {

	MISTER("Mr"),MISS("Miss"),DOCTOR("Dr"),PROFESSOR("Prof"),ADMIRAL("Admiral");

	private final String salutation;
	
	private EnglishSalutationEnum(String salutation){
		this.salutation = salutation;
	}
}
