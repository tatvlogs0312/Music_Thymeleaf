package com.example.musicbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@RequiredArgsConstructor
@Getter
@Setter
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "artist")
//    @SequenceGenerator(name = "artist" , sequenceName = "artist_id_seq", allocationSize = 1)
    @Column(name = "id_artist")
    private Long idArtist;

    @Column(name = "name")
    private String name;

    @Column(name = "avatar")
    private String avatar;

    @OneToMany(mappedBy = "idSong")
    @JsonIgnore
    private List<Song> artisSong;
}
