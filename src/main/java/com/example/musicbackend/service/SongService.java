package com.example.musicbackend.service;

import com.example.musicbackend.repository.AlbumsRepository;
import com.example.musicbackend.repository.SongRepository;
import com.example.musicbackend.dto.SongSearchDTO;
import com.example.musicbackend.entity.Artist;
import com.example.musicbackend.entity.Song;
import com.example.musicbackend.utility.CommonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SongService {
    private final SongRepository songRepository;
    private final ArtistService artistService;
    private final AlbumsRepository albumsRepository;
    private final ObjectMapper objectMapper;

    public List<Song> getAllSongs(){
        return songRepository.findAll();
    }

    public List<Song> getSubPopular(){
        return songRepository.findSongOrderByDesc6();
    }

    public List<Song> getTopTrending(){
        return songRepository.findSongOrderByDesc10();
    }

    public List<Song> getSongNew(){
        return songRepository.findSongByCreateAtDESC();
    }

    public Song getSongById(String id){
        Long idSong = Long.parseLong(id);
        Optional<Song> song = songRepository.findById(idSong);
        if(song.isPresent()){
            Song songData = song.get();
            songData.setCountPlay(songData.getCountPlay() + 1);
            songRepository.save(songData);
        }
        return song.orElse(null);
    }

    public List<Song> getSongOtherBySongId(String idSong){
        Long songId = Long.parseLong(idSong);
        Artist artist = artistService.getArtistBySong(idSong);
        if(artist != null) {
            return songRepository.findSongOthers(artist.getIdArtist(),songId);
        }
        return Collections.emptyList();
    }

    public List<SongSearchDTO> getSongByKeyWord(String keyWord){
        String key = CommonUtils.convertValueSearch(keyWord);
        List<Object[]> songList = songRepository.findSongByKeyWord(key);
        if(!CollectionUtils.isEmpty(songList)){
            return songList.stream().map(SongSearchDTO::new).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }


    public List<SongSearchDTO> getSongByAlums(String idAlbums){
        Long id = Long.parseLong(idAlbums);
        List<Object[]> songList = songRepository.findAllByAlbums(id);
        if(!CollectionUtils.isEmpty(songList)){
            return songList.stream().map(SongSearchDTO::new).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public List<SongSearchDTO> getSongByArtist(String idArtist){
        Long id = Long.parseLong(idArtist);
        List<Object[]> songList = songRepository.findAllByArtist(id);
        if(!CollectionUtils.isEmpty(songList)){
            return songList.stream().map(SongSearchDTO::new).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
