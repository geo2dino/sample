package com.project.sample.comm.dao;

import com.project.sample.comm.dto.TbCommCdDTO;
import com.project.sample.fw.common.AbstractDAO;

//@Repository("common.comm")
public class CommDAO extends AbstractDAO  {

    public TbCommCdDTO selectCommCd(TbCommCdDTO p){
	return sqlSession.selectOne("selectCommCd", p);
    }

    public int deleteCommCd(TbCommCdDTO p){
   	return sqlSession.delete("deleteCommCd", p);
    }

    public int updateCommCd(TbCommCdDTO p){
   	return sqlSession.update("updateCommCd", p);
    }

    public int insertCommCd(TbCommCdDTO p){
   	return sqlSession.insert("insertCommCd", p);
    }

}
