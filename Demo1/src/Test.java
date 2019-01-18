import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.util.HibernateSessionFactory;
import com.vo.Usertable;


public class Test {
	
	public Session session;
	//获得session方法
	public void getCurrentSession(){
		//调用HibernateSessionFactory 的 getSession 方法创建session对象
		session=HibernateSessionFactory.getSession();
	}
	
	//关闭session方法
	public void closeSession(){
		if(session!=null){
			HibernateSessionFactory.closeSession();
		}
	}
	
	//插入一条数据（注册）
		public void saveUser(){
			Transaction t1=session.beginTransaction();  //创建事物对象
			Usertable user=new Usertable();
			user.setAccount("123456");
			user.setPassword("837243");
			session.save(user);
			t1.commit();                             //提交事物，防止并发事件
		}
		
	//删除一条数据
		public void delUser(){
			Transaction t2=session.beginTransaction();
			Usertable user=(Usertable)session.get(Usertable.class, 1);
			session.delete(user);
			t2.commit();
		}
		
	//修改数据
		public void updateUser(){
			Transaction t3=session.beginTransaction();
			Usertable user =(Usertable)session.get(Usertable.class, 1);
			user.setAccount("435323");
			user.setPassword("lisi");
			t3.commit();
		}
		
	//查询数据
		public void queryUser(){
			//查询对数据库没影响，不必创建事务
			Query query =session.createQuery("from Usertable");  //HQL语言,Userinfo是对象名，不是表名
			List<Usertable> list =query.list();
			for(Usertable u:list){
				System.out.println(u.getAccount()+"  "+u.getPassword());
			}
		}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test test=new Test();
		test.getCurrentSession();
//		test.saveUser();
//		test.queryUser();
		System.out.println("修改后的数据");
		test.updateUser();
		test.queryUser();
		test.closeSession();
	}

}
