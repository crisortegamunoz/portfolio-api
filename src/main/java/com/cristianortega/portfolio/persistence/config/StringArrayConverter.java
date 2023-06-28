package com.cristianortega.portfolio.persistence.config;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class StringArrayConverter implements AttributeConverter<String[], String> {

    private static final String DELIMITER = ",";

    @Override
    public String convertToDatabaseColumn(String[] attribute) {
        if (attribute == null) {
            return null;
        }
        return String.join(DELIMITER, attribute);
    }

    @Override
    public String[] convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return dbData.split(DELIMITER);
    }
}