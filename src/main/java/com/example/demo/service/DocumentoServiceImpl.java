package com.example.demo.service;

import com.example.demo.model.entity.DocumentoEntity;
import com.example.demo.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DocumentoServiceImpl implements DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;


    @Override
    public List<DocumentoEntity> listAll() {
        return documentoRepository.findAll();
    }

    @Override
    public DocumentoEntity getById(Long id) {
        return documentoRepository.findById(id).orElse(null);
    }

    @Override
    public DocumentoEntity saveOrUpdate(DocumentoEntity domainObject) {
        return documentoRepository.save(domainObject);
    }

    @Override
    public void delete(Long id) {
        documentoRepository.deleteById(id);
    }

}
