package org.py.web2020.web.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String sex;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Card card;
}
