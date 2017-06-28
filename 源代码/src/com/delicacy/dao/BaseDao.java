package com.delicacy.dao;

import java.sql.*;

import javax.naming.*;
import javax.sql.DataSource;

public class BaseDao {
	//�������ӳصķ�ʽ��ȡ���ݿ�����
	DataSource dataSource;				//����Դ
    PreparedStatement pstmt=null;		//������
    Connection conn=null;				//���Ӷ���
    ResultSet resultSet=null;			//���ز�ѯ���
    int resultRow=0;					//���ظ�������
    public BaseDao(){
        try {
            Context context=new InitialContext();
            dataSource =(DataSource)context.lookup("java:comp/env/jdbc/delicacy");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    public void getConnection(String sql) throws SQLException {
    	conn=dataSource.getConnection();		//��ȡһ�����ݿ�����
    	pstmt=conn.prepareStatement(sql);		//����sql�������һ��������
    }
}
