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
 
    //通过传递的sql语句来获得数据模型
    public Ftable(String sql)
    {
    	//建立表头  
    	ColumnNames= new Vector();
		ColumnNames.add("订单编号");
		ColumnNames.add("用户id");
		ColumnNames.add("用户名");
		ColumnNames.add("商品id");
		ColumnNames.add("商品名");
		ColumnNames.add("购买数量");
		ColumnNames.add("总价");
		RowData=new Vector(); 
		//sql = "SELECT * FROM tb_delivery";
	    db = new MySQLConnect(sql);	 // 新建一个数据库连接						
	    try {
			ret = db.pstmt.executeQuery();			// 执行sql语句，得到结果集		
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
	        ret.close();		// 关闭执行的语句连接
	        db.close();			// 关闭数据库连接
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    //建立构造函数初始化数据模型
    public Ftable()
    {
		ColumnNames= new Vector();
		ColumnNames.add("订单编号");
		ColumnNames.add("用户id");
		ColumnNames.add("用户名");
		ColumnNames.add("商品id");
		ColumnNames.add("商品名");
		ColumnNames.add("购买数量");
		ColumnNames.add("总价");
		
		
		
		
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
    

	
  //得到共有多少列
  	public int getColumnCount() {
  		
  		// TODO 自动生成的方法存根
  		return this.ColumnNames.size();
  	}

  	//得到共有多少行
  	public int getRowCount() {
  		// TODO 自动生成的方法存根
  		return this.RowData.size();
  	}

  	@Override
  	public String getColumnName(int arg0) {
  		// TODO 自动生成的方法存根
  		return (String)this.ColumnNames.get(arg0);
  	}


  	//得到某行某列的数据
  	public Object getValueAt(int row, int column) {
  		// TODO 自动生成的方法存根
  		return ((Vector)this.RowData.get(row)).get(column);
  	}

  }