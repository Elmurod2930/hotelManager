package org.example.service;

import org.example.entity.EmployeeEntity;
import org.example.entity.TypeEntity;
import org.example.repository.EmployeeRepository;
import org.example.repository.TypeRepository;
import org.hibernate.query.criteria.internal.expression.EntityTypeExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {
    @Autowired
    private TypeRepository typeRepository;

    public void add(String name) {
        TypeEntity entity = typeRepository.getByName(name);
        if (entity == null) {
            System.out.println("not fount employee type");
            return;
        }
        typeRepository.add(entity);
    }

    public void getList() {
        List<TypeEntity> list = typeRepository.getList();
        list.forEach(System.out::println);
    }

    public void delete(Integer id) {
        TypeEntity entity = typeRepository.getById(id);
        if (entity == null) {
            System.out.println("not fount employee type");
            return;
        }
        entity.setVisible(false);
        typeRepository.delete(entity);
    }
}
