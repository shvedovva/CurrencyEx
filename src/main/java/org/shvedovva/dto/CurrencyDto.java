package org.shvedovva.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CurrencyDto {
    private Long id;
    private String name;
    private String code;
    private String sign;
}
