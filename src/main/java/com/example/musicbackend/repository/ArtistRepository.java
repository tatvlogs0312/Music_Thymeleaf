package com.example.musicbackend.repository;

import com.example.musicbackend.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

    @Query(value = "select DISTINCT a.* from artist a \n" +
            "left join song s on a.id_artist = s.id_artist \n" +
            "where s.id_song = :idSong", nativeQuery = true)
    Optional<Artist> findArtistBySongId(Long idSong);
}