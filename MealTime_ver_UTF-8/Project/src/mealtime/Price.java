package mealtime;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import mtVO.Mt_UserInfo;

public class Price extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Price frame = new Price();
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
	public Price() {
		Mt_UserInfo userinfo = Mt_UserInfo.getUserInfo();
		ButtonGroup price = new ButtonGroup();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtn10000 = new JRadioButton("1만원 이하");
		rdbtn10000.setBounds(53, 75, 121, 23);
		contentPane.add(rdbtn10000);
		
		JRadioButton rdbtn20000 = new JRadioButton("2만원 이하");
		rdbtn20000.setBounds(53, 111, 121, 23);
		contentPane.add(rdbtn20000);
		
		JRadioButton rdbtn30000 = new JRadioButton("3만원 이하");
		rdbtn30000.setBounds(53, 146, 121, 23);
		contentPane.add(rdbtn30000);
		
		JRadioButton rdbtnNo = new JRadioButton("상관없음");
		rdbtnNo.setBounds(53, 180, 121, 23);
		contentPane.add(rdbtnNo);
		
		price.add(rdbtn10000);
		price.add(rdbtn20000);
		price.add(rdbtn30000);
		price.add(rdbtnNo);
		
		
		JLabel lblNewLabel = new JLabel("가격대 선정");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 27));
		lblNewLabel.setBounds(109, 25, 220, 44);
		contentPane.add(lblNewLabel);
		
		JButton btnCheck = new JButton("확인");
		btnCheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(rdbtn10000.isSelected()) {
					userinfo.setMu_money(10000);
				}else if(rdbtn20000.isSelected()) {
					userinfo.setMu_money(20000);
				}else if(rdbtn30000.isSelected()) {
					userinfo.setMu_money(30000);
				}else {
					userinfo.setMu_money(999999);
				}
				
			dispose();
			new Location().setVisible(true);
			setVisible(false);
			}
			});
		btnCheck.setFont(new Font("굴림체", Font.PLAIN, 14));
		btnCheck.setBounds(298, 200, 88, 37);
		contentPane.add(btnCheck);
	}
}

