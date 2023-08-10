package selectClassView;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import attribute.SelectClass;
import db.WorkSeDb;
import mainView.Window;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class DeleteSeMenu {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	private String studentNumber;
	private String classNumber;
	private int record;
	WorkSeDb wsedb=new WorkSeDb();
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public DeleteSeMenu(Connection conn) {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("res/image/student.jpg"));
		frame.setTitle("选课信息删除界面");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("学号：");
		lblNewLabel.setBounds(144, 87, 45, 18);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(203, 84, 86, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("课程号：");
		lblNewLabel_1.setBounds(129, 118, 60, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(203, 115, 86, 24);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("删除选课");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int or=2;
				boolean k=true;
				Window window=new Window();
				if(textField.getText().equals("")||textField_1.getText().equals("")) {
					window.DeleteFailWindow();
				}
				else {
					studentNumber=textField.getText();
					classNumber=textField_1.getText();
					if(k) {
						SelectClass se=new SelectClass(studentNumber,classNumber,record);
						try {
							or=wsedb.delete(se, conn);
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
