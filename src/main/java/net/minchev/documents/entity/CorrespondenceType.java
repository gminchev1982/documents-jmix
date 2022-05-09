package net.minchev.documents.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minchev.documents.entity.interfaces.IdentityDefinition;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@JmixEntity
@Entity
@Table(name = "correspondence_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CorrespondenceType implements IdentityDefinition {
    @Id
    @Column(name = "ID", nullable = false)
    @Getter(onMethod_ = @Override)
    @Setter(onMethod_ = @Override)
    @JmixGeneratedValue(sequenceName = "CORRESPONDENCE_TYPE_ID_SEQ")
    private Long id;

    @InstanceName
    @Size(max = 100)
    @Column(name = "CORRESPONDENCE_TYPE_NAME_SHORT", nullable = false)
    private String shortName;

    @Size(max = 1000)
    @Column(name = "CORRESPONDENCE_TYPE_NAME_LONG")
    private String longName;
}
