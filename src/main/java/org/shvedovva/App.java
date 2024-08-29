package org.shvedovva;

import org.shvedovva.dao.CurrencyDao;
import org.shvedovva.model.Currency;
import org.shvedovva.services.CurrencyService;

import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*CurrencyDao currencyDao = new CurrencyDao();
        List<Currency> list = currencyDao.findAll();
        System.out.println(list.toString());*/

        CurrencyDao currencyDao = new CurrencyDao();
        CurrencyService currencyService = new CurrencyService(currencyDao);

        System.out.println(currencyService.findAll());

    }
}
