package pro.sisit.unit9.data;

import pro.sisit.unit9.entity.Book;
import org.springframework.data.jpa.domain.Specification;

public class BookSpecifications {
    public static Specification<Book> yearsLessThan(int year) {
        return (root, query, cb) -> cb.lessThanOrEqualTo(root.get("year"), year);
    }

    public static Specification<Book> yearsGreaterThan(int year) {
        return (root, query, cb) -> cb.greaterThanOrEqualTo(root.get("year"), year);
    }

    public static Specification<Book> rangeBetween(int startYear, int finishYear) {
        return yearsLessThan(finishYear).and(yearsGreaterThan(startYear));
    }
}
