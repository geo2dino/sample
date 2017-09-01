package com.project.sample.fw.common;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;

public class AbstractDAO {

    @Resource
    protected SqlSession sqlSession;

}
