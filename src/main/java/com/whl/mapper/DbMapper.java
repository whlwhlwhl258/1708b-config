package com.whl.mapper;

import java.util.List;

import com.whl.pojo.Db;

public interface DbMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Db record);

    Boolean insertSelective(Db record);

    Db selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Db record);

    int updateByPrimaryKey(Db record);

	List<Db> list();

	Db findById(Integer id);
}