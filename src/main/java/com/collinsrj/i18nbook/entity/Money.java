package com.collinsrj.i18nbook.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.util.Currency;

@Data
@Embeddable
@NoArgsConstructor
public class Money {
    @Column(scale = 4, precision = 13)
    BigDecimal amount;
    @Column(length = 3)
    @Convert(converter = CurrencyConverter.class)
    Currency currency;

    /**
     *
     * @param amount the decimal amount
     * @param currency the ISO currency code e.g. 'EUR'
     */
    public Money(BigDecimal amount, String currency) {
        this.currency = Currency.getInstance(currency);
    }
}
