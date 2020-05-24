package br.uece.ees.moviesapi.infrastructure;

import java.time.Year;
import javax.persistence.Converter;
import javax.persistence.AttributeConverter;

@Converter(autoApply = true)
public class YearAttributeConverter implements AttributeConverter<Year, Short> {

    @Override
    public Short convertToDatabaseColumn(Year attribute) {
        return (short) attribute.getValue();
    }

    @Override
    public Year convertToEntityAttribute(Short fromDatabase) {
        return Year.of(fromDatabase);
    }

}
