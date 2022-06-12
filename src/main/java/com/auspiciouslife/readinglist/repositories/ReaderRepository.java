package com.auspiciouslife.readinglist.repositories;

import com.auspiciouslife.readinglist.entities.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader, String> {
}
