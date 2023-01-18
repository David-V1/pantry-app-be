package net.yorksolutions.pantryappbe.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @Lob
    @Column(name = "instructions", length = 10000)
    private String instructions;


    @JsonIgnore
    @OneToMany(mappedBy = "recipes", cascade = CascadeType.ALL)
    private List<Ingredient> ingredient;

    @ManyToOne(optional = false)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

}
