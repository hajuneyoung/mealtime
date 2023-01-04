package mealtime;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mtVO.Mt_UserInfo;

public class MenuRecommend extends JFrame {

private JPanel contentPane;

/**
* Launch the application.
*/
public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
				public void run() {
						try {
								MenuRecommend frame = new MenuRecommend();
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
		public MenuRecommend() {
					Mt_UserInfo userinfo = Mt_UserInfo.getUserInfo();
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					setBounds(100, 100, 556, 408);
					contentPane = new JPanel();
					contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
					setContentPane(contentPane);
					contentPane.setLayout(null);

					JButton btnCheck = new JButton("확인");
					btnCheck.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {

							dispose();
							new NotPreferred().setVisible(true);
							setVisible(false);


						}
					});
					btnCheck.setFont(new Font("굴림체", Font.PLAIN, 15));
					btnCheck.setBounds(362, 300, 97, 37);
					contentPane.add(btnCheck);

		JButton btnKoreanFood = new JButton("한식");
		btnKoreanFood.setFont(new Font("굴림", Font.PLAIN, 15));
		btnKoreanFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userinfo.setMu_jong("한식");
				JOptionPane.showMessageDialog(btnKoreanFood, "한식선택");
				System.out.println(userinfo.getMu_jong());
			}
		});
			btnKoreanFood.setBounds(83, 52, 138, 72);
			contentPane.add(btnKoreanFood);

			JButton btnChinesefood = new JButton("중식");
			btnChinesefood.setFont(new Font("굴림", Font.PLAIN, 15));
			btnChinesefood.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					userinfo.setMu_jong("중식");
					JOptionPane.showMessageDialog(btnChinesefood, "중식선택");
					System.out.println(userinfo.getMu_jong());
				}
			});
			btnChinesefood.setBounds(320, 52, 138, 72);
			contentPane.add(btnChinesefood);

			JButton btnWesternfood = new JButton("양식");
			btnWesternfood.setFont(new Font("굴림", Font.PLAIN, 15));
			btnWesternfood.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					userinfo.setMu_jong("양식");
					JOptionPane.showMessageDialog(btnWesternfood, "양식선택");
					System.out.println(userinfo.getMu_jong());
				}
			});			
			btnWesternfood.setBounds(322, 163, 138, 72);
			contentPane.add(btnWesternfood);
			
			JButton btnJapanesefood = new JButton("일식");
			btnJapanesefood.setFont(new Font("굴림", Font.PLAIN, 15));
			btnJapanesefood.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					userinfo.setMu_jong("일식");
					JOptionPane.showMessageDialog(btnJapanesefood, "일식선택");
					System.out.println(userinfo.getMu_jong());
				}
			});					
			btnJapanesefood.setBounds(83, 163, 138, 72);
			contentPane.add(btnJapanesefood);

}

}
