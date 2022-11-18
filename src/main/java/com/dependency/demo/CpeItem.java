package com.dependency.demo;



import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
//@AllArgsConstructor
@Table
@Embeddable
@NoArgsConstructor
public class CpeItem{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("references")
//    @OneToOne(cascade = CascadeType.ALL)
    @Embedded
    public References references;
    @JsonProperty("title")
    public String title;
    @JsonProperty("content")
    public String content;
    @JsonProperty("cpe23-item")
    public String cpe23_item;
}