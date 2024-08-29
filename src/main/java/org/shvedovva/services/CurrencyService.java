package org.shvedovva.services;

import org.shvedovva.dao.CurrencyDao;
import org.shvedovva.dto.CurrencyDto;
import org.shvedovva.model.Currency;


import java.util.List;
import java.util.stream.Collectors;

public class CurrencyService {
    private final CurrencyDao currencyDao;
    public CurrencyService(CurrencyDao currencyDao) {
        this.currencyDao = currencyDao;
    }

    public List<CurrencyDto> findAll() {
        List<Currency> currencies = currencyDao.findAll();
        return currencies.stream()
                .map(c -> new CurrencyDto(c.getId(),c.getFullName(),c.getCode(),c.getSign()))
                .collect(Collectors.toList());
    }
}
