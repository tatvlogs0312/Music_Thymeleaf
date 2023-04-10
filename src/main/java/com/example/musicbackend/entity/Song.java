package com.example.musicbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
@RequiredArgsConstructor
@Getter
@Setter
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "song")
    @SequenceGenerator(name = "song" , sequenceName = "song_id_seq", allocationSize = 1)
    private Long idSong;

    @Column(name = "name_song")
    private String nameSong;

    @Column(name = "length")
    private Integer length;

    @Column(name = "count_play")
    private Integer countPlay;

    @Column(name = "image")
    private String image;

    @Column(name = "link_song")
    private String linkSong;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "year")
    private Integer year;

    @Column(name = "value_search")
    private String valueSearch;

    @ManyToOne
    @JoinColumn(name = "id_artist")
    @JsonIgnore
    private Artist artist;

    @ManyToOne
    @JoinColumn(name = "id_national")
    @JsonIgnore
    private National national;

    @ManyToMany(mappedBy = "albumsSong")
    @JsonIgnore
    private List<Albums> songsAlbum;
}
