import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.util.HibernateSessionFactory;
import com.vo.Usertable;


public class Test {
	
	public Session session;
	//���session����
	public void getCurrentSession(){
		//����HibernateSessionFactory �� getSession ��������session����
		session=HibernateSessionFactory.getSession();
	}
	
	//�ر�session����
	public void closeSession(){
		if(session!=null){
			HibernateSessionFactory.closeSession();
		}
	}
	
	//����һ�����ݣ�ע�ᣩ
		public void saveUser(){
			Transaction t1=session.beginTransaction();  //�����������
			Usertable user=new Usertable();
			user.setAccount("123456");
			user.setPassword("837243");
			session.save(user);
			t1.commit();                             //�ύ�����ֹ�����¼�
		}
		
	//ɾ��һ������
		public void delUser(){
			Transaction t2=session.beginTransaction();
			Usertable user=(Usertable)session.get(Usertable.class, 1);
			session.delete(user);
			t2.commit();
		}
		
	//�޸�����
		public void updateUser(){
			Transaction t3=session.beginTransaction();
			Usertable user =(Usertable)session.get(Usertable.class, 1);
			user.setAccount("435323");
			user.setPassword("lisi");
			t3.commit();
		}
		
	//��ѯ����
		public void queryUser(){
			//��ѯ�����ݿ�ûӰ�죬���ش�������
			Query query =session.createQuery("from Usertable");  //HQL����,Userinfo�Ƕ����������Ǳ���
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
		System.out.println("�޸ĺ������");
		test.updateUser();
		test.queryUser();
		test.closeSession();
	}

}
