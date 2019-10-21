package com.leasing.customer_service.service.impl;


import com.leasing.customer_service.pojo.Book;
import com.leasing.customer_service.repository.BookRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @project:demo
 * @date:2019-10-15
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Service
public class DemoService {
    @Resource
    private BookRepository bookRepository;
    @PersistenceContext
    private EntityManager em;

    public void save () {

    }

    public void query() {
//        bookRepository.save(new Book("Java 101", "145804", 450));
//        bookRepository.save(new Book("Spring Bot", "48524", 289));
        Query q = em.createNamedQuery("Book.findByIsbnNativeXML" );
        q.setParameter("isbn", "145804");


        List<Book> list = q.getResultList();
    }

}