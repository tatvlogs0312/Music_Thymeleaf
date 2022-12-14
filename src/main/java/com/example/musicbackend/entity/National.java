package com.example.musicbackend.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@RequiredArgsConstructor
@Getter
@Setter
public class National {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "national")
//    @SequenceGenerator(name = "national" , sequenceName = "national_id_seq", allocationSize = 1)
    @Column(name = "id_national")
    private Long idNational;

    @Column(name = "name_national")
    private String nameNational;

    @OneToMany(mappedBy = "idSong")
    private List<Song> nationalSong;
}
