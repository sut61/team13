package com.okta.developer.demo.entity;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;
@Entity
@Data

@Table(name = "MediaRoom")
public class MediaRoom{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private @NonNull long mediaRoomId;
    private @NonNull String mediaRoom;

    public MediaRoom(){}
    public MediaRoom(String mediaRoom){
        this.mediaRoom = mediaRoom;
    }
}
