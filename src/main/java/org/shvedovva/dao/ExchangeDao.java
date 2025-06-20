package org.shvedovva.dao;

import org.shvedovva.model.Exchange;

import java.util.List;

public class ExchangeDao implements CrudDAO<Exchange, Long>{

    private CurrencyDao currencyDao = new CurrencyDao();

    /*@Override
    public Exchange findById(Long id) {
        return null;
    }
*/
    @Override
    public List<Exchange> findAll() {
        return null;
    }

    @Override
    public void save(Exchange entity) {

    }

    @Override
    public void delete(Long aLong) {

    }
}
