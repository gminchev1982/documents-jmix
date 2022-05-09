package net.minchev.documents.entity;

import net.minchev.documents.entity.enums.DocumentKind;
import net.minchev.documents.entity.interfaces.IdentityDefinition;
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
import javax.persistence.EntityListeners;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;

@JmixEntity
@Entity
@Table(name = "documents")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Document implements IdentityDefinition {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DOCUMENTS_ID_SEQ")
    @SequenceGenerator(name = "DOCUMENTS_ID_SEQ", sequenceName = "DOCUMENTS_ID_SEQ", allocationSize = 1)
    @Getter(onMethod_ = @Override)
    @Setter(onMethod_ = @Override)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_type_id", nullable = false)
    private DocumentType type;

    @Size(max = 100)
    @Column(name = "document_number", nullable = false)
    private String number;

    @Column(name = "document_date", nullable = false)
    private LocalDateTime date;

    @Size(max = 1000)
    @Column(name = "document_description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_status_id", nullable = false)
    private DocumentStatus status;

    @Column(name = "document_status_date", nullable = false)
    private LocalDateTime statusDate;

    @Size(max = 100)
    @Column(name = "document_extrenal_number")
    private String externalNumber;

    @Column(name = "document_external_date")
    private LocalDateTime externalDate;

    @Size(max = 10)
    @Column(name = "document_entry_type")
    private String entryType;

    @Column(name = "document_kind", nullable = false)
    private String kind;

    public DocumentKind getKind() {
        return Objects.isNull(kind) ? null : DocumentKind.fromId(kind);
    }

    public void setKind(DocumentKind kind) {
        this.kind = Objects.isNull(kind) ? null : kind.getId();
    }

    //TO DO: Should add  webdav_document_id         VARCHAR2(32) NOT NULL
}
