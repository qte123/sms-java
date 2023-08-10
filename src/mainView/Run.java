package mainView;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.SQLException;

import db.ListDb;

public class Run {

	static ListDb ldb = new ListDb();// 创建ListDb对象
	static Connection con = null;

	public static void main(String[] args) throws SQLException {
		// TODO 自动生成的方法存根
		try {
			con = ldb.getCon();// 获取数据库对象
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		ldb.list();// 连接数据库
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					new View(con);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
