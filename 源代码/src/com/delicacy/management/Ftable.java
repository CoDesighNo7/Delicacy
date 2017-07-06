package com.delicacy.management;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.*;
import com.delicacy.dao.MySQLConnect; 



public class Ftable extends AbstractTableModel {
	Vector RowData,ColumnNames;
    static String sql = null;  
    static MySQLConnect db = null;  
    static ResultSet ret = null; 
 
    //ͨ�����ݵ�sql������������ģ��
    public Ftable(String sql)
    {
    	//������ͷ  
    	ColumnNames= new Vector();
		ColumnNames.add("�������");
		ColumnNames.add("�û�id");
		ColumnNames.add("�û���");
		ColumnNames.add("��Ʒid");
		ColumnNames.add("��Ʒ��");
		ColumnNames.add("��������");
		ColumnNames.add("�ܼ�");
		RowData=new Vector(); 
		//sql = "SELECT * FROM tb_delivery";
	    db = new MySQLConnect(sql);	 // �½�һ�����ݿ�����						
	    try {
			ret = db.pstmt.executeQuery();			// ִ��sql��䣬�õ������		
			while (ret.next()) {
	            Vector hang=new Vector();
	        	hang.add(ret.getString(1));
	        	hang.add(ret.getString(2));
	        	hang.add(ret.getString(3));
	        	hang.add(ret.getInt(4));
	        	hang.add(ret.getString(5));
	        	hang.add(ret.getFloat(6));
	        	hang.add(ret.getFloat(7));
	        	
	        	RowData.add(hang);
	        }
	        ret.close();		// �ر�ִ�е��������
	        db.close();			// �ر����ݿ�����
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    //�������캯����ʼ������ģ��
    public Ftable()
    {
		ColumnNames= new Vector();
		ColumnNames.add("�������");
		ColumnNames.add("�û�id");
		ColumnNames.add("�û���");
		ColumnNames.add("��Ʒid");
		ColumnNames.add("��Ʒ��");
		ColumnNames.add("��������");
		ColumnNames.add("�ܼ�");
		
		
		
		
		RowData=new Vector(); 
		sql = "select u_orderID,userOrder.userID,userinfo.userName,orderCommodity.commodityID,commodityinfo.commodityName,commodityCount,commodityAmont from userOrder join orderCommodity on userOrder.u_orderID=orderCommodity.orderID,userinfo,commodityinfo where orderCommodity.commodityID=commodityinfo.commodityID and userOrder.userID=userinfo.userID and u_orderState=1";						
	    db = new MySQLConnect(sql);							
	    try {
			ret = db.pstmt.executeQuery();					
			while (ret.next()) {
	            Vector hang=new Vector();
	            hang.add(ret.getString(1));
	        	hang.add(ret.getString(2));
	        	hang.add(ret.getString(3));
	        	hang.add(ret.getInt(4));
	        	hang.add(ret.getString(5));
	        	hang.add(ret.getFloat(6));
	        	hang.add(ret.getFloat(7));
	        	RowData.add(hang);
	        }
	        ret.close();		
	        db.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    

	
  //�õ����ж�����
  	public int getColumnCount() {
  		
  		// TODO �Զ����ɵķ������
  		return this.ColumnNames.size();
  	}

  	//�õ����ж�����
  	public int getRowCount() {
  		// TODO �Զ����ɵķ������
  		return this.RowData.size();
  	}

  	@Override
  	public String getColumnName(int arg0) {
  		// TODO �Զ����ɵķ������
  		return (String)this.ColumnNames.get(arg0);
  	}


  	//�õ�ĳ��ĳ�е�����
  	public Object getValueAt(int row, int column) {
  		// TODO �Զ����ɵķ������
  		return ((Vector)this.RowData.get(row)).get(column);
  	}

  }