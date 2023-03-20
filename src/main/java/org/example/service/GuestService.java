package org.example.service;

import org.example.entity.GuestEntity;
import org.example.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {
    @Autowired
    private GuestRepository guestRepository;

    public void add(GuestEntity entity) {
        guestRepository.add(entity);
    }

    public void getList() {
        List<GuestEntity> list=guestRepository.getList();
        list.forEach(System.out::println);
    }
}
