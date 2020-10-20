package com.example.demo.service;

import com.example.demo.model.entity.DepartamentoEntity;
import com.example.demo.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartamentoServiceImpl implements DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;


    @Override
    public List<DepartamentoEntity> listAll() {
        return departamentoRepository.findAll();
    }

    @Override
    public DepartamentoEntity getById(Long id) {
        return departamentoRepository.findById(id).orElse(null);
    }

    @Override
    public DepartamentoEntity saveOrUpdate(DepartamentoEntity domainObject) {
        return departamentoRepository.save(domainObject);
    }

    @Override
    public void delete(Long id) {
        departamentoRepository.deleteById(id);
    }
}
