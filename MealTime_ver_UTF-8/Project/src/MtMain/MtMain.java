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
		
		//로그인
//		mtdao.doLogin("A", "0220");
		
		//아이디 중복확인
//		ArrayList<String> idArray = mtdao.getMembersId();
//		System.out.println(idArray.contains("yoon"));
//		if(idArray.contains("yoon")){
//			System.out.println("이미 있는 아이디 입니다.");
//		}else{
//			System.out.println("사용 가능한 아이디 입니다.");
//		};
				
		//회원가입 (insert)		
//		boolean gaip = mtdao.insert_member("id", "비번", "이름", "990101", "c", "d");
//		
//		if(gaip) {
//			System.out.println("insert 성공");
//		}
//		else {
//			System.out.println("insert 실패");
//		}

		//최근 먹은 음식 리스트 추가 (insert)		
//		boolean curt = mtdao.insert_cunrt("yoon", 2, "990101", 2);
//		
//		if(curt) {
//			System.out.println("insert 성공");
//		}
//		else {
//			System.out.println("insert 실패");
//		}

		//최근 먹은 음식 리스트 출력(select)		
//		ArrayList<Mt_VO> curL = mtdao.getCurtList("yoon");
//		
//		for(Mt_VO vo : curL) {
//			System.out.println(vo.getCurt_date() +"\t"+ vo.getG_name() +"\t"+ vo.getMu_name());
//		}
//		
		//조건에 맞는 음식 리스트 출력
		ArrayList<Mt_VO> memuList = mtdao.getGageaList("한식");
		random_gagea_id = (int)(Math.random()*memuList.size());
		System.out.println(random_gagea_id);
		System.out.println(memuList.get(random_gagea_id).getG_id()+" "+memuList.get(random_gagea_id).getMu_id());
		
		int g_id = memuList.get(random_gagea_id).getG_id();
		int mu_id = memuList.get(random_gagea_id).getMu_id();
		
		//음식점 정보 리스트 출력(select)
		ArrayList<Mt_VO> gList = mtdao.getGageaList(g_id,mu_id);
		
		for(Mt_VO vo : gList) {
			System.out.print(vo.getG_name() +"\t"+ vo.getG_jooso() +"\t"+ vo.getG_phone()+"\t"+vo.getMu_name()+"\t"+vo.getMu_money()+"\t"+vo.getG_jumsoo()+"\t");
			}
		
		ArrayList<Mt_VO> curtMList = mtdao.getCurtMemList("yoon", mu_id);
			try {
				System.out.println(curtMList.get(0).getCurt_date());
			}catch (IndexOutOfBoundsException e) {
				System.out.println("없음");
			}
			
		//최근 먹은 음식 삭제(delete)
//		boolean del_curt = mtdao.delete_curt("yoon", "990101");
//		
//		if(del_curt) {
//			System.out.println("del_curt 수행");
//		}else {
//			System.out.println("del_curt 실패");
//		}

		//리스트 평점 업데이트(update)
//		for(int i = 1 ; i <= 5 ; i++) {
//		boolean update_jumsoo = mtdao.update_jumsoo(i);
//			if(update_jumsoo) {
//				System.out.println("update_jumsoo 수행 : "+i);
//			}else {
//				System.out.println("update_jumsoo 실패 : "+i);
//			}
//		}
//		
	}// main-end
}
