package com.practise.mapstruct.hexagonalbank.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ValueMapping;
import org.mapstruct.ValueMappings;
import org.mapstruct.factory.Mappers;

import com.practise.mapstruct.hexagonalbank.entities.domain.EnglishSalutationEnum;
import com.practise.mapstruct.hexagonalbank.entities.dto.FrenchSalutationEnum;



@Mapper
public interface SalutationMapper {

	public static final SalutationMapper MAPPER = Mappers.getMapper(SalutationMapper.class);
	 @ValueMappings({
		    @ValueMapping( source = "MISTER", target = "MONSIEUR" ),
	        @ValueMapping( source = "MISS", target = "MADAME" ),
	        @ValueMapping( source = "DOCTOR", target = "DOCTEUR" ),
	        @ValueMapping( source = "ADMIRAL", target = MappingConstants.NULL ),
	        @ValueMapping( source = "PROFESSOR", target = "MONSIEUR" ),
	        @ValueMapping( source = MappingConstants.NULL, target = "INCONNU" ),
	        @ValueMapping( source = MappingConstants.ANY_REMAINING, target = "INCONNU")
	    })
	 public FrenchSalutationEnum toFrench(EnglishSalutationEnum englishSalutation);
	 
	 
	@InheritInverseConfiguration
	 public EnglishSalutationEnum toEnglish(FrenchSalutationEnum frenchSalutation);
}
