package com.collinsrj.i18nbook.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Currency;

/**
 * If space is at a premium, and performance is a factor, the numeric code could also be used with the column type  of
 * `tinyint` or `smallint` depending on platform support.
 */
@Converter
public class CurrencyConverter implements AttributeConverter<Currency, String> {


    @Override
    public String convertToDatabaseColumn(final Currency currency) {
        return currency.getCurrencyCode();
    }

    @Override
    public Currency convertToEntityAttribute(final String s) {
        return Currency.getInstance(s);
    }
}
