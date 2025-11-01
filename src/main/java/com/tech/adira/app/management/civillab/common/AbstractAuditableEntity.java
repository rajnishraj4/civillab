package com.tech.adira.app.management.civillab.common;

import com.tech.adira.app.management.civillab.utils.UlidUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Auditable;

import java.time.Instant;
import java.util.Optional;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class AbstractAuditableEntity implements Auditable<String, String, Instant> {

    @Id
    @Column(name = "id", length = 26, nullable = false, updatable = false)
    protected String id;

    @Column(name = "created_by", updatable = false, length = 100)
    protected String createdBy;

    @Column(name = "created_at", updatable = false, nullable = false)
    protected Instant createdDate;

    @Column(name = "updated_by", length = 100)
    protected String lastModifiedBy;

    @Column(name = "updated_at", nullable = false)
    protected Instant lastModifiedDate;

    @PrePersist
    protected void prePersist() {
        if (this.id == null) {
            this.id = UlidUtils.nextId();
        }
        if (this.createdDate == null) {
            this.createdDate = Instant.now();
        }
        if (this.lastModifiedDate == null) {
            this.lastModifiedDate = Instant.now();
        }
    }

    @PostUpdate
    protected void preUpdate() {
        this.lastModifiedDate = Instant.now();
    }

    @Override
    public Optional<String> getCreatedBy() {
        return Optional.ofNullable(createdBy);
    }

    @Override
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public Optional<Instant> getCreatedDate() {
        return Optional.ofNullable(createdDate);
    }

    @Override
    public void setCreatedDate(Instant createdDate) {
        //NOP
    }

    @Override
    public Optional<String> getLastModifiedBy() {
        return Optional.ofNullable(lastModifiedBy);
    }

    @Override
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @Override
    public Optional<Instant> getLastModifiedDate() {
        return Optional.ofNullable(lastModifiedDate);
    }

    @Override
    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public boolean isNew() {
        return this.id == null;
    }
}
