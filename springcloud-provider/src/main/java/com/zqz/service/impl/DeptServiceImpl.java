package com.zqz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zqz.dao.DeptDao;
import com.zqz.entity.Dept;
import com.zqz.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService{
	
	@Autowired
	private DeptDao deptDao;
	
	@Override
	public List<Dept> findAll() {
		return deptDao.findAll();
	}

}
