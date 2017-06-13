package ro.dutylabs.mpp.core.model;

import lombok.*;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "entities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Entity extends BaseEntity<Long> {
    @Column(name = "name", nullable = false)
    private String name;
}

