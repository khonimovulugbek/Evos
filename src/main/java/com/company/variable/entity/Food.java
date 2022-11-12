package com.company.variable.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "food")
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name",unique = true)
    private String name;
    @Column(name = "title_uz")
    private String titleUz;
    @Column(name = "title_ru")
    private String titleRu;
    @Column(name = "cost")
    private Long cost;
    @Column(name = "img_uz")
    private String imgUz;
    @Column(name = "img_ru")
    private String imgRu;

}