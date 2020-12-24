package org.py.web2020.web.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private long cardId;
    private Integer num;
}
