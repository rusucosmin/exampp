package ro.dutylabs.mpp.core.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 * Created by cosmin on 14/06/2017.
 */
@javax.persistence.Entity
@Table(name = "pizzas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pizza extends BaseEntity<Long> {
    public enum Cuisine { MEDITERRANEAN, ORIENTAL };
    @Column(name = "name", unique = true)
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="price")
    private float price;
    @Column(name="cuisine")
    @Enumerated(EnumType.STRING)
    private Cuisine cuisine;
}
