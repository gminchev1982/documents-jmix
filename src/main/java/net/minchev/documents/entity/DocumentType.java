package net.minchev.documents.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import net.minchev.documents.entity.interfaces.IdentityDefinition;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@JmixEntity
@Entity
@Table(name = "document_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentType implements IdentityDefinition {

    @Id
    @Column(name = "ID", nullable = false)
    @Getter(onMethod_ = @Override)
    @Setter(onMethod_ = @Override)
    @JmixGeneratedValue(sequenceName = "CORRESPONDENCE_ID_SEQ")
    private Long id;

    @InstanceName
    @Size(max = 1000)
    @Column(name = "document_type_name_long", nullable = false)
    private String longName;

    @Size(max = 100)
    @Column(name = "document_type_name_short")
    private String shortName;

    @Size(max = 2000)
    @Column(name = "document_type_template")
    private String template;
}
