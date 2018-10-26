package com.practise.mapstruct.hexagonalbank;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.practise.mapstruct.hexagonalbank.entities.domain.EnglishSalutationEnum;
import com.practise.mapstruct.hexagonalbank.entities.dto.FrenchSalutationEnum;
import com.practise.mapstruct.hexagonalbank.mapper.SalutationMapper;

public class SalutationMapperTest {



	
	@Test
	public void toFrench() {

		FrenchSalutationEnum frenchEnum = SalutationMapper.MAPPER.toFrench(EnglishSalutationEnum.MISTER);	
		assertThat(frenchEnum).isEqualTo(FrenchSalutationEnum.MONSIEUR);
		
		frenchEnum = SalutationMapper.MAPPER.toFrench(EnglishSalutationEnum.MISS);	
		assertThat(frenchEnum).isEqualTo(FrenchSalutationEnum.MADAME);
		
		frenchEnum = SalutationMapper.MAPPER.toFrench(EnglishSalutationEnum.DOCTOR);	
		assertThat(frenchEnum).isEqualTo(FrenchSalutationEnum.DOCTEUR);
		
		
		frenchEnum = SalutationMapper.MAPPER.toFrench(EnglishSalutationEnum.ADMIRAL);	
		assertThat(frenchEnum).isNull();
		
	
		frenchEnum = SalutationMapper.MAPPER.toFrench(EnglishSalutationEnum.PROFESSOR);	
		assertThat(frenchEnum).isEqualTo(FrenchSalutationEnum.MONSIEUR);
		
		frenchEnum = SalutationMapper.MAPPER.toFrench(null);	
		assertThat(frenchEnum).isEqualTo(FrenchSalutationEnum.INCONNU);
	}

	@Test
	public void toEnglish() {

		EnglishSalutationEnum englishEnum = SalutationMapper.MAPPER.toEnglish(FrenchSalutationEnum.MONSIEUR);	
		assertThat(englishEnum).isEqualTo(EnglishSalutationEnum.MISTER);
		
		englishEnum = SalutationMapper.MAPPER.toEnglish(FrenchSalutationEnum.MADAME);	
		assertThat(englishEnum).isEqualTo(EnglishSalutationEnum.MISS);
		
		englishEnum = SalutationMapper.MAPPER.toEnglish(FrenchSalutationEnum.DOCTEUR);	
		assertThat(englishEnum).isEqualTo(EnglishSalutationEnum.DOCTOR);
		
		englishEnum = SalutationMapper.MAPPER.toEnglish(FrenchSalutationEnum.INCONNU);	
		assertThat(englishEnum).isNull();
		
		englishEnum = SalutationMapper.MAPPER.toEnglish(null);	
		assertThat(englishEnum).isEqualTo(EnglishSalutationEnum.ADMIRAL);
			
	/*	assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> {SalutationMapper.MAPPER.toEnglish(FrenchSalutationEnum.valueOf("BLAHBLAH"));})
        .withStackTraceContaining("Unexpected enum constant");*/
	}
}
