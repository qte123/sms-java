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

public class DeleteStMenu {

	private JFrame frame;
	private JTextField textField;
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
	public DeleteStMenu(Connection conn) {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("res/image/student.jpg"));
		frame.setTitle("�γ���Ϣɾ������");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("�γ�����");
		lblNewLabel.setBounds(127, 119, 60, 18);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(201, 116, 86, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("ɾ���γ�");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int or=2;
				boolean k=true;
				Window window=new Window();
				if(textField.getText().equals("")) {
					window.DeleteFailWindow();
				}
				else {
					className=textField.getText();
					if(k) {
						StudentClass st=new StudentClass(classNumber,className,credit);
						try {
							or=wstdb.delete(st, conn);
						} catch (SQLException e1) {
							// TODO �Զ����ɵ� catch ��
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
