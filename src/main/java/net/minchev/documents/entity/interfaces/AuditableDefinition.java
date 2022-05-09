package net.minchev.documents.entity.interfaces;

import java.time.LocalDateTime;

public interface AuditableDefinition extends IdentityDefinition {

    Long getCreatedBy();

    void setCreatedBy(Long createdBy);

    LocalDateTime getCreatedDate();

    void setCreatedDate(LocalDateTime createdDate);

    Long getLastModifiedBy();

    void setLastModifiedBy(Long lastModifiedBy);

    LocalDateTime getLastModifiedDate();

    void setLastModifiedDate(LocalDateTime date);
}
