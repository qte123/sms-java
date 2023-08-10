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

	public void select(Connection con, Object a[][]) {// 查询功能实现
		int i = 0;
		String sql = "select * from 课程";// sql查询语句
		try {
			ps = con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		try {
			resultSet = ps.executeQuery(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		try {
			// 循环输出两个属性的值
			while (resultSet.next()) {
				classNumber = resultSet.getString("课程号");
				className = resultSet.getString("课程名");
				credit = resultSet.getInt("学分");
				a[i][0] = classNumber;
				a[i][1] = className;
				a[i][2] = credit;
				i++;

			}

		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

	public ResultSet getStudentClass(StudentClass st, Connection con) throws SQLException {
		StringBuffer sql = new StringBuffer("select * from 课程 ");// sql查询语句
		if (!st.getClassName().equals("")) {
			sql.append(" where 课程名 like '%" + st.getClassName() + "%'");
			if (st.getCredit() != -1) {
				sql.append(" and 学分=" + st.getCredit() + "");
			}
		}
		if (st.getClassName().equals("")) {
			if (st.getCredit() != -1) {
				sql.append("where 学分=" + st.getCredit() + "");
			}
		}
		ps = con.prepareStatement(sql.toString());
		return ps.executeQuery();
	}

	public int delete(StudentClass st, Connection con) throws SQLException {
		String sql = "delete from 课程  where 课程名='" + st.getClassName() + "'"; // sql删除语句
		ps = con.prepareStatement(sql);
		return ps.executeUpdate();
	}

	public int add(StudentClass st, Connection con) throws SQLException {
		String sql = "insert into 课程  values(?,?,?)";// sql添加语句
		ps = con.prepareStatement(sql);
		ps.setString(1, st.getClassNumber());
		ps.setString(2, st.getClassName());
		ps.setInt(3, st.getCredit());
		return ps.executeUpdate();
	}

	public int modify(StudentClass st, Connection con) throws SQLException {
		String sql = "update 课程  set 学分=? where 课程号 = '" + st.getClassNumber() + "' and 课程名='" + st.getClassName()
				+ "'";// sql更新语句
		ps = con.prepareStatement(sql);
		ps.setInt(1, st.getCredit());
		return ps.executeUpdate();
	}
}
