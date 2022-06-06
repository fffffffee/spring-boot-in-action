package com.auspiciouslife.readinglist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReadingListRepository extends CrudRepository<Book, Long> {

    List<Book> findByReader(String reader);
}
