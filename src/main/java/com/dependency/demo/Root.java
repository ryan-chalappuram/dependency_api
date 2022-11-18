package com.dependency.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@AllArgsConstructor
@Data
public class Root {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    @OneToMany(cascade=CascadeType.ALL)
    // @ElementCollection
    @Embedded
    private CpeList cpelist;

}
