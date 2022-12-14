package com.example.musicbackend.repository;

import com.example.musicbackend.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    @Query(value = "SELECT * from song order by count_play desc limit 6", nativeQuery = true)
    List<Song> findSongOrderByDesc6();

    @Query(value = "SELECT * from song order by count_play desc limit 10", nativeQuery = true)
    List<Song> findSongOrderByDesc10();

    @Query(value = "SELECT * from song s \n" +
            "left join artist a on a.id_artist = s.id_artist \n" +
            "where a.id_artist = :idArtist and s.id_song != :idSong ORDER BY RAND() limit 5", nativeQuery = true)
    List<Song> findSongOthers(Long idArtist,Long idSong);

    @Query(value = "SELECT s.id_song, s.name_song, s.`length`, s.count_play, s.image, s.link_song, a.name from song s \n" +
            "left join artist a on a.id_artist = s.id_artist\n" +
            "WHERE s.value_search like %:keyWord%", nativeQuery = true)
    List<Object[]> findSongByKeyWord(String keyWord);

    @Query(value = "SELECT * from song s order by s.create_at DESC limit 6",nativeQuery = true)
    List<Song> findSongByCreateAtDESC();

    @Query(value = "SELECT s.id_song, s.name_song, s.`length`, s.count_play, s.image, s.link_song, a2.name from song s \n" +
            "left join albums_song as2 on as2.id_song = s.id_song \n" +
            "left join albums a on a.id_albums = as2.id_albums \n" +
            "LEFT JOIN artist a2 on a2.id_artist = s.id_artist \n" +
            "where a.id_albums = :idAlbums", nativeQuery = true)
    List<Object[]> findAllByAlbums(Long idAlbums);

    @Query(value = "SELECT s.id_song, s.name_song, s.`length`, s.count_play, s.image, s.link_song, a2.name from song s \n" +
            "LEFT JOIN artist a2 on a2.id_artist = s.id_artist \n" +
            "where a2.id_artist = :idArtist", nativeQuery = true)
    List<Object[]> findAllByArtist(Long idArtist);
}