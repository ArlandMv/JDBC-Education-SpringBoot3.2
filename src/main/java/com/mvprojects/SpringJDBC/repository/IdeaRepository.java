package com.mvprojects.SpringJDBC.repository;

import com.mvprojects.SpringJDBC.model.Idea;

import java.util.List;
import java.util.Optional;

public interface IdeaRepository {
    //read
    Optional<Idea> findById(int ideaId);
    List<Idea> findAll();

    void save(Idea idea);
    void update(Idea idea);
    void delete(int ideaId);

}
