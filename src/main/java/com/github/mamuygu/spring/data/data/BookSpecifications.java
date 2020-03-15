package com.github.mamuygu.spring.data.data;

import com.github.mamuygu.spring.data.entity.Book;
import org.springframework.data.jpa.domain.Specification;

public class BookSpecifications {
    public static Specification<Book> yearLessThan(int year) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("year"), year);
    }

    public static Specification<Book> yearGreaterThan(int year) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("year"), year);
    }

    public static Specification<Book> byYearRange(int startYear, int finishYear) {
        return yearLessThan(finishYear).and(yearGreaterThan(startYear));
    }
}
