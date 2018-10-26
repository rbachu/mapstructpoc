package com.practise.mapstruct.hexagonalbank.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.practise.mapstruct.hexagonalbank.entities.domain.Customer;
import com.practise.mapstruct.hexagonalbank.entities.dto.CustomerDto;
import com.practise.mapstruct.hexagonalbank.mapper.MappingUtil.AadharCard;
import com.practise.mapstruct.hexagonalbank.mapper.MappingUtil.PanCard;

@Mapper(uses ={AccountMapper.class, SalutationMapper.class, MappingUtil.class})
public interface CustomerMapper {
	
	public static final CustomerMapper MAPPER = Mappers.getMapper(CustomerMapper.class);
	
	@Mapping(target = "customerName", source = "name")
	@Mapping(target ="customerAccounts" , source = "accounts")
	@Mapping(target ="panCard" , source = "documents", qualifiedBy = PanCard.class)
	@Mapping(target ="aadharCard" , source = "documents", qualifiedBy = AadharCard.class )
	public CustomerDto toDto(Customer customer);
	
	@InheritInverseConfiguration
	@Mapping(target ="documents", ignore = true)
	public Customer toDomain(CustomerDto customerDto);

}
