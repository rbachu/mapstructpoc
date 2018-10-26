package com.practise.mapstruct.hexagonalbank.mapper;

import org.mapstruct.Qualifier;

import com.practise.mapstruct.hexagonalbank.entities.domain.KYCDocument;
import com.practise.mapstruct.hexagonalbank.entities.domain.KYCDocumentTypeEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;


public class MappingUtil {

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface PanCard {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public static @interface AadharCard {
    }

    @PanCard
    public String panCard(Map<String, KYCDocument> in) {
    	if(null == in){
    		return null;
    	}
    	if(in.containsKey(KYCDocumentTypeEnum.PANCARD.name())){
    		return  in.get(KYCDocumentTypeEnum.PANCARD.name()).getId();
    	}
    	return null;
    }

    @AadharCard
    public String aadharCard(Map<String, KYCDocument> in) {
    	if(null == in){
    		return null;
    	}
    	if(in.containsKey(KYCDocumentTypeEnum.AADHARCARD.name())){
    		return  in.get(KYCDocumentTypeEnum.AADHARCARD.name()).getId();
    	}
    	return null;
    }


}
