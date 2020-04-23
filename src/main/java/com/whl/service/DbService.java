package com.whl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whl.mapper.DbMapper;
import com.whl.pojo.Db;
@Service
public class DbService {
@Autowired
private DbMapper dbMapper;
	public List<Db> list() {
		return dbMapper.list();
	}
	public Boolean save(Db db) {
		
		return dbMapper.insertSelective(db);	
	}
	public Db findById(Integer id) {
		return dbMapper.findById(id);
	}


}
