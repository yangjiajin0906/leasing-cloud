package com.leasing.customer_service.repository;

import com.leasing.customer_service.pojo.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

    // TODO: add named query methods
}