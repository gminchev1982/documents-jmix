package net.minchev.documents.entity;

import net.minchev.documents.entity.interfaces.NameableDefinition;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@JmixEntity
@Entity
@Table(name = "document_status")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentStatus implements NameableDefinition {

    @Id
    @Column(name = "id", nullable = false)
    @Getter(onMethod_ = @Override)
    @Setter(onMethod_ = @Override)
    private Long id;

    @InstanceName
    @Size(max = 100)
    @Column(name = "document_status_name")
    @Getter(onMethod_ = @Override)
    @Setter(onMethod_ = @Override)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_type_id", nullable = false)
    private DocumentType documentType;
}
