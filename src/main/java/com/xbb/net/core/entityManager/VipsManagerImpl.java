package com.xbb.net.core.entityManager;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.xbb.net.core.entity.Vips;

@Repository("vipsManager")
public class VipsManagerImpl implements VipsManager {

	@Resource
	private HibernateUtil hibernateUtil;
	
	@Override
	public void add() {
		// TODO Auto-generated method stub
		Vips vips=new Vips();
		vips.setName("xiaobingbing");
//		new HibernateUtilImpl().add(vips);
		hibernateUtil.add(vips);
		
		Vips vips2 = new Vips();
		vips2.setName("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"
				+ "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"
				+ "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"
				+ "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"
				+ "我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我"
				+ "我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我"
				+ "我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我"
				+ "我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我");
		hibernateUtil.add(vips2);
		
	}

	@Override
	public Vips get() {
		// TODO Auto-generated method stub
//		Vips vips=(Vips) new HibernateUtilImpl().get(Vips.class, 1);
		Vips vips=(Vips) hibernateUtil.get(Vips.class, 1);
		return vips;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		Vips vips=(Vips) hibernateUtil.get(Vips.class, 2);
		vips.setName("xiaolixiaoli");
//		new HibernateUtilImpl().update(vips);
		hibernateUtil.update(vips);
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		Vips vips=(Vips) hibernateUtil.get(Vips.class, 1);
//		new HibernateUtilImpl().delete(vips);
		hibernateUtil.delete(vips);
	}

	@Override
	public List<Vips> getList() {
		// TODO Auto-generated method stub
		String[] str={"timo"};
		List<Vips> list=hibernateUtil.query("from Vips where name=?", str);
		return list;
	}

	@Override
	public Vips getListOne() {
		// TODO Auto-generated method stub
		
		String[] str={"timo"};
		Vips vips=(Vips) hibernateUtil.queryOne("from Vips where name=?", str);
		return vips;
	}

	@Override
	public List<Vips> getListByPage() {
		// TODO Auto-generated method stub
		String[] str={"%"+"timo"+"%"};
		List<Vips> list =hibernateUtil.queryByPage("from Vips where name like ?", str,2,3);
		return list;
	}

	
}
