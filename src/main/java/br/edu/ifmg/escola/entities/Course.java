package br.edu.ifmg.escola.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "course")
public class Course {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String imgUri;
    private String imgGrayUri;

    @OneToMany(mappedBy = "course")
    private List<Offer> offers = new ArrayList<>();
}
