package com.lorenzo.api_imoveis.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id"
)
@JsonIgnoreProperties({"userHasImovel"})
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /* 
     * @ManyToMany
    @JoinTable(name="pessoa_has_imoveis", joinColumns=
            {@JoinColumn(name="pessoa_id")}, inverseJoinColumns=
            {@JoinColumn(name="imoveis_id")})
    private List<Imoveis> imoveis;
    */
    

    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    List<UserHasImovel> userhasimovel;


    private String name;
    private String cpf;
    private String phone;
    private String email;
    private String password;
}
