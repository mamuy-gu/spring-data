package pro.sisit.unit9.data;

import pro.sisit.unit9.entity.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
