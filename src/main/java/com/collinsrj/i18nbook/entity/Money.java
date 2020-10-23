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
    @Column
    BigDecimal amount;
    @Column(length = 3)
    @Convert(converter = CurrencyConverter.class)
    Currency currency;

    public Money(BigDecimal amout, String currency) {
        this.currency = Currency.getInstance(currency);
    }
}
