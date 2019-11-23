package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRespository extends CrudRepository<Publisher, Long> {

}
