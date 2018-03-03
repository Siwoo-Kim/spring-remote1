package com.siwoo.application.repository;

import com.siwoo.application.domain.Singer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SingerRepository extends JpaRepository<Singer,Long>{
    List<Singer> findByFirstName(String firstName);
}
