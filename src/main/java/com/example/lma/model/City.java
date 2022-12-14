package com.example.lma.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private  String name;
    @OneToMany(mappedBy = "city")
    @JsonIgnore
    private List<Company> companys = new ArrayList<>();
    @ManyToOne
    private Country country;
}
