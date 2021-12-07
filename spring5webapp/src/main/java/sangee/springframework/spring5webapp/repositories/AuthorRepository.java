package sangee.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import sangee.springframework.spring5webapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
