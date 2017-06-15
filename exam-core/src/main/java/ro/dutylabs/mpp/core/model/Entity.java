package ro.dutylabs.mpp.core.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "entities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Entity extends BaseEntity<Long> {
    @Column(name = "name")
    private String name;
}

