
package com.practise.mapstruct.hexagonalbank.mapper;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.mapstruct.Qualifier;


public class RoundingUtil {


    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Fraction2 { }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public static @interface Fraction3 { }


    @Fraction2
    public Double fraction2( BigDecimal in ) {

        return in == null ? null : in.setScale( 2, RoundingMode.DOWN ).doubleValue();
    }

    @Fraction3
    public BigDecimal fraction3( Double in ) {

        return in == null ? null : new BigDecimal(in).setScale( 3, RoundingMode.DOWN );
    }

}
