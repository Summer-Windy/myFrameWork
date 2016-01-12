package com.xbb.net.domainManager;

import java.util.ArrayList;  
import java.util.List;  
  








import javax.annotation.Resource;

import org.hibernate.Query;  
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
  
@Service("hibernateUtil")
public class HibernateUtilImpl implements HibernateUtil  
{  
	
	@Autowired
	private SessionFactory sessionFactorytemp;  

    
  @Override
public  SessionFactory getSessionFactory()  
  {  

      return sessionFactorytemp;  
  }  
    

  @Override
public  Session getSession()  
  {  
     return getSessionFactory().openSession();  
  }  
    

  @Override
public  boolean add(Object obj)  
  {  
    Session session=null;  
    Transaction tran=null;  
    boolean result=false;  
    try  
    {  
        session=getSession();  
        tran=session.beginTransaction();  
        session.save(obj);  
        tran.commit();  
        result=true;  
    }  
    catch (Exception e)  
    {  
    	e.printStackTrace();
       if(tran!=null)  
       {  
           //事物回滚  
           tran.rollback();  
       }  
    }  
    finally  
    {  
        if(session!=null)  
        {  
            //关闭session  
            session.close();  
        }  
    }  
    return result;  
  }  
    
  
@Override
public  boolean update(Object object)  
  {  
        Session session=null;  
        Transaction tran=null;  
        boolean result=false;  
        try  
        {  
            session=getSession();  
            tran=session.beginTransaction();  
            session.update(object);  
            tran.commit();  
            result=true;  
        }  
        catch (Exception e)  
        {  
        	e.printStackTrace();
           if(tran!=null)  
           {  
               //事物回滚  
               tran.rollback();  
           }  
        }  
        finally  
        {  
            if(session!=null)  
            {  
                //关闭session  
                session.close();  
            }  
        }  
        return result;  
      }  
       

  @Override
public  Object get(Class c,int obj)  
  {  
        Session session=null;  
        Object object=null;  
        try  
        {  
            session=getSession();  
            object=session.get(c,obj);  
        }  
        catch (Exception e)  
        {  
        	e.printStackTrace();
        }  
        finally  
        {  
            if(session!=null)  
            {  
                //关闭session  
                session.close();  
            }  
        }  
        return object;  
  }  
  

@Override
public  boolean delete(Object obj)  
  {  
        Session session=null;  
        Transaction tran=null;  
        boolean result=false;  
        try  
        {  
            session=getSession();  
            tran=session.beginTransaction();  
            session.delete(obj);  
            tran.commit();  
            result=true;  
        }  
        catch (Exception e)  
        {  
        	e.printStackTrace();
           if(tran!=null)  
           {  
               //事物回滚  
               tran.rollback();  
           }  
        }  
        finally  
        {  
            if(session!=null)  
            {  
                //关闭session  
                session.close();  
            }  
        }  
        return result;  
  }  
  
  

 @Override
@SuppressWarnings("unchecked")  
public  <T> List<T> query(String sql,String[] param)  
  {  
      List<T> list=new ArrayList<T>();  
      Session session=null;  
       try  
        {  
            session=getSession();  
            Query query=session.createQuery(sql);  
            if(param!=null)  
            {  
                for(int i=0;i<param.length;i++)  
                {  
                    query.setString(i,param[i]);      
                }  
            }  
            System.out.println(list.size());
            list=query.list();
           
        }  
        catch (Exception e)  
        {  
//        	System.out.println(e.getMessage());
        	e.printStackTrace();
        }  
        finally  
        {  
            if(session!=null)  
            {  
                session.close();  
            }  
        }  
      return list;  
  }  

@Override
public  Object queryOne(String sql,String[] param)  
  {  
      Object object=null;  
      Session session=null;  
       try  
        {  
            session=getSession();  
            Query query=session.createQuery(sql);  
            if(param!=null)  
            {  
                for(int i=0;i<param.length;i++)  
                {  
                    query.setString(0,param[i]);      
                }  
                object=query.uniqueResult();  
            }  
        }  
        catch (Exception e)  
        {  
        	e.printStackTrace();
        }  
        finally  
        {  
            if(session!=null)  
            {  
                session.close();  
            }  
        }  
      return object;  
  }  

@Override
@SuppressWarnings("unchecked")  
public  <T> List<T> queryByPage(String sql,String[] param,int page,int size)  
  {  
      List<T> list=new ArrayList<T>();  
      Session session=null;  

       try  
        { 
            session=getSession();  
            Query query=session.createQuery(sql);  
            if(param!=null)  
            {  
                for(int i=0;i<param.length;i++)  
                {  
                    query.setString(i,param[i]);      
                }  
            }  
            //筛选条数  
            query.setFirstResult((page-1)*size);  
            query.setMaxResults(size);  
            list=query.list();  
        }  
        catch (Exception e)  
        {  
        	e.printStackTrace();
        }  
        finally  
        {  
            if(session!=null)  
            {  
                session.close();  
            }  
        }  
      return list;  
  }  

@Override
public  int getCount(String hql, String[] pras) {  
    int resu = 0;  
    Session s = null;  
    try {  
        s = getSession();  
        Query q = s.createQuery(hql);  
        if (pras != null) {  
            for (int i = 0; i < pras.length; i++) {  
                q.setString(i, pras[i]);  
            }  
        }  
        resu = Integer.parseInt(q.uniqueResult().toString());  
    } catch (Exception e) {  
        e.printStackTrace();  
    } finally {  
        if (s != null)  
            s.close();  
    }  
    return resu;  
}


@Override
public double getDouble(String hql, String[] pras) {
	 double resu = 0.0;  
	    Session s = null;  
	    try {  
	        s = getSession();  
	        Query q = s.createQuery(hql);  
	        if (pras != null) {  
	            for (int i = 0; i < pras.length; i++) {  
	                q.setString(i, pras[i]);  
	            }  
	        }  
	        resu = Double.parseDouble(q.uniqueResult().toString());  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    } finally {  
	        if (s != null)  
	            s.close();  
	    }  
	    return resu;
}  
   
} 