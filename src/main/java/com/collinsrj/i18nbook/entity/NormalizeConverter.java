package com.collinsrj.i18nbook.entity;


import com.ibm.icu.text.Normalizer2;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import static com.ibm.icu.text.Normalizer.YES;

/**
 *
 */
@Converter(autoApply = true)
public class NormalizeConverter implements
        AttributeConverter<String, String> {
    private final Normalizer2 n = Normalizer2.getNFCInstance();

    @Override
    public String convertToDatabaseColumn(String s) {
        return YES.equals(n.quickCheck(s)) ? s : n.normalize(s);
    }

    @Override
    public String convertToEntityAttribute(String s) {
        return s;
    }
}
