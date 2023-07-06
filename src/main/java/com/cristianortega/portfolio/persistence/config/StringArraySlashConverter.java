package com.cristianortega.portfolio.persistence.config;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class StringArraySlashConverter implements AttributeConverter<String[], String> {

    private static final String SLASH = "/";

    @Override
    public String convertToDatabaseColumn(String[] attribute) {
        if (attribute == null) {
            return null;
        }
        return String.join(SLASH, attribute);
    }

    @Override
    public String[] convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return dbData.split(SLASH);
    }
}
