package mealtime;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import mtDAO.MtDAO;
import mtVO.Mt_UserInfo;

public class Grade extends JFrame {

	private JPanel contentPane;
	private AbstractButton rdbtn1;
	private AbstractButton rdbtn2;
	private AbstractButton rdbtn3;
	private AbstractButton rdbtn4;
	private AbstractButton rdbtn5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grade frame = new Grade();
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
	public Grade() {
		
		Mt_UserInfo uesrinfo = Mt_UserInfo.getUserInfo(); 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//////////////////////////////////////////////////////////////////////////////

		JRadioButton rdbtn1 = new JRadioButton("1");
		
		rdbtn1.setBounds(92, 203, 46, 23);
		
		contentPane.add(rdbtn1);
		
		
			//////////////////////////////////////////////////////////////////////////////
		
		JRadioButton rdbtn2 = new JRadioButton("2");
		
		rdbtn2.setBounds(142, 203, 46, 23);
		contentPane.add(rdbtn2);
		
		//////////////////////////////////////////////////////////////////////////////
		
		JRadioButton rdbtn3 = new JRadioButton("3");
		rdbtn3.setBounds(192, 203, 46, 23);
		contentPane.add(rdbtn3);
		
		
		//////////////////////////////////////////////////////////////////////////////
		
		
		JRadioButton rdbtn4 = new JRadioButton("4");
		rdbtn4.setBounds(242, 203, 46, 23);
		contentPane.add(rdbtn4);
		
		
		
		//////////////////////////////////////////////////////////////////////////////
		
		JRadioButton rdbtn5 = new JRadioButton("5");
		rdbtn5.setBounds(292, 203, 46, 23);
		contentPane.add(rdbtn5);
		
		
		ButtonGroup  group = new ButtonGroup();
		group.add(rdbtn1);
		group.add(rdbtn2);
		group.add(rdbtn3);
		group.add(rdbtn4);
		group.add(rdbtn5);
		
		
		JButton btnHome = new JButton("평가하기");	
		btnHome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MtDAO dao = null;
				try {
					dao = new MtDAO();
					String g_score = "";
					
					if(rdbtn1.isSelected()) {
						g_score="1";
					}else if(rdbtn2.isSelected()) {
						g_score="2";
					}else if(rdbtn3.isSelected()) {
						g_score="3";
					}else if(rdbtn4.isSelected()) {
						g_score="4";
					}else if(rdbtn5.isSelected()) {
						g_score="5";
					}
					
					dao.insert_jumsu(uesrinfo.getG_id(),g_score);
						boolean update_jumsoo = dao.update_jumsoo(uesrinfo.getG_id());
							if(update_jumsoo) 
								System.out.println("update_jumsoo 입력 : " + uesrinfo.getG_id());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
				
				dao.insert_cunrt(uesrinfo.getMem_id(),uesrinfo.getMu_id(),uesrinfo.getG_id());
                
				dispose();
                new Choice().setVisible(true);
                setVisible(false);
				
			}
		});
		
		btnHome.setBounds(165, 234, 97, 31);
		contentPane.add(btnHome);
		
		JLabel lblTitle = new JLabel("평가하기");
		lblTitle.setFont(new Font("굴림", Font.BOLD, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(155, 28, 107, 42);
		contentPane.add(lblTitle);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Grade.class.getResource("/mealtime/\uB9C8\uB124\uD0A4\uB124\uCF54.jpg")));
		lblNewLabel.setBounds(119, 61, 195, 125);
		contentPane.add(lblNewLabel);
	}

}
