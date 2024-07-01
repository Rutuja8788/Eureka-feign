package com.onlineclass.onlineclass.service;



import com.onlineclass.onlineclass.entity.Classdemo;
import com.onlineclass.onlineclass.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;

    public Classdemo saveClass(Classdemo classEntity)
    {
        return classRepository.save(classEntity);
    }

    public Classdemo getClassById(Long id) {
        return classRepository.findById(id).orElse(null);
    }
}
