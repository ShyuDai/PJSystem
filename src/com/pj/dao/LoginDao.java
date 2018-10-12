package com.pj.dao;

import com.pj.entity.Renyuan;

public interface LoginDao {
	public Renyuan getRenYuanByUsernameAndPassword(String username,String password);
}
