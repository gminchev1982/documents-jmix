package net.minchev.documents.entity.enums;

import io.jmix.core.metamodel.datatype.impl.EnumClass;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.stream.Stream;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
public enum DocumentKind implements EnumClass<String> {

    INTERNAL("I"),
    SERVICE("S"),
    OUTCOMING("O");

    private final String kind;

    @Override
    public String getId() {
        return kind;
    }
    public String getKind() {
        return kind;
    }

   /* public static DocumentKind fromId(String id) {
        for (DocumentKind at : DocumentKind.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }*/

   public static DocumentKind fromId(@NonNull String id) {
       DocumentKind dKind = Stream.of(DocumentKind.values())
               .filter(documentKind -> documentKind.getId().equals(id))
               .findFirst()
               .orElse(null);

       return dKind;
   }
}
