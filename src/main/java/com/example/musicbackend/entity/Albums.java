package com.example.musicbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
@Table
@Entity
public class Albums {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "albums")
//    @SequenceGenerator(name = "album" , sequenceName = "album_id_seq", allocationSize = 1)
    @Column(name = "id_albums")
    private Long idAlbums;

    @Column(name = "album_name")
    private String albumName;

    @Column(name = "image_album")
    private String imageAlbum;

    @Column(name = "create_at")
    private LocalDateTime createAt;
    @ManyToMany
    @JoinTable(name = "albums_song", joinColumns = @JoinColumn(name = "id_albums"), inverseJoinColumns = @JoinColumn(name = "id_song"))
    @JsonIgnore
    private List<Song> albumsSong;
}
