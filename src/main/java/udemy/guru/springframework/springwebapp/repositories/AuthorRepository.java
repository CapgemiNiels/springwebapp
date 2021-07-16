package udemy.guru.springframework.springwebapp.repositories;

import org.springframework.data.repository.CrudRepository;
import udemy.guru.springframework.springwebapp.domain.Author;

/**
 * @author NH 2021-07-16
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
