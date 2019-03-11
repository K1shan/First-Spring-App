package me.kishanpatel.springwebapp.repositories;

import me.kishanpatel.springwebapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
