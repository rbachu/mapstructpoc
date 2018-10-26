package com.practise.mapstruct.hexagonalbank.entities.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KYCDocument {

	private String id;
	private KYCDocumentTypeEnum type;
	private String comments;
	
}
