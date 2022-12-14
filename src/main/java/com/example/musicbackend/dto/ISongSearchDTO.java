package com.example.musicbackend.dto;

public interface ISongSearchDTO {
    Long getIdSong();

    String getNameSong();

    Integer getLength();

    Integer getCountPlay();

    String getImage();

    String getMp3();

    String getArtist();
}
