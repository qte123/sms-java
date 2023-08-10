package mainView;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Window {//弹出窗口

	private JFrame frame;
	/**
	 * @wbp.parser.entryPoint
	 */
	public void SelectFailWindow() {//查询失败窗口
		frame = new JFrame();	
		frame.setTitle("失败");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("res/image/student.jpg"));
		frame.setBounds(100, 100, 340, 138);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("查询失败");
		lblNewLabel.setBounds(126, 33, 60, 18);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
		
	}
	public void SelectSuccessWindow() {//查询成功窗口
		frame = new JFrame();
		frame.setTitle("成功");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("res/image/student.jpg"));
		frame.setBounds(100, 100, 340, 138);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("查询成功");
		lblNewLabel.setBounds(126, 33, 60, 18);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
		
	}
	public void AddSuccessWindow() {//添加成功窗口
		frame = new JFrame();
		frame.setTitle("成功");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("res/image/student.jpg"));
		frame.setBounds(100, 100, 338, 133);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("添加成功");
		lblNewLabel.setBounds(126, 33, 60, 18);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
	}
	public void AddFailWindow() {//添加失败窗口
		frame = new JFrame();
		frame.setTitle("失败");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("res/image/student.jpg"));
		frame.setBounds(100, 100, 338, 133);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("添加失败");
		lblNewLabel.setBounds(126, 33, 60, 18);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
	}
	public void DeleteSuccessWindow() {//删除成功窗口
		frame = new JFrame();
		frame.setTitle("成功");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("res/image/student.jpg"));
		frame.setBounds(100, 100, 338, 133);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("删除成功");
		lblNewLabel.setBounds(126, 33, 60, 18);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
	}
	public void DeleteFailWindow() {//删除失败窗口
		frame = new JFrame();
		frame.setTitle("失败");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("res/image/student.jpg"));
		frame.setBounds(100, 100, 338, 133);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("删除失败");
		lblNewLabel.setBounds(126, 33, 60, 18);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
	}
	public void ModifySuccessWindow() {//修改成功窗口
		frame = new JFrame();
		frame.setTitle("成功");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("res/image/student.jpg"));
		frame.setBounds(100, 100, 338, 133);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("修改成功");
		lblNewLabel.setBounds(126, 33, 60, 18);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
	}
	public void ModifyFailWindow() {//修改失败窗口
		frame = new JFrame();
		frame.setTitle("失败");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("res/image/student.jpg"));
		frame.setBounds(100, 100, 338, 133);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("修改失败");
		lblNewLabel.setBounds(126, 33, 60, 18);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
	}
}
