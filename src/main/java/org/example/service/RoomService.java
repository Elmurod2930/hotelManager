package org.example.service;

import org.example.entity.RoomEntity;
import org.example.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public void add(RoomEntity entity) {
        roomRepository.add(entity);
    }

    public void list() {
        List<RoomEntity> roomEntityList = roomRepository.list();
        roomEntityList.forEach(System.out::println);
    }

    public void delete(Integer id) {
        RoomEntity entity = roomRepository.getById(id);
        if (entity == null) {
            System.out.println("not fount room");
            return;
        }
        entity.setVisible(false);
        roomRepository.delete(entity);
    }

    public void find(Integer id) {
        RoomEntity entity = roomRepository.getById(id);
        if (entity == null) {
            System.out.println("not fount room");
            return;
        }
        System.out.println(entity);
    }
}
