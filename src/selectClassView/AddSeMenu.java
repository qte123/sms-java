package selectClassView;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import attribute.SelectClass;
import db.WorkSeDb;
import mainView.Window;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class AddSeMenu {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnNewButton;

	private String studentNumber;
	private String classNumber;
	private int record;
	WorkSeDb wsedb = new WorkSeDb();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public AddSeMenu(Connection conn) {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("res/image/student.jpg"));
		frame.setTitle("选课信息添加界面");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("学号：");
		lblNewLabel.setBounds(143, 81, 45, 18);
		frame.getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(202, 78, 86, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("课程号：");
		lblNewLabel_1.setBounds(130, 112, 60, 18);
		frame.getContentPane().add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setBounds(202, 109, 86, 24);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("成绩：");
		lblNewLabel_2.setBounds(143, 143, 45, 18);
		frame.getContentPane().add(lblNewLabel_2);

		textField_2 = new JTextField();
		textField_2.setBounds(202, 140, 86, 24);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		btnNewButton = new JButton("添加选课");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int or = 2;
				boolean k = true;
				Window window = new Window();
				String str = null;
				if (textField.getText().equals("") || textField_1.getText().equals("")) {
					window.AddFailWindow();
				} else {
					studentNumber = textField.getText();
					classNumber = textField_1.getText();
					str = textField_2.getText();
					if (str.equals("")) {
						record = 0;
					} else {
						try {
							record = Integer.parseInt(str);
						} catch (NumberFormatException e1) {
							window.AddFailWindow();
							k = false;
						}

					}
					if (k) {
						SelectClass se = new SelectClass(studentNumber, classNumber, record);
						try {
							or = wsedb.add(se, conn);
						} catch (SQLException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
							window.AddFailWindow();
						}
						if (or == 1) {
							window.AddSuccessWindow();
						}
						if (or == 0) {
							window.AddFailWindow();
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
