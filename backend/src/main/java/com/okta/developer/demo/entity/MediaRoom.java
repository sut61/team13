package com.okta.developer.demo.entity;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.*;
@Entity
@Data

@Table(name = "MediaRoom")
public class MediaRoom{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private @NonNull long mediaRoomId;

    @NotNull(message="media room must not be null to be valid")
    @Pattern(regexp = "^Media\\d{1}")
    @Column(unique = true)
    //@Size(min = 5 ,max = 20)
    private @NonNull String mediaRoom;

    public MediaRoom(){}
    public MediaRoom(String mediaRoom){
        this.mediaRoom = mediaRoom;
    }

    public void setMediaRoom(String mediaRoom){
        this.mediaRoom = mediaRoom;
    }
    public String getMediaRoom(){
        return mediaRoom;
    }
    public void setMediaRoomId(Long mediaRoomId){
        this.mediaRoomId = mediaRoomId;
    }

    public long getMediaRoomId() {
        return mediaRoomId;
    }
}
