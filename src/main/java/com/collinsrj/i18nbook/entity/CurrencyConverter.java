package com.collinsrj.i18nbook.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Currency;

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
