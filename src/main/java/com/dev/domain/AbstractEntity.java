package com.dev.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.ZonedDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity {

    @Column(name = "createdAt")
    @CreationTimestamp
    private ZonedDateTime createdAt;

    @Column(name = "updatedAt")
    @UpdateTimestamp
    private ZonedDateTime updatedAt;

}
