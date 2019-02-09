package com.okta.developer.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.okta.developer.demo.entity.MediaRoom;

@RepositoryRestResource
public interface MediaRoomRepository extends JpaRepository<MediaRoom, Long> {

}
