package com.example.demo.service;

import com.example.demo.model.entity.DistritoEntity;
import com.example.demo.repository.DistritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DistritoServiceImpl implements DistritoService {

    @Autowired
    DistritoRepository distritoRepository;

    @Override
    public List<DistritoEntity> listAll() {
        return distritoRepository.findAll();
    }

    @Override
    public DistritoEntity getById(Long id) {
        return distritoRepository.findById(id).orElse(null);
    }

    @Override
    public DistritoEntity saveOrUpdate(DistritoEntity domainObject) {
        return distritoRepository.save(domainObject);
    }

    @Override
    public void delete(Long id) {
        distritoRepository.deleteById(id);
    }
}
