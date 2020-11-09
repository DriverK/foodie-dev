package com.imooc.service.impl;

import com.imooc.mapper.StuMapper;
import com.imooc.pojo.Stu;
import com.imooc.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StuServiceImpl implements StuService {

    @Autowired
    private StuMapper stuMapper;

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public Stu getStudInfo(int id) {
        return stuMapper.selectByPrimaryKey(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveStud() {
        Stu stu = new Stu();
        stu.setName("David");
        stu.setAge(26);
        stuMapper.insert(stu);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteStud(int id) {
        stuMapper.deleteByPrimaryKey(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateStud(int id) {
        Stu stu = new Stu();
        stu.setId(id);
        stu.setName("Jack");
        stu.setAge(16);
        stuMapper.updateByPrimaryKey(stu);
    }

    @Override
    public void saveParent() {
        Stu parent = new Stu();
        parent.setName("parent");
        parent.setAge(60);
        stuMapper.insert(parent);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void saveChild() {
        saveChild1();
        int i = 1 / 0;
        saveChild2();
    }

    public void saveChild1() {
        Stu child1 = new Stu();
        child1.setName("child1");
        child1.setAge(16);
        stuMapper.insert(child1);
    }

    public void saveChild2() {
        Stu child2 = new Stu();
        child2.setName("child2");
        child2.setAge(16);
        stuMapper.insert(child2);
    }
}
