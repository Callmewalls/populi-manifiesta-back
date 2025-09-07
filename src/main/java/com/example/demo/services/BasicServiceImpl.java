package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class BasicServiceImpl<T, D, ID> implements BasicService<T, D, ID> {

    protected final JpaRepository<T, ID> repository;
    private final Class<T> entityClass;
    private final Class<D> dtoClass;

    @Autowired
    ModelMapper modelMapper;

    public BasicServiceImpl(JpaRepository<T, ID> repository,
                            Class<T> entityClass,
                            Class<D> dtoClass) {
        this.repository = repository;
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }

    @Override
    public List<D> findAll() {
        List<T> entities = repository.findAll();
        return entities.stream()
                .map(entity -> modelMapper.map(entity, dtoClass))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<D> findById(ID id) {
        Optional<T> entityOpt = repository.findById(id);
        return entityOpt.map(entity -> modelMapper.map(entity, dtoClass));
    }

    @Override
    public D create(D dto){
        T entity = modelMapper.map(dto, entityClass);
        T createdEntity = repository.save(entity);
        return modelMapper.map(createdEntity, dtoClass);
    }

    @Override
    public D save(D dto) {
        // Mapea DTO a entidad
        T entity = modelMapper.map(dto, entityClass);
        T savedEntity = repository.save(entity);
        // Mapea entidad guardada a DTO y devuelve
        return modelMapper.map(savedEntity, dtoClass);
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    @Override
    public List<D> mapToList(List<T> sourceList) {
        return sourceList.stream()
            .map(entity -> modelMapper.map(entity, dtoClass))
            .collect(Collectors.toList());
    }
    
}


