package com.example.demo.service;

import com.example.demo.model.entity.PersonaEntity;
import com.example.demo.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<PersonaEntity> listAll() {
        return personaRepository.findAll();
    }

    @Override
    public PersonaEntity getById(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    public PersonaEntity saveOrUpdate(PersonaEntity directorEntity) {
        return personaRepository.save(directorEntity);
    }

    @Override
    public void delete(Long id) {
        personaRepository.deleteById(id);
    }

}
