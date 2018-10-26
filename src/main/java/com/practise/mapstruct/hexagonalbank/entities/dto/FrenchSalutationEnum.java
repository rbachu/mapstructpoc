package com.practise.mapstruct.hexagonalbank.entities.dto;

public enum FrenchSalutationEnum {
	MONSIEUR("Monsieur"),MADAME("Madame"),DOCTEUR("Docteur"),INCONNU("Inconnu");
	
	private final String salutation;
	
	private FrenchSalutationEnum(String salutation){
		this.salutation = salutation;
	}
}
