package com.example.demo.service;

import com.example.demo.model.entity.ProvinciaEntity;
import com.example.demo.repository.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProvinciaServiceImpl implements ProvinciaService {

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Override
    public List<ProvinciaEntity> listAll() {
        return provinciaRepository.findAll();
    }

    @Override
    public ProvinciaEntity getById(Long id) {
        return provinciaRepository.findById(id).orElse(null);
    }

    @Override
    public ProvinciaEntity saveOrUpdate(ProvinciaEntity domainObject) {
        return provinciaRepository.save(domainObject);
    }

    @Override
    public void delete(Long id) {
        provinciaRepository.deleteById(id);
    }

}
