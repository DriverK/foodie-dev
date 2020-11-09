package com.imooc.service.impl;

import com.imooc.service.StuService;
import com.imooc.service.TestPropagationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestProgationServiceImpl implements TestPropagationService {

    @Autowired
    private StuService stuService;

    /**
     * Propagation.REQUIRES_NEW和Propagation.NESTED区别 子事务正常执行完后，主事务在执行程序异常，是否会对子事务数据回滚
     * 对Propagation.REQUIRES_NEW程序执行的数据不会影响，而Propagation.NESTED程序执行的数据会回滚
     * @see Propagation.REQUIRED 当前存在事务，则沿用当前事务；如果当前不存在事务则创建一个事务
     * @see Propagation.REQUIRES_NEW  创建一个新事务,如果当前存在事务就将当前事务挂起。
     *                                新事务程序执行后，主事务程序异常不会影响新事务。
     *                                新事务程序执行后异常，主事务程序可以
     * @see Propagation.NESTED 如果当前存在事务，就创建一个当前事务的子事务。如果当前不存在事务，则创建一个事务，效果跟Propagation.REQUIRED效果差不多。
     *                         当前事务的异常会导致嵌套子事务回滚，而嵌套子事务异常，主事务可以选择回滚或者不回滚
     * Propagation.MANDATORY
     * Propagation.NEVER
     * Propagation.NOT_SUPPORTED
     * Propagation.SUPPORTS
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void testPropagation() {
        stuService.saveParent();
        try {
            stuService.saveChild();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
