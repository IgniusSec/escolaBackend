package br.edu.ifmg.escola.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_offer")
public class Offer {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String edition;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIMEZONE")
    private Instant startMoment;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIMEZONE")
    private Instant endMoment;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "offer")
    private List<Resource> resources = new ArrayList<Resource>();

    @OneToMany(mappedBy = "offer")
    private List<Topic> topics = new ArrayList<Topic>();
}
