package mealtime;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import mtDAO.MtDAO;
import mtVO.Mt_UserInfo;
import mtVO.Mt_VO;

public class TodayMenu extends JFrame {

private JPanel contentPane;
private JTextField textField;
private JTextField textField_1;
private JTextField textField_2;
private JTextField textField_3;
private JTextField textField_4;
private JTextField textField_5;
private JTextField textField_6;

/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
TodayMenu frame = new TodayMenu();
frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}

/**
* Create the frame.
 * @throws SQLException 
 * @throws ClassNotFoundException 
*/
public TodayMenu() throws ClassNotFoundException, SQLException {
	Mt_UserInfo userinfo = Mt_UserInfo.getUserInfo();
	//조건에 맞는 음식 리스트 출력
	MtDAO mtdao = new MtDAO();
	int random_gagea_id;
	String curt = "";
	System.out.println(userinfo.getMu_jong()+"\t"+userinfo.getMu_rnn()+"\t"+userinfo.getMu_meaoon()+"\t"+userinfo.getMu_ondo()+"\t"+userinfo.getMu_meat()+"\t"+userinfo.getMu_money()+"\t"+userinfo.getG_jooso());
	
	ArrayList<Mt_VO> memuList = mtdao.getGageaList(userinfo.getMu_jong(),userinfo.getMu_rnn(),userinfo.getMu_meaoon(),userinfo.getMu_ondo(),userinfo.getMu_meat(),userinfo.getMu_money(),userinfo.getG_jooso());
	if(!memuList.isEmpty()) {
		random_gagea_id = (int)(Math.random()*memuList.size());
		System.out.println(random_gagea_id);
		
		System.out.println(memuList.get(random_gagea_id).getG_id()+" "+memuList.get(random_gagea_id).getMu_id());
		int g_id = memuList.get(random_gagea_id).getG_id();
		int mu_id = memuList.get(random_gagea_id).getMu_id();
	//음식점 정보 리스트 출력(select)
	ArrayList<Mt_VO> gList = mtdao.getGageaList(g_id,mu_id);
		for(Mt_VO vo : gList) {
			System.out.print(vo.getG_name() +"\t"+ vo.getG_jooso() +"\t"+ vo.getG_phone()+"\t"+vo.getMu_name()+"\t"+vo.getMu_money()+"\t"+vo.getG_jumsoo()+"\t");
			userinfo.setG_name(vo.getG_name());
			userinfo.setG_jooso(vo.getG_jooso());
			userinfo.setG_phone(vo.getG_phone());
			userinfo.setMu_name(vo.getMu_name());
			userinfo.setMu_money(vo.getMu_money());
			userinfo.setG_jumsoo(vo.getG_jumsoo());
			
		}
		
		ArrayList<Mt_VO> curtMList = mtdao.getCurtMemList(userinfo.getMem_id(), mu_id);
		try {
			curt = curtMList.get(0).getCurt_date();
		}catch (IndexOutOfBoundsException e) {
			curt = "없음";
		}
	}else {
		userinfo.setG_name("없음");
		userinfo.setG_jooso("없음");
		userinfo.setG_phone("없음");
		userinfo.setMu_name("없음");
		userinfo.setMu_money(0);
		userinfo.setG_jumsoo(0);
		curt="없음";
	}

	
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 604, 481);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);

textField = new JTextField();
textField.setBounds(376, 38, 140, 27);
textField.setText(userinfo.getG_name());
contentPane.add(textField);
textField.setColumns(10);

textField_1 = new JTextField();
textField_1.setColumns(10);
textField_1.setBounds(376, 75, 140, 27);
textField_1.setText(userinfo.getG_jooso());
contentPane.add(textField_1);

textField_2 = new JTextField();
textField_2.setColumns(10);
textField_2.setBounds(376, 113, 140, 27);
textField_2.setText(userinfo.getG_phone());
contentPane.add(textField_2);

textField_3 = new JTextField();
textField_3.setColumns(10);
textField_3.setBounds(376, 150, 140, 27);
textField_3.setText(userinfo.getMu_name());
contentPane.add(textField_3);

textField_4 = new JTextField();
textField_4.setColumns(10);
textField_4.setBounds(376, 188, 140, 27);
textField_4.setText(userinfo.getMu_money()+"");
contentPane.add(textField_4);

textField_5 = new JTextField();
textField_5.setColumns(10);
textField_5.setBounds(376, 225, 140, 27);
textField_5.setText(userinfo.getG_jumsoo()+"");
contentPane.add(textField_5);

textField_6 = new JTextField();
textField_6.setColumns(10);
textField_6.setText(curt);
textField_6.setBounds(376, 263, 140, 27);

contentPane.add(textField_6);

JButton btnReturn = new JButton("다시 뽑기");
btnReturn.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent e) {
		dispose();
		new MenuRecommend().setVisible(true);
		setVisible(false);
		}
});
btnReturn.setBounds(138, 365, 107, 38);
contentPane.add(btnReturn);

JButton btnCheck = new JButton("확인");
btnCheck.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent e) {
	if(!memuList.isEmpty()) {
		int random_gagea_id = (int)(Math.random()*memuList.size());
		int g_id = memuList.get(random_gagea_id).getG_id();
		int mu_id = memuList.get(random_gagea_id).getMu_id();
		userinfo.setG_id(g_id);
		userinfo.setMu_id(mu_id);
	
		dispose();
		new Grade().setVisible(true);
		setVisible(false);
		
		}else{
			JOptionPane.showMessageDialog(btnCheck, "등록된 메뉴가 없습니다\n처음으로 돌아갑니다");
			dispose();
			new Choice().setVisible(true);
			setVisible(false);
		}
	
	}

});
btnCheck.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
}
});
btnCheck.setBounds(307, 365, 107, 38);
contentPane.add(btnCheck);

JLabel lblRestaurantName = new JLabel("식당이름");
lblRestaurantName.setBounds(294, 44, 57, 15);
contentPane.add(lblRestaurantName);

JLabel lblLocation = new JLabel("식당 위치");
lblLocation.setBounds(294, 81, 57, 15);
contentPane.add(lblLocation);

JLabel lblTel = new JLabel("전화번호");
lblTel.setBounds(294, 119, 57, 15);
contentPane.add(lblTel);

JLabel lblMenuName = new JLabel("메뉴 이름");
lblMenuName.setBounds(294, 156, 57, 15);
contentPane.add(lblMenuName);

JLabel lblPrice = new JLabel("메뉴 가격");
lblPrice.setBounds(294, 194, 57, 15);
contentPane.add(lblPrice);

JLabel lblGrade = new JLabel("평점");
lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
lblGrade.setBounds(294, 231, 57, 15);
contentPane.add(lblGrade);

JLabel lblLastDay = new JLabel("최근 먹은날");
lblLastDay.setHorizontalAlignment(SwingConstants.CENTER);
lblLastDay.setBounds(275, 269, 91, 15);
contentPane.add(lblLastDay);

JLabel lblNewLabel = new JLabel("");
lblNewLabel.setIcon(new ImageIcon(TodayMenu.class.getResource("/mealtime/\uD14C\uC774\uBE14\uC0AC\uC9C42.png")));
lblNewLabel.setBounds(30, 33, 252, 257);
contentPane.add(lblNewLabel);


}
}
