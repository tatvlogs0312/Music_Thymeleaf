package com.example.musicbackend.repository;

import com.example.musicbackend.entity.Albums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumsRepository extends JpaRepository<Albums, Long> {

    @Query(value = "SELECT a.* FROM albums a \n" +
            "LEFT JOIN albums_song as2 ON a.id_albums = as2.id_albums \n" +
            "LEFT JOIN song s ON as2.id_song = s.id_song \n" +
            "WHERE s.id_song = :songId", nativeQuery = true)
    public List<Albums> getAllAlbumsBySong(Long songId);

    @Query(value = "SELECT * from albums a order by a.create_at DESC limit 6", nativeQuery = true)
    public List<Albums> getAllLimit6();
}