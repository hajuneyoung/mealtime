package mealtime;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import mtDAO.MtDAO;
import mtVO.Mt_UserInfo;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textID;
	private JTextField textPw;
	
	Mt_UserInfo userinfo = Mt_UserInfo.getUserInfo();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("��Ÿ��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton btnLoing = new JButton("�α���");
		btnLoing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				
				 try {
                     MtDAO mtDAO = new MtDAO();
                     boolean lg_pass;
                     
                     if(textID.getText().isEmpty()) {
                             JOptionPane.showMessageDialog(null, "���̵� �Է����ּ���");
                             lg_pass = false;
                     }else if(textPw.getText().isEmpty()) {
                             JOptionPane.showMessageDialog(null, "��й�ȣ�� �Է����ּ���");
                             lg_pass = false;
                     }else {
                             
                             lg_pass = mtDAO.doLogin(textID.getText(), textPw.getText());
                             
                             if(!lg_pass) {
                                     JOptionPane.showMessageDialog(null, "�α��� ����");
                             }else {
                                     JOptionPane.showMessageDialog(null, "�α��� ����");
                                     userinfo.setMem_id(textID.getText());
                                     dispose();
                                     new Choice().setVisible(true);
                                     setVisible(false);
                                     }
                             }
                     } catch (ClassNotFoundException | SQLException e1) {
                             e1.printStackTrace();
                     }
				
			}
			});

		btnLoing.setFont(new Font("����", Font.BOLD, 12));
		btnLoing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLoing.setBounds(89, 182, 104, 34);
		contentPane.add(btnLoing);
		contentPane.setName("");
		
		textID = new JTextField();
		textID.setBounds(159, 49, 143, 21);
		contentPane.add(textID);
		textID.setColumns(10);
		
		textPw = new JTextField();
		textPw.setColumns(10);
		textPw.setBounds(159, 84, 143, 21);
		contentPane.add(textPw);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(45, 52, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(45, 87, 78, 15);
		contentPane.add(lblPassword);
		
		JButton btnSignUp = new JButton("ȸ������");
		btnSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
						
				dispose();// ���� â ���������� ��
				setVisible(false); //ȭ�鿡 �� ���̰� �ϴ� ��
				new SignUp().setVisible(true); // ��ü�� �����ؼ� �޸𸮿� Ŭ���� ������ ��´�.
												// ȭ���� ���̰� �����Ѵ�.
			}
		});
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
			}
		});
		btnSignUp.setFont(new Font("����", Font.BOLD, 12));
		btnSignUp.setBounds(230, 182, 104, 34);
		contentPane.add(btnSignUp);
	}
}