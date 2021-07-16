package udemy.guru.springframework.springwebapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import udemy.guru.springframework.springwebapp.domain.Book;

/**
 * @author NH 2021-07-16
 */
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
