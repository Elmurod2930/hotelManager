package org.example.service;

import org.example.entity.PassportEntity;
import org.example.repository.PassportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassportService {
    @Autowired
    private PassportRepository passportRepository;

    public void add(PassportEntity passport) {
        PassportEntity entity = passportRepository.getByNumber(passport.getNumber());
        if (entity == null) {
            passportRepository.add(passport);
        }
    }
}
