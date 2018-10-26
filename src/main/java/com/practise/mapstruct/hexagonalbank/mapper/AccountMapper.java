package com.practise.mapstruct.hexagonalbank.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.practise.mapstruct.hexagonalbank.entities.domain.Account;
import com.practise.mapstruct.hexagonalbank.entities.dto.AccountDto;
import com.practise.mapstruct.hexagonalbank.mapper.RoundingUtil.Fraction2;
import com.practise.mapstruct.hexagonalbank.mapper.RoundingUtil.Fraction3;

@Mapper(uses=RoundingUtil.class)
public interface AccountMapper {

	
	public static final AccountMapper MAPPER = Mappers.getMapper(AccountMapper.class);
	
	@Mappings({
	@Mapping(target = "id", source = "accountId"),
	@Mapping(target = "balance", qualifiedBy = Fraction2.class),
	@Mapping(target = "accountType", source = "accountType.code" )
	})
	public AccountDto toDto(Account account);
	
	@Mappings({
		@Mapping(target = "accountId", source = "id"),
		@Mapping(target = "balance", qualifiedBy = Fraction3.class),
		@Mapping(target ="accountType", expression = "java( com.practise.mapstruct.hexagonalbank.entities.domain.AccountTypeEnum.getEnumByCode(accountDto.getAccountType()) )")
	})
	public Account toDomain(AccountDto accountDto);

}
