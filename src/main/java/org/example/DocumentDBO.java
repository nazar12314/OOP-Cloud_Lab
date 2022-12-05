package org.example;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Document")
@Getter
@Setter
public class DocumentDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String imgLink;

    private String imgData;
}
