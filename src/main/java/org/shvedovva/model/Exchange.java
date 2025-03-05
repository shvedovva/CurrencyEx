package org.shvedovva.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.shvedovva.dto.CurrencyDto;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Exchange {
    private Long id;
    private Currency baseCurrency;
    private Currency targetCurrency;
    private BigDecimal rate;
//    private BigDecimal amount;
//    private BigDecimal convertedAmount;
}
