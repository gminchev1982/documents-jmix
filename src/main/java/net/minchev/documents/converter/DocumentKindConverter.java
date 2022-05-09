package net.minchev.documents.converter;

import net.minchev.documents.entity.enums.DocumentKind;

import javax.persistence.AttributeConverter;
import java.util.stream.Stream;

public class DocumentKindConverter implements AttributeConverter<DocumentKind, String> {
    @Override
    public String convertToDatabaseColumn(DocumentKind documentKind) {
        return documentKind.getId();
    }

    @Override
    public DocumentKind convertToEntityAttribute(String dbData) {
         return Stream.of(DocumentKind.values())
                .filter(documentKind -> documentKind.getId().equals(dbData))
                .findFirst()
                .orElse(null);
    }
}
