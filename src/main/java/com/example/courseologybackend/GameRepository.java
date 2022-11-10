package com.example.courseologybackend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    @Query(value="Select distinct id from cards", nativeQuery = true)
    List<Long> getDistinctIds();






}
