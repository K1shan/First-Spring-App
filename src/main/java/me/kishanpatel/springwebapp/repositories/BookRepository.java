package me.kishanpatel.springwebapp.repositories;

import me.kishanpatel.springwebapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
     
}
 