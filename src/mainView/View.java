package mainView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import attribute.SelectClass;
import attribute.Student;
import attribute.StudentClass;
import db.ListDb;
import db.WorkSeDb;
import db.WorkStDb;
import db.WorkSDb;
import studentView.AddSMenu;
import studentView.DeleteSMenu;
import studentView.ModifySMenu;
import selectClassView.AddSeMenu;
import selectClassView.DeleteSeMenu;
import selectClassView.ModifySeMenu;
import studentClassView.AddStMenu;
import studentClassView.DeleteStMenu;
import studentClassView.ModifyStMenu;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class View extends JFrame {

	private JPanel contentPane;
	static ListDb ldb = new ListDb();// ����ListDb����
	static WorkSDb wsdb = new WorkSDb();
	static WorkSeDb wsedb = new WorkSeDb();
	static WorkStDb wstdb = new WorkStDb();
	static Connection con = null;
	static ResultSet resultSet = null;
	/**
	 * Launch the application.
	 * 
	 * @throws SQLException
	 */
	static Object S[][] = { { null, null, null, null, null }, { null, null, null, null, null },
			{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
			{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
			{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
			{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
			{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
			{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
			{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
			{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
			{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
			{ null, null, null, null, null }, };

	static Object Se[][] = { { null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
			{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
			{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
			{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
			{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
			{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
			{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
			{ null, null, null }, { null, null, null }, };

	static Object St[][] = { { null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
			{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
			{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
			{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
			{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
			{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
			{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
			{ null, null, null }, { null, null, null }, };
	private JLabel lblNewLabel;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table_2;
	private JTextField textField_6;
	private JTextField textField_7;


	/**
	 * Create the frame.
	 */
	public View(Connection con) {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("res/image/student.jpg"));
		setTitle("ѧ������ϵͳ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 957, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("ѧ������ϵͳ");
		lblNewLabel.setBounds(382, 43, 180, 35);
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 30));
		contentPane.add(lblNewLabel);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 90, 913, 427);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("ѧ��", null, panel, null);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 60, 880, 322);
		panel.add(scrollPane);
		wsdb.select(con, S);
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setColumnSelectionAllowed(true);
		table.setModel(new DefaultTableModel(S, new String[] { "ѧ��", "����", "�Ա�", "��������", "����Ժϵ" }));

		JButton btnNewButton = new JButton("���");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddSMenu(con);
			}
		});
		btnNewButton.setBounds(14, 20, 63, 27);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("ɾ��");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteSMenu(con);
			}
		});
		btnNewButton_1.setBounds(91, 20, 63, 27);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("�޸�");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ModifySMenu(con);
			}
		});
		btnNewButton_2.setBounds(168, 20, 63, 27);
		panel.add(btnNewButton_2);

		JLabel lblNewLabel_1 = new JLabel("ѧ�ţ�");
		lblNewLabel_1.setBounds(245, 24, 45, 18);
		panel.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(306, 21, 86, 24);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("������");
		lblNewLabel_2.setBounds(406, 24, 45, 18);
		panel.add(lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setBounds(465, 21, 86, 24);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("����Ժϵ��");
		lblNewLabel_3.setBounds(565, 24, 75, 18);
		panel.add(lblNewLabel_3);

		textField_2 = new JTextField();
		textField_2.setBounds(654, 21, 86, 24);
		panel.add(textField_2);
		textField_2.setColumns(10);

		JButton btnNewButton_3 = new JButton("��ѯ");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = 0;
				String studentNumber = null;
				String name = null;
				String sex = null;
				String birthday = null;
				String department = null;
				Object S[][] = { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null }, };
				studentNumber = textField.getText();
				name = textField_1.getText();
				department = textField_2.getText();
				Student student = new Student(studentNumber, name, sex, birthday, department);
				try {
					resultSet = wsdb.getStudent(student, con);
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
				try {
					while (resultSet.next()) {
						studentNumber = resultSet.getString("ѧ��");
						name = resultSet.getString("����");
						sex = resultSet.getString("�Ա�");
						birthday = resultSet.getString("��������");
						try {
							department = resultSet.getString("����Ժϵ");
						} catch (SQLException e1) {
							// TODO �Զ����ɵ� catch ��
							e1.printStackTrace();
						}
						S[i][0] = studentNumber;
						S[i][1] = name;
						S[i][2] = sex;
						S[i][3] = birthday;
						S[i][4] = department;
						i++;
					}
					table.setModel(new DefaultTableModel(S, new String[] { "ѧ��", "����", "�Ա�", "��������", "����Ժϵ" }));
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}

			}
		});

		btnNewButton_3.setBounds(754, 20, 63, 27);
		panel.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("ˢ��");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object S[][] = { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null }, };
				wsdb.select(con, S);
				table.setModel(new DefaultTableModel(S, new String[] { "ѧ��", "����", "�Ա�", "��������", "����Ժϵ" }));

			}
		});
		btnNewButton_4.setBounds(831, 20, 63, 27);
		panel.add(btnNewButton_4);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("ѡ��", null, panel_1, null);
		panel_1.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(14, 60, 880, 322);
		panel_1.add(scrollPane_1);
		wsedb.select(con, Se);
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(Se, new String[] { "ѧ��", "�γ̺�", "�ɼ�" }));

		JButton btnNewButton_5 = new JButton("���");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddSeMenu(con);
			}
		});
		btnNewButton_5.setBounds(14, 20, 63, 27);
		panel_1.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("ɾ��");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteSeMenu(con);
			}
		});
		btnNewButton_6.setBounds(91, 20, 63, 27);
		panel_1.add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("�޸�");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ModifySeMenu(con);
			}
		});
		btnNewButton_7.setBounds(168, 20, 63, 27);
		panel_1.add(btnNewButton_7);

		JLabel lblNewLabel_4 = new JLabel("ѧ�ţ�");
		lblNewLabel_4.setBounds(262, 24, 45, 18);
		panel_1.add(lblNewLabel_4);

		textField_3 = new JTextField();
		textField_3.setBounds(321, 21, 86, 24);
		panel_1.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("�γ̺ţ�");
		lblNewLabel_5.setBounds(421, 24, 60, 18);
		panel_1.add(lblNewLabel_5);

		textField_4 = new JTextField();
		textField_4.setBounds(495, 21, 86, 24);
		panel_1.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("�ɼ���");
		lblNewLabel_6.setBounds(595, 24, 45, 18);
		panel_1.add(lblNewLabel_6);

		textField_5 = new JTextField();
		textField_5.setBounds(654, 21, 86, 24);
		panel_1.add(textField_5);
		textField_5.setColumns(10);

		JButton btnNewButton_8 = new JButton("��ѯ");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = 0;
				String studentNumber = null;
				String classNumber = null;
				int record = -1;
				String str = null;
				Object Se[][] = { { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, };
				studentNumber = textField_3.getText();
				classNumber = textField_4.getText();
				str = textField_5.getText();
				if (str.equals("")) {
					record = -1;
				} else {
					try {
						record = Integer.parseInt(str);
					} catch (NumberFormatException e1) {
						record = -1;
					}

				}
				SelectClass se = new SelectClass(studentNumber, classNumber, record);
				try {
					resultSet = wsedb.getSelectClass(se, con);
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
				try {
					while (resultSet.next()) {
						studentNumber = resultSet.getString("ѧ��");
						classNumber = resultSet.getString("�γ̺�");
						record = resultSet.getInt("�ɼ�");
						Se[i][0] = studentNumber;
						Se[i][1] = classNumber;
						Se[i][2] = record;
						i++;
					}
					table_1.setModel(new DefaultTableModel(Se, new String[] { "ѧ��", "�γ̺�", "�ɼ�" }));
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_8.setBounds(754, 20, 63, 27);
		panel_1.add(btnNewButton_8);

		JButton btnNewButton_9 = new JButton("ˢ��");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object Se[][] = { { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, };
				wsedb.select(con, Se);
				table_1.setModel(new DefaultTableModel(Se, new String[] { "ѧ��", "�γ̺�", "�ɼ�" }));
			}
		});
		btnNewButton_9.setBounds(831, 20, 63, 27);
		panel_1.add(btnNewButton_9);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("�γ�", null, panel_2, null);
		panel_2.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(14, 60, 880, 322);
		panel_2.add(scrollPane_2);
		wstdb.select(con, St);
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(St, new String[] { "�γ̺�", "�γ���", "ѧ��" }));
		scrollPane_2.setViewportView(table_2);

		JButton btnNewButton_10 = new JButton("���");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddStMenu(con);
			}
		});
		btnNewButton_10.setBounds(14, 20, 63, 27);
		panel_2.add(btnNewButton_10);

		JButton btnNewButton_11 = new JButton("ɾ��");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteStMenu(con);
			}
		});
		btnNewButton_11.setBounds(91, 20, 63, 27);
		panel_2.add(btnNewButton_11);

		JButton btnNewButton_12 = new JButton("�޸�");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ModifyStMenu(con);
			}
		});
		btnNewButton_12.setBounds(168, 20, 63, 27);
		panel_2.add(btnNewButton_12);

		JLabel lblNewLabel_7 = new JLabel("�γ�����");
		lblNewLabel_7.setBounds(421, 24, 60, 18);
		panel_2.add(lblNewLabel_7);

		textField_6 = new JTextField();
		textField_6.setBounds(495, 21, 86, 24);
		panel_2.add(textField_6);
		textField_6.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("ѧ�֣�");
		lblNewLabel_8.setBounds(595, 24, 45, 18);
		panel_2.add(lblNewLabel_8);

		textField_7 = new JTextField();
		textField_7.setBounds(654, 21, 86, 24);
		panel_2.add(textField_7);
		textField_7.setColumns(10);

		JButton btnNewButton_13 = new JButton("��ѯ");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = 0;
				String classNumber = null;
				String className = null;
				int credit = -1;
				String str = null;
				Object St[][] = { { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, };
				className = textField_6.getText();
				str = textField_7.getText();
				if (str.equals("")) {
					credit = -1;
				} else {
					try {
						credit = Integer.parseInt(str);
					} catch (NumberFormatException e1) {
						credit = -1;
					}
				}
				StudentClass st=new StudentClass(classNumber,className,credit);
				try {
					resultSet = wstdb.getStudentClass(st, con);
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
				try {
					while(resultSet.next()) {
						classNumber=resultSet.getString("�γ̺�");
						className=resultSet.getString("�γ���");
						credit=resultSet.getInt("ѧ��");
						St[i][0]=classNumber;
						St[i][1]=className;
						St[i][2]=credit;
						i++;
						}
					table_2.setModel(new DefaultTableModel(St, new String[] { "�γ̺�", "�γ���", "ѧ��" }));
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_13.setBounds(754, 20, 63, 27);
		panel_2.add(btnNewButton_13);

		JButton btnNewButton_14 = new JButton("ˢ��");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object St[][] = { { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, };
				wstdb.select(con, St);
				table_2.setModel(new DefaultTableModel(St, new String[] { "�γ̺�", "�γ���", "ѧ��" }));
			}
		});
		btnNewButton_14.setBounds(831, 20, 63, 27);
		panel_2.add(btnNewButton_14);
		setVisible(true);
	}
	
}
