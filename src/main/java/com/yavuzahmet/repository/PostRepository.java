package com.yavuzahmet.repository;

import com.yavuzahmet.model.Post;
import org.springframework.data.repository.ListCrudRepository;

/**
 * If we use CrudRepository, the returned data is iterable,
 * with ListCrudRepository we can directly return the data as a list.
 */
public interface PostRepository extends ListCrudRepository<Post, Long> {
}