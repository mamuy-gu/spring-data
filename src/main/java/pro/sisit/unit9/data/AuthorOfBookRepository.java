package pro.sisit.unit9.data;

import pro.sisit.unit9.entity.AuthorOfBook;
import org.springframework.data.repository.CrudRepository;

public interface AuthorOfBookRepository extends CrudRepository<AuthorOfBook, Long> {
}
