package br.edu.ifmg.escola.entities;

import br.edu.ifmg.escola.constants.ResourceType;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "resource")
public class Resource {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private Integer position;
    private String imgUri;

    @Enumerated(EnumType.STRING) //ordinal or string
    private ResourceType resourceType;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;
}
