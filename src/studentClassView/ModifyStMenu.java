package studentClassView;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import attribute.StudentClass;
import db.WorkStDb;
import mainView.Window;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class ModifyStMenu {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnNewButton;
	private String classNumber;
	private String className;
	private int credit;
	WorkStDb wstdb = new WorkStDb();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public ModifyStMenu(Connection conn) {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("res/image/student.jpg"));
		frame.setTitle("课程信息修改界面");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("课程号：");
		lblNewLabel.setBounds(129, 77, 60, 18);
		frame.getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(203, 74, 86, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("课程名：");
		lblNewLabel_1.setBounds(129, 108, 60, 18);
		frame.getContentPane().add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setBounds(203, 105, 86, 24);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("学分：");
		lblNewLabel_2.setBounds(144, 139, 45, 18);
		frame.getContentPane().add(lblNewLabel_2);

		textField_2 = new JTextField();
		textField_2.setBounds(203, 136, 86, 24);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		btnNewButton = new JButton("修改课程");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int or = 2;
				boolean k = true;
				Window window = new Window();
				String str = null;
				if (textField.getText().equals("") || textField_1.getText().equals("")) {
					window.ModifyFailWindow();
				} else {
					classNumber = textField.getText();
					className = textField_1.getText();
					str = textField_2.getText();
					if (str.equals("")) {
						credit = 0;
					} else {
						try {
							credit = Integer.parseInt(str);
						} catch (NumberFormatException e1) {
							window.ModifyFailWindow();
							k = false;
							e1.printStackTrace();
						}

					}
					if (k) {
						StudentClass st = new StudentClass(classNumber, className, credit);
						try {
							or = wstdb.modify(st, conn);
						} catch (SQLException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
							window.ModifyFailWindow();
						}
						if (or == 1) {
							window.ModifySuccessWindow();
						}
						if (or == 0) {
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
