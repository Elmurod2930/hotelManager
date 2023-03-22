package org.example.service;

import org.example.entity.ConvenientEntity;
import org.example.repository.ConvenientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConvenientService {
    @Autowired
    private ConvenientRepository convenientRepository;

    public void add(String name) {
        ConvenientEntity entity = convenientRepository.getByName(name);
        if (entity != null) {
            System.out.println("there is such convenience");
            return;
        }
        ConvenientEntity convenient = new ConvenientEntity();
        convenient.setDescription(name);
        convenientRepository.add(convenient);
    }

    public void getList() {
        List<ConvenientEntity> list = convenientRepository.getList();
        list.forEach(System.out::println);
    }

    public void delete(Integer id) {
        ConvenientEntity entity = convenientRepository.getById(id);
        if (entity == null) {
            System.out.println("not fount Convenient");
            return;
        }
        entity.setVisible(false);
        convenientRepository.delete(entity);
    }
}
