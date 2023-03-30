package com.shivam.todos.repository;

import com.shivam.todos.model.Todo;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>
{

  List<Todo> findAll();
  Optional<Todo> findById(Long id);
}
