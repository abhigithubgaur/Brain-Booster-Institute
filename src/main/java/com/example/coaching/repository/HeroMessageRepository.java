package com.example.coaching.repository;

import com.example.coaching.model.HeroMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HeroMessageRepository extends JpaRepository<HeroMessage,Long> {
    List<HeroMessage> findAllByOrderByDisplayOrderAsc();
}
