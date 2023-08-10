package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import attribute.SelectClass;

public class WorkSeDb {
	PreparedStatement ps = null;
	ResultSet resultSet = null;
	private String studentNumber;
	private String classNumber;
	private int record;

	public void select(Connection con, Object a[][]) {// ��ѯ����ʵ��
		int i = 0;
		String sql = "select * from ѡ��";// sql��ѯ���
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
				studentNumber = resultSet.getString("ѧ��");
				classNumber = resultSet.getString("�γ̺�");
				record = resultSet.getInt("�ɼ�");
				a[i][0] = studentNumber;
				a[i][1] = classNumber;
				a[i][2] = record;
				i++;

			}

		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

	}

	public ResultSet getSelectClass(SelectClass se, Connection con) throws SQLException {
		StringBuffer sql = new StringBuffer("select * from ѡ�� ");// sql��ѯ��� if
		if (!se.getStudentNumber().equals("")) {
			sql.append(" where ѧ�� like '%" + se.getStudentNumber() + "%'");
			if(!se.getClassNumber().equals("")) {
				sql.append("and �γ̺�='"+se.getClassNumber()+"'");
			}
			if(se.getRecord()!=-1) {
				sql.append("and �ɼ�="+se.getRecord()+"");
			}
		}
		if(se.getStudentNumber().equals("")) {
			if(!se.getClassNumber().equals("")) {
				sql.append(" where �γ̺� like '%"+se.getClassNumber()+"%'");
				if(se.getRecord()!=-1) {
					sql.append("and �ɼ�="+se.getRecord()+"");
				}
			}
			if(se.getClassNumber().equals("")) {
				if(se.getRecord()!=-1) {
					sql.append("where �ɼ� ="+se.getRecord()+"");
				}
			}
		}
		ps = con.prepareStatement(sql.toString());
		return ps.executeQuery();
	}

	public int delete(SelectClass se, Connection con) throws SQLException {
		String sql = "delete from ѡ�� where ѧ��='" + se.getStudentNumber() + "'" + "and �γ̺�='" + se.getClassNumber()
				+ "'"; // sqlɾ�����
		ps = con.prepareStatement(sql);
		return ps.executeUpdate();
	}

	public int add(SelectClass se, Connection con) throws SQLException {
		String sql = "insert into ѡ��  values(?,?,?)";// sql������
		ps = con.prepareStatement(sql);
		ps.setString(1, se.getStudentNumber());
		ps.setString(2, se.getClassNumber());
		ps.setInt(3, se.getRecord());
		return ps.executeUpdate();
	}

	public int modify(SelectClass se, Connection con) throws SQLException {
		String sql = "update ѡ�� set �ɼ�=? where ѧ�� = '" + se.getStudentNumber() + "' and �γ̺�='" + se.getClassNumber()
				+ "'";// sql�������
		ps = con.prepareStatement(sql);
		ps.setInt(1, se.getRecord());

		return ps.executeUpdate();
	}
}
