package mealtime;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import mtVO.Mt_UserInfo;

public class Choice extends JFrame {

	private JPanel contentPane;
	
    Mt_UserInfo userinfo = Mt_UserInfo.getUserInfo();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Choice frame = new Choice();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Choice() {
		System.out.println(userinfo.getMem_id());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("밀타임");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(161, 10, 106, 51);
		contentPane.add(lblNewLabel);
		
		JButton btnLastMenu = new JButton("지난번 메뉴 보기");
		btnLastMenu.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
				new LastTimeMenu().setVisible(true);
			}
			
		});
		btnLastMenu.setFont(new Font("굴림", Font.BOLD, 14));
		btnLastMenu.setBounds(38, 88, 146, 73);
		contentPane.add(btnLastMenu);
		
		JButton btnNewMenu = new JButton("새로운 메뉴 추천");
		btnNewMenu.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
				new MenuRecommend().setVisible(true);
			}
			
			
		});
		btnNewMenu.setFont(new Font("굴림", Font.BOLD, 14));
		btnNewMenu.setBounds(244, 88, 146, 73);
		contentPane.add(btnNewMenu);
		
		JButton btnEnd = new JButton("종료");
		btnEnd.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				Mt_UserInfo userinfo = Mt_UserInfo.getUserInfo();
				userinfo.setReset();
				dispose();
				setVisible(false);
				new Login().setVisible(true);
			}
			
			
		});
		btnEnd.setBounds(300, 192, 90, 40);
		contentPane.add(btnEnd);
	}

}
