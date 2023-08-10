package mainView;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.SQLException;

import db.ListDb;

public class Run {

	static ListDb ldb = new ListDb();// ����ListDb����
	static Connection con = null;

	public static void main(String[] args) throws SQLException {
		// TODO �Զ����ɵķ������
		try {
			con = ldb.getCon();// ��ȡ���ݿ����
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		ldb.list();// �������ݿ�
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
