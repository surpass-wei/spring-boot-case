package com.surpass.demo.dao.mb;

import com.surpass.demo.domain.Author;

import java.util.List;

/**
 * Created by surpass.wei@gmail.com on 2017/1/23.
 */
public interface AuthorDao {
    int add(Author author);
    int update(Author author);
    int delete(Long id);
    Author findAuthor(Long id);
    List<Author> findAuthorList();
}
