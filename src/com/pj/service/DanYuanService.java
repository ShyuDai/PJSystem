package com.pj.service;

import java.util.List;

import com.pj.entity.Danyuan;

public interface DanYuanService {
	public List<Danyuan> getCityList();
	public List<Danyuan> getDanYuanListByParentCode(String code);
}
