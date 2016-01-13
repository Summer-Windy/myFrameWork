package com.xbb.net.core.entityManager;

import java.util.List;

import com.xbb.net.core.entity.Vips;


public interface VipsManager {
	void add();
	Vips get();
	void update();
	void delete();
	List<Vips> getList();
	Vips getListOne();
	List<Vips> getListByPage();
}
