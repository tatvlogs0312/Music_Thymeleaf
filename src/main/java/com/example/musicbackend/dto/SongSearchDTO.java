package com.example.musicbackend.dto;

import com.example.musicbackend.utility.CommonUtils;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class SongSearchDTO {
    private Long idSong;

    private String nameSong;

    private Integer length;

    private Integer countPlay;

    private String image;

    private String mp3;

    private String artist;

    public SongSearchDTO(Object[] x){
        this.idSong = CommonUtils.convertLong(x[0]);
        this.nameSong = CommonUtils.convertString(x[1]);
        this.length = CommonUtils.convertInteger(x[2]);
        this.countPlay = CommonUtils.convertInteger(x[3]);
        this.image = CommonUtils.convertString(x[4]);
        this.mp3 = CommonUtils.convertString(x[5]);
        this.artist = CommonUtils.convertString(x[6]);
    }
}
