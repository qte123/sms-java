package mainView;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Window {//��������

	private JFrame frame;
	/**
	 * @wbp.parser.entryPoint
	 */
	public void SelectFailWindow() {//��ѯʧ�ܴ���
		frame = new JFrame();	
		frame.setTitle("ʧ��");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("res/image/student.jpg"));
		frame.setBounds(100, 100, 340, 138);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("��ѯʧ��");
		lblNewLabel.setBounds(126, 33, 60, 18);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
		
	}
	public void SelectSuccessWindow() {//��ѯ�ɹ�����
		frame = new JFrame();
		frame.setTitle("�ɹ�");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("res/image/student.jpg"));
		frame.setBounds(100, 100, 340, 138);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("��ѯ�ɹ�");
		lblNewLabel.setBounds(126, 33, 60, 18);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
		
	}
	public void AddSuccessWindow() {//��ӳɹ�����
		frame = new JFrame();
		frame.setTitle("�ɹ�");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("res/image/student.jpg"));
		frame.setBounds(100, 100, 338, 133);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("��ӳɹ�");
		lblNewLabel.setBounds(126, 33, 60, 18);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
	}
	public void AddFailWindow() {//���ʧ�ܴ���
		frame = new JFrame();
		frame.setTitle("ʧ��");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("res/image/student.jpg"));
		frame.setBounds(100, 100, 338, 133);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("���ʧ��");
		lblNewLabel.setBounds(126, 33, 60, 18);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
	}
	public void DeleteSuccessWindow() {//ɾ���ɹ�����
		frame = new JFrame();
		frame.setTitle("�ɹ�");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("res/image/student.jpg"));
		frame.setBounds(100, 100, 338, 133);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ɾ���ɹ�");
		lblNewLabel.setBounds(126, 33, 60, 18);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
	}
	public void DeleteFailWindow() {//ɾ��ʧ�ܴ���
		frame = new JFrame();
		frame.setTitle("ʧ��");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("res/image/student.jpg"));
		frame.setBounds(100, 100, 338, 133);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ɾ��ʧ��");
		lblNewLabel.setBounds(126, 33, 60, 18);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
	}
	public void ModifySuccessWindow() {//�޸ĳɹ�����
		frame = new JFrame();
		frame.setTitle("�ɹ�");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("res/image/student.jpg"));
		frame.setBounds(100, 100, 338, 133);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("�޸ĳɹ�");
		lblNewLabel.setBounds(126, 33, 60, 18);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
	}
	public void ModifyFailWindow() {//�޸�ʧ�ܴ���
		frame = new JFrame();
		frame.setTitle("ʧ��");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("res/image/student.jpg"));
		frame.setBounds(100, 100, 338, 133);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("�޸�ʧ��");
		lblNewLabel.setBounds(126, 33, 60, 18);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
	}
}
