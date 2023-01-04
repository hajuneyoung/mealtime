package MtMain;

import java.sql.SQLException;
import java.util.ArrayList;

import mtDAO.MtDAO;
import mtVO.Mt_UserInfo;
import mtVO.Mt_VO;

public class MtMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		MtDAO mtdao = new MtDAO();
		int random_gagea_id ;
		
		//�α���
//		mtdao.doLogin("A", "0220");
		
		//���̵� �ߺ�Ȯ��
//		ArrayList<String> idArray = mtdao.getMembersId();
//		System.out.println(idArray.contains("yoon"));
//		if(idArray.contains("yoon")){
//			System.out.println("�̹� �ִ� ���̵� �Դϴ�.");
//		}else{
//			System.out.println("��� ������ ���̵� �Դϴ�.");
//		};
				
		//ȸ������ (insert)		
//		boolean gaip = mtdao.insert_member("id", "���", "�̸�", "990101", "c", "d");
//		
//		if(gaip) {
//			System.out.println("insert ����");
//		}
//		else {
//			System.out.println("insert ����");
//		}

		//�ֱ� ���� ���� ����Ʈ �߰� (insert)		
//		boolean curt = mtdao.insert_cunrt("yoon", 2, "990101", 2);
//		
//		if(curt) {
//			System.out.println("insert ����");
//		}
//		else {
//			System.out.println("insert ����");
//		}

		//�ֱ� ���� ���� ����Ʈ ���(select)		
//		ArrayList<Mt_VO> curL = mtdao.getCurtList("yoon");
//		
//		for(Mt_VO vo : curL) {
//			System.out.println(vo.getCurt_date() +"\t"+ vo.getG_name() +"\t"+ vo.getMu_name());
//		}
//		
		//���ǿ� �´� ���� ����Ʈ ���
		ArrayList<Mt_VO> memuList = mtdao.getGageaList("�ѽ�");
		random_gagea_id = (int)(Math.random()*memuList.size());
		System.out.println(random_gagea_id);
		System.out.println(memuList.get(random_gagea_id).getG_id()+" "+memuList.get(random_gagea_id).getMu_id());
		
		int g_id = memuList.get(random_gagea_id).getG_id();
		int mu_id = memuList.get(random_gagea_id).getMu_id();
		
		//������ ���� ����Ʈ ���(select)
		ArrayList<Mt_VO> gList = mtdao.getGageaList(g_id,mu_id);
		
		for(Mt_VO vo : gList) {
			System.out.print(vo.getG_name() +"\t"+ vo.getG_jooso() +"\t"+ vo.getG_phone()+"\t"+vo.getMu_name()+"\t"+vo.getMu_money()+"\t"+vo.getG_jumsoo()+"\t");
			}
		
		ArrayList<Mt_VO> curtMList = mtdao.getCurtMemList("yoon", mu_id);
			try {
				System.out.println(curtMList.get(0).getCurt_date());
			}catch (IndexOutOfBoundsException e) {
				System.out.println("����");
			}
			
		//�ֱ� ���� ���� ����(delete)
//		boolean del_curt = mtdao.delete_curt("yoon", "990101");
//		
//		if(del_curt) {
//			System.out.println("del_curt ����");
//		}else {
//			System.out.println("del_curt ����");
//		}

		//����Ʈ ���� ������Ʈ(update)
//		for(int i = 1 ; i <= 5 ; i++) {
//		boolean update_jumsoo = mtdao.update_jumsoo(i);
//			if(update_jumsoo) {
//				System.out.println("update_jumsoo ���� : "+i);
//			}else {
//				System.out.println("update_jumsoo ���� : "+i);
//			}
//		}
//		
	}// main-end
}
