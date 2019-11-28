package com.zqz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zqz.entity.Dept;

@Mapper
public interface DeptDao {

	List<Dept> findAll();
}
