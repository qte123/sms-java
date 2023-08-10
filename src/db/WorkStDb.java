package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import attribute.StudentClass;

public class WorkStDb {
	PreparedStatement ps = null;
	ResultSet resultSet = null;
	private String classNumber;
	private String className;
	private int credit;

	public void select(Connection con, Object a[][]) {// ��ѯ����ʵ��
		int i = 0;
		String sql = "select * from �γ�";// sql��ѯ���
		try {
			ps = con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		try {
			resultSet = ps.executeQuery(sql);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		try {
			// ѭ������������Ե�ֵ
			while (resultSet.next()) {
				classNumber = resultSet.getString("�γ̺�");
				className = resultSet.getString("�γ���");
				credit = resultSet.getInt("ѧ��");
				a[i][0] = classNumber;
				a[i][1] = className;
				a[i][2] = credit;
				i++;

			}

		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

	}

	public ResultSet getStudentClass(StudentClass st, Connection con) throws SQLException {
		StringBuffer sql = new StringBuffer("select * from �γ� ");// sql��ѯ���
		if (!st.getClassName().equals("")) {
			sql.append(" where �γ��� like '%" + st.getClassName() + "%'");
			if (st.getCredit() != -1) {
				sql.append(" and ѧ��=" + st.getCredit() + "");
			}
		}
		if (st.getClassName().equals("")) {
			if (st.getCredit() != -1) {
				sql.append("where ѧ��=" + st.getCredit() + "");
			}
		}
		ps = con.prepareStatement(sql.toString());
		return ps.executeQuery();
	}

	public int delete(StudentClass st, Connection con) throws SQLException {
		String sql = "delete from �γ�  where �γ���='" + st.getClassName() + "'"; // sqlɾ�����
		ps = con.prepareStatement(sql);
		return ps.executeUpdate();
	}

	public int add(StudentClass st, Connection con) throws SQLException {
		String sql = "insert into �γ�  values(?,?,?)";// sql������
		ps = con.prepareStatement(sql);
		ps.setString(1, st.getClassNumber());
		ps.setString(2, st.getClassName());
		ps.setInt(3, st.getCredit());
		return ps.executeUpdate();
	}

	public int modify(StudentClass st, Connection con) throws SQLException {
		String sql = "update �γ�  set ѧ��=? where �γ̺� = '" + st.getClassNumber() + "' and �γ���='" + st.getClassName()
				+ "'";// sql�������
		ps = con.prepareStatement(sql);
		ps.setInt(1, st.getCredit());
		return ps.executeUpdate();
	}
}
