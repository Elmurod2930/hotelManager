package org.example.service;

import org.example.entity.EmployeeEntity;
import org.example.entity.TypeEntity;
import org.example.entity.enums.EmployeeStatus;
import org.example.repository.EmployeeRepository;
import org.example.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private TypeRepository typeRepository;

    public void add(EmployeeEntity entity, Integer typeId) {
        TypeEntity type = typeRepository.getById(typeId);
        if (type == null) {
            System.out.println("not fount employee type");
            return;
        }
        entity.setType(type);
        employeeRepository.add(entity);
    }

    public void getList() {
        List<EmployeeEntity> list = employeeRepository.getList();
        list.forEach(System.out::println);
    }

    public void delete(Integer id) {
        EmployeeEntity entity = employeeRepository.getById(id);
        if (entity == null) {
            System.out.println("not fount employee");
            return;
        }
        entity.setStatus(EmployeeStatus.NO_ACTIVE);
        employeeRepository.delete(entity);
    }

    public boolean login(String phone) {
        EmployeeEntity entity = employeeRepository.getByPhone(phone);
        if (entity == null) {
            System.out.println("Error");
            return false;
        }
        TypeEntity type = typeRepository.getById(entity.getId());
        return type.getName().equals("admin");
    }
}
