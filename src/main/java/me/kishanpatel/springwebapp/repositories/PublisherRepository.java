package me.kishanpatel.springwebapp.repositories;

import me.kishanpatel.springwebapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
     
}
 