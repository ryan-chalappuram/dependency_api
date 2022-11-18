package com.dependency.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
//@AllArgsConstructor
@Data
@Embeddable
@JsonIgnoreProperties
@NoArgsConstructor
public class CpeList {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @JsonProperty("cpe-item")
        //@OneToMany(cascade = CascadeType.ALL)
        @Embedded
        private List<CpeItem> cpeItems;

}
