package com.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.util.DBUtil;

public class LendDao {
	Connection conn=null;
	public List selectLend(String readerId,int pageNow,int pageSize){
		try{
			List list=new ArrayList();
			conn=DBUtil.getConnection();
			PreparedStatement st=conn.prepareStatement("select top "+pageSize+" l.bookId,l.ISBN,b.bookName,
   b.publisherb.price,l.ltime from lend as l,book as b where readerId=? and b.ISBN=l.ISBN
   and l.bookId not in(select top "+pageSize*(pageNow-1)+" l.bookId from lend as l)");
		}
	}
}
