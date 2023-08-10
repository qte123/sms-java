package studentView;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import attribute.Student;
import db.WorkSDb;
import mainView.Window;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class DeleteSMenu {

	private JFrame frame;
	private JTextField textField;
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
	public DeleteSMenu(Connection conn) {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("res/image/student.jpg"));
		frame.setTitle("学生信息删除界面");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("学号：");
		lblNewLabel.setBounds(141, 111, 45, 18);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(200, 108, 86, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("删除学生");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int or=2;
				boolean k=true;
				Window window=new Window();
				if(textField.getText().equals("")) {
					window.DeleteFailWindow();
				}
				else {
					studentNumber=textField.getText();
					if(k) {
						Student student=new Student(studentNumber,name,sex,birthday,department);
						try {
							or=wsdb.delete(student, conn);
						} catch (SQLException e1) {
							// TODO 自动生成的 catch 块
							window.DeleteFailWindow();
						}
						if(or==1) {
							window.DeleteSuccessWindow();
						}
						if(or==0) {
							window.DeleteFailWindow();
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
