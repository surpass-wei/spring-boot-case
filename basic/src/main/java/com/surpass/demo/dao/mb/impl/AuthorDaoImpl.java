package com.surpass.demo.dao.mb.impl;

import com.surpass.demo.dao.mb.AuthorDao;
import com.surpass.demo.domain.Author;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by surpass.wei@gmail.com on 2017/1/23.
 */
@Repository
public class AuthorDaoImpl implements AuthorDao {
    @Override
    public int add(Author author) {
        return 0;
    }

    @Override
    public int update(Author author) {
        return 0;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public Author findAuthor(Long id) {
        return null;
    }

    @Override
    public List<Author> findAuthorList() {
        return null;
    }
}
