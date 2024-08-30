package org.shvedovva.util;

import org.shvedovva.dto.CurrencyDto;
import org.shvedovva.model.Currency;

public class CurrencyConverter {
    public static CurrencyDto convertToDto(Currency entity){
        return CurrencyDto.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getFullName())
                .sign(entity.getSign())
                .build();
    }
}
