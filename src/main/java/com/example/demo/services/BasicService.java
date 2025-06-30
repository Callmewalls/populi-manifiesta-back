package com.example.demo.services;

import java.util.List;
import java.util.Optional;


public interface BasicService<T, D, ID> {

    public List<D> findAll();

    public Optional<D> findById(ID id);

    public D save(D entity);

    public void deleteById(ID id);

    public List<D> mapToList(List<T> sourceList);
}

