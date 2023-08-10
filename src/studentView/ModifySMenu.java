package studentView;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import attribute.Student;
import db.WorkSDb;
import mainView.Window;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import java.awt.Toolkit;

public class ModifySMenu {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnNewButton;

	private String studentNumber;
	private String name;
	private String sex;
	private String birthday;
	private String department;
	WorkSDb wsdb=new WorkSDb();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public ModifySMenu(Connection conn) {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("res/image/student.jpg"));
		frame.setTitle("学生信息修改界面");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("学号：");
		lblNewLabel.setBounds(149, 36, 45, 18);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(208, 33, 86, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("姓名：");
		lblNewLabel_1.setBounds(149, 67, 45, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(208, 64, 86, 24);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("性别：");
		lblNewLabel_2.setBounds(149, 98, 45, 18);
		frame.getContentPane().add(lblNewLabel_2);
		String str[]= {"男","女"};
		JComboBox comboBox = new JComboBox(str);
		comboBox.setBounds(208, 95, 44, 24);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("出生日期：");
		lblNewLabel_3.setBounds(119, 129, 75, 18);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(208, 126, 86, 24);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("所在院系：");
		lblNewLabel_4.setBounds(119, 160, 75, 18);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(208, 157, 86, 24);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		btnNewButton = new JButton("修改学生");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int or=2;
				boolean k = true;
				Window window=new Window();
				if(textField.getText().equals("")||textField_1.getText().equals("")) {
					window.ModifyFailWindow();;
				}
				else {
					studentNumber=textField.getText();
					name=textField_1.getText();
				    sex=comboBox.getSelectedItem().toString();
					birthday=textField_3.getText();
					department=textField_4.getText();
					if(k) {
						Student student=new Student(studentNumber,name,sex,birthday,department);
						try {
							or=wsdb.modify(student, conn);
						} catch (SQLException e1) {
							// TODO 自动生成的 catch 块
							window.ModifyFailWindow();
						}
						if(or==1) {
							window.ModifySuccessWindow();
						}
						if(or==0) {
							window.ModifyFailWindow();
						}
					}
				}
				
			}
		});
		btnNewButton.setBounds(168, 215, 93, 27);
		frame.getContentPane().add(btnNewButton);
		frame.setVisible(true);
	}
}
