package P11_JDBC;

/**
 * @author : ZWH 2021/5/10
 * @version : 1.0
 * 对数据库进行增删改查，预处理，文件|字符串
 */

import java.io.*;
import java.sql.*;
import java.util.*;

public class conMysql {
	Statement stmt;
	Connection conn;
	private PreparedStatement pps;
	private ResultSet rs;
	
	public conMysql(){//构造方法，创建对象自动执行
		try {
			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");//加载驱动
			conn = DriverManager.getConnection("proxool.datasource1");
			stmt = conn.createStatement();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

//	增删改
	public int update(String sql,Object[] param){
		try{
			if(param==null){
					stmt.executeUpdate(sql);
			}else{
				pps = conn.prepareStatement(sql);

				for(int i = 0;i<param.length;i++){
					if(param[i].getClass()==File.class){//若为文件，传入一个流
						File file = (File)param[i];
						pps.setBinaryStream(i+1, new FileInputStream(file),(int) file.length());
					}else{
						if(param[i].getClass()==String.class){// 若为字符串，则存入字符串
							String str = param[i].toString();
							pps.setString(i+1,str);
						}else{//其他类型
							pps.setObject(i+1, param[i]);
						}
					}
				}
				return pps.executeUpdate();
			}
		}catch(SQLException e){
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return -1;
	}

//	查
	public ArrayList<HashMap<String,Object>> query(String sql,String[] param){
		try {
			if(param==null){
				rs = stmt.executeQuery(sql);
			}else{
				pps = conn.prepareStatement(sql);

				for(int i = 0;i<param.length;i++){
					pps.setString(i+1,param[i]);
				}
				rs = pps.executeQuery();
			}
			ResultSetMetaData mt = rs.getMetaData();// 获取结果集结构对象，结果集里有那些字段，类型，长度
			
			int count = mt.getColumnCount();//同mt.getColumnCount()
			String[] columns = new String[count];// 根据列的数目创建数组
			
			for(int i = 0;i<columns.length;i++){// 把字段名存入数组
				columns[i] = mt.getColumnName(i+1);
			}
			
			//把结果集里的数据保存到链表里
			ArrayList<HashMap<String,Object>> list  = new ArrayList<HashMap<String,Object>>();
			
			byte[] b = new byte[1024*10];
			while(rs.next()){
				HashMap<String,Object> map = new HashMap<String,Object>();
				for(int i = 0;i<columns.length;i++){
					int type = mt.getColumnType(i+1);
					if (Types.LONGVARBINARY == type) {
						Blob stream = rs.getBlob(columns[i]);
						map.put(columns[i], stream);
						try {
							int a = stream.getBinaryStream().read(b);
							System.out.println("type1="+type +" "+" "+columns[i]+" a"+a);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}else{
						map.put(columns[i], rs.getString(columns[i]));
					}
				}
				list.add(map);
			}
			rs.close();
			return list;
		}catch(SQLException e ){
			e.printStackTrace();
		}
		return null;
	}

//	关闭pps结果集
	public void close(){
		try{
			pps.close();
			stmt.close();
		}catch(SQLException e ){
			e.printStackTrace();
		}
		
		try{
			conn.close();
		}catch(SQLException e ){
			e.printStackTrace();
		}
		
	}	
}
