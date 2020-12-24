package org.py.web2020.hibernate.entity.example97;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class BookJoinLibrary {
    @Id
    private Long id;
    private String title;
    private String author;
    private String name;
}
