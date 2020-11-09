package com.imooc.service;

import com.imooc.pojo.Stu;

public interface StuService {

    /**
     * 查询学生信息
     * @param id
     * @return
     */
    Stu getStudInfo(int id);

    void saveStud();

    void deleteStud(int id);

    void updateStud(int id);

    void saveParent();

    void saveChild();
}
