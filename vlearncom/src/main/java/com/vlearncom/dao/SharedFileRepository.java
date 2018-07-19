package com.vlearncom.dao;

import com.vlearncom.domain.SharedFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SharedFileRepository extends JpaRepository<SharedFile, Integer> {
}
