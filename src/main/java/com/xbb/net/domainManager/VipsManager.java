package com.xbb.net.domainManager;

import java.util.List;

import com.xbb.net.domain.Vips;


public interface VipsManager {
	void add();
	Vips get();
	void update();
	void delete();
	List<Vips> getList();
	Vips getListOne();
	List<Vips> getListByPage();
}
