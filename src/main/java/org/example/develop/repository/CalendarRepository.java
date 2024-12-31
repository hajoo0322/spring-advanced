package org.example.develop.repository;

import org.example.develop.entity.CalendarEntity;
import org.example.develop.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalendarRepository extends JpaRepository<CalendarEntity,Long> {

    List<CalendarEntity> findByUser(UserEntity userEntity);

    CalendarEntity findByTitle(String title);

    void deleteByUser(UserEntity userEntity);
}
