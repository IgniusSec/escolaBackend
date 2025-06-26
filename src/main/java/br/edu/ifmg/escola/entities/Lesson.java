package br.edu.ifmg.escola.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
//Single table = 1 tabela pra todos os filhos
//joined = cria uma tabela pra cada filho com relacionamento de herança
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tb_lesson")
public class Lesson {
    @Id
    @EqualsAndHashCode.Include
    private long id;
    private String title;
    private Integer position;


    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    @ManyToMany
    @JoinTable(name = "tb_lessons_done",
            joinColumns = @JoinColumn(name = "lesson_id"),
            inverseJoinColumns = {
                @JoinColumn(name = "user_id"), @JoinColumn(name = "offer_id")
            }
    )
    private Set<Enrollment> enrollmentsDone = new HashSet<Enrollment>();
}
