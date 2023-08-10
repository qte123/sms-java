package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import attribute.Student;

public class WorkSDb {
	PreparedStatement ps = null;
	ResultSet resultSet = null;
	private String studentNumber;
	private String name;
	private String sex;
	private String birthday;
	private String department;

	public void select(Connection con, Object a[][]) {// 查询功能实现
		int i = 0;
		String sql = "select * from 学生";// sql查询语句
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
				name = resultSet.getString("姓名");
				sex = resultSet.getString("性别");
				birthday = resultSet.getString("出生日期");
				department = resultSet.getString("所在院系");
				a[i][0] = studentNumber;
				a[i][1] = name;
				a[i][2] = sex;
				a[i][3] = birthday;
				a[i][4] = department;
				i++;

			}

		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}
	public ResultSet getStudent(Student student, Connection con) throws SQLException {
		StringBuffer sql = new StringBuffer("select * from 学生 ");// sql查询语句
		if (!student.getStudentNumber().equals("")) {
			sql.append(" where 学号 like '%" + student.getStudentNumber() + "%'");
			if (!student.getName().equals("")) {
				sql.append("and 姓名='" + student.getName() + "'");
			}
			if (!student.getDepartment().equals("")) {
				sql.append("and 所在院系='" + student.getDepartment() + "'");
			}
		}
		if (student.getStudentNumber().equals("")) {
			if (!student.getName().equals("")) {
				sql.append("where 姓名 like '%" + student.getName() + "%'");
				if(!student.getDepartment().equals("")) {
					sql.append("and 所在院系='"+student.getDepartment()+"'");
				}
			}
			if(student.getName().equals("")) {
				if(!student.getDepartment().equals("")) {
					sql.append("where 所在院系 like'%"+student.getDepartment()+"%'");
				}
			}

		}
		ps = con.prepareStatement(sql.toString());
		return ps.executeQuery();
	}

	public int delete(Student student, Connection con) throws SQLException {
		String sql = "delete from 学生 where 学号='" + student.getStudentNumber() + "'"; // sql删除语句
		ps = con.prepareStatement(sql);
		return ps.executeUpdate();
	}

	public int add(Student student, Connection con) throws SQLException {
		String sql = "insert into 学生  values(?,?,?,?,?)";// sql添加语句
		ps = con.prepareStatement(sql);
		ps.setString(1, student.getStudentNumber());
		ps.setString(2, student.getName());
		ps.setString(3, student.getSex());
		ps.setString(4, student.getBirthday());
		ps.setString(5, student.getDepartment());
		return ps.executeUpdate();
	}

	public int modify(Student student, Connection con) throws SQLException {
		String sql = "update 学生  set 学号=?, 姓名=?, 性别=?, 出生日期=?, 所在院系=? where 学号 = '" + student.getStudentNumber() + "'";// sql更新语句
		ps = con.prepareStatement(sql);
		ps.setString(1, student.getStudentNumber());
		ps.setString(2, student.getName());
		ps.setString(3, student.getSex());
		ps.setString(4, student.getBirthday());
		ps.setString(5, student.getDepartment());

		return ps.executeUpdate();
	}
}
