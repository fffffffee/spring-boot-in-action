package com.auspiciouslife.readinglist.repositories;

import com.auspiciouslife.readinglist.entities.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReadingListRepository extends CrudRepository<Book, Long> {

    List<Book> findByReader(String reader);
}
