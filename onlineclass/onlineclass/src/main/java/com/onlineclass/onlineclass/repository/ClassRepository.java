package com.onlineclass.onlineclass.repository;


import com.onlineclass.onlineclass.entity.Classdemo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<Classdemo, Long>
{
}
