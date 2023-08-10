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

	public void select(Connection con, Object a[][]) {// 查询功能实现
		int i = 0;
		String sql = "select * from 选课";// sql查询语句
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
				studentNumber = resultSet.getString("学号");
				classNumber = resultSet.getString("课程号");
				record = resultSet.getInt("成绩");
				a[i][0] = studentNumber;
				a[i][1] = classNumber;
				a[i][2] = record;
				i++;

			}

		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

	public ResultSet getSelectClass(SelectClass se, Connection con) throws SQLException {
		StringBuffer sql = new StringBuffer("select * from 选课 ");// sql查询语句 if
		if (!se.getStudentNumber().equals("")) {
			sql.append(" where 学号 like '%" + se.getStudentNumber() + "%'");
			if(!se.getClassNumber().equals("")) {
				sql.append("and 课程号='"+se.getClassNumber()+"'");
			}
			if(se.getRecord()!=-1) {
				sql.append("and 成绩="+se.getRecord()+"");
			}
		}
		if(se.getStudentNumber().equals("")) {
			if(!se.getClassNumber().equals("")) {
				sql.append(" where 课程号 like '%"+se.getClassNumber()+"%'");
				if(se.getRecord()!=-1) {
					sql.append("and 成绩="+se.getRecord()+"");
				}
			}
			if(se.getClassNumber().equals("")) {
				if(se.getRecord()!=-1) {
					sql.append("where 成绩 ="+se.getRecord()+"");
				}
			}
		}
		ps = con.prepareStatement(sql.toString());
		return ps.executeQuery();
	}

	public int delete(SelectClass se, Connection con) throws SQLException {
		String sql = "delete from 选课 where 学号='" + se.getStudentNumber() + "'" + "and 课程号='" + se.getClassNumber()
				+ "'"; // sql删除语句
		ps = con.prepareStatement(sql);
		return ps.executeUpdate();
	}

	public int add(SelectClass se, Connection con) throws SQLException {
		String sql = "insert into 选课  values(?,?,?)";// sql添加语句
		ps = con.prepareStatement(sql);
		ps.setString(1, se.getStudentNumber());
		ps.setString(2, se.getClassNumber());
		ps.setInt(3, se.getRecord());
		return ps.executeUpdate();
	}

	public int modify(SelectClass se, Connection con) throws SQLException {
		String sql = "update 选课 set 成绩=? where 学号 = '" + se.getStudentNumber() + "' and 课程号='" + se.getClassNumber()
				+ "'";// sql更新语句
		ps = con.prepareStatement(sql);
		ps.setInt(1, se.getRecord());

		return ps.executeUpdate();
	}
}
