package mtDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mtConn.MtDBConn;
import mtVO.Mt_VO;

public class MtDAO {

	private Connection con;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//DAO 객체 생성시 connection 가져오기
	public MtDAO() throws ClassNotFoundException, SQLException {
		con = new MtDBConn().getConnection();
	}

	//로그인 하기
	public boolean doLogin(String mem_id,String mem_ps){
		String db_mem_ps = "";
		String sql = "select mem_ps"
				+ " from member_table"
				+ " where mem_id = ?"
				+ " and mem_ps = ?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			pstmt.setString(2, mem_ps);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				db_mem_ps = rs.getString("mem_ps");
			}
			if (db_mem_ps.equals(mem_ps)) {	
				System.out.println("로그인 성공");
				return true;
			}else {
				System.out.println("아이디와 비번이 일치하지 않습니다.");
				
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	

	public boolean checkId(String id) throws SQLException{
		String sql = "select mem_id from member_table";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			if(rs.getString("mem_id").equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean insert_jumsu(int g_id ,String g_score) {
        // TODO Auto-generated method stub
        String sql = "insert into score values(?,?)";
        
         
       try {
          pstmt=con.prepareStatement(sql);
         
          pstmt.setInt(1, g_id);
          pstmt.setString(2, g_score);
          rs=pstmt.executeQuery();
       
       }catch (Exception e) {
          System.out.println(e.getMessage());
          return false;
       }
       return true; 
       
    }
	


	
	
	//회원가입 (insert)
	public boolean insert_member(String id, String ps, String name, String birth, String email, String phone) {
        String sql = "insert into member_table values (?,?,?,to_date(?),?,?)"; 
        													
        try {
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, id);
                pstmt.setString(2, ps);
                pstmt.setString(3, name);
                pstmt.setString(4, birth);
                pstmt.setString(5, email);
                pstmt.setString(6, phone);

                pstmt.executeUpdate();

        } catch (SQLException e) {
        		System.out.println(e.getMessage());
                System.out.println("insert Exception");
                return false;
        }
        return true;
	}

	//최근 먹은 음식 리스트 추가 (insert)	
	public boolean insert_cunrt(String mem_id, int mu_id, int g_id ) {
        String sql = "insert into curt_menu values (?,?,to_date(to_char(sysdate)),?)"; 

        try {
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, mem_id);
                pstmt.setInt(2, mu_id);
                pstmt.setInt(3, g_id);
                
                pstmt.executeUpdate();
        } catch (SQLException e) {
        		System.out.println(e.getMessage());
                System.out.println("insert Exception");
                return false;
        }
        return true;
	}

	//최근 먹은 음식 리스트 출력(select)
	public ArrayList<Mt_VO> getCurtList(String mem_id) {
	
		ArrayList<Mt_VO> mtArray = new ArrayList<Mt_VO>();
		
		String sql = "select to_char(c.curt_date) 날짜, g.g_name 가게이름 , m.mu_name 메뉴이름"
				+ " from curt_menu c, gagea g, menu m"
				+ " where c.g_id = g.g_id"
				+ " and c.mu_id = m.mu_id"
				+ " and c.mem_id = ?"
				+ " order by 1 desc";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String date = rs.getString("날짜");
				String g_name = rs.getString("가게이름");
				String mu_name = rs.getString("메뉴이름");
				Mt_VO vo = new Mt_VO(date,g_name,mu_name);
				
				mtArray.add(vo);
				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return mtArray;
	}
	
	//조건에 맞는 메뉴 리스트 출력(select)
	public ArrayList<Mt_VO> getGageaList(String mu_jong) {
	
		ArrayList<Mt_VO> mtArray = new ArrayList<Mt_VO>();
		
		String sql = "select g.g_id, m.mu_id"
				+ " from gagea g, menu m"
				+ " where g.g_id = m.g_id"
				+ " and m.mu_jong = ?"
				+ " order by 1 desc";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mu_jong);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int mu_id = rs.getInt(2);
				int g_id = rs.getInt(1);
				Mt_VO vo = new Mt_VO(g_id,mu_id);
				mtArray.add(vo);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return mtArray;
	}
	
	public ArrayList<Mt_VO> getGageaList(String mu_jong, String mu_rnn, String mu_meaoon, String mu_ondo, String mu_meat, int mu_money, String g_jooso) {
		
		ArrayList<Mt_VO> mtArray = new ArrayList<Mt_VO>();
		
		String sql = "select g.g_id, m.mu_id"
				+ " from gagea g, menu m"
				+ " where g.g_id = m.g_id"
				+ " and m.mu_jong = ?"
				+ " and m.mu_rnn = ?"
				+ " and m.mu_meaoon = ?"
				+ " and m.mu_ondo = ?"
				+ " and m.mu_meat = ?"
				+ " and m.mu_money < ?"
				+ " and g.g_jooso = ?"
				+ " order by 1 desc";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mu_jong);
			pstmt.setString(2, mu_rnn);
			pstmt.setString(3, mu_meaoon);
			pstmt.setString(4, mu_ondo);
			pstmt.setString(5, mu_meat);
			pstmt.setInt(6, mu_money);
			pstmt.setString(7, g_jooso);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int mu_id = rs.getInt(2);
				int g_id = rs.getInt(1);
				Mt_VO vo = new Mt_VO(g_id,mu_id);
				mtArray.add(vo);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return mtArray;
	}
	
	//음식 정보 리스트 출력(select)
	public ArrayList<Mt_VO> getGageaList(int g_id,int mu_id){
		
		ArrayList<Mt_VO> gagaeLArray = new ArrayList<Mt_VO>();
		
		String sql = "select *"
				+ " from gagea g,menu m"
				+ " where g.g_id = m.g_id"
				+ " and g.g_id = ?"
				+ " and m.mu_id = ?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, g_id);
			pstmt.setInt(2, mu_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String g_name = rs.getString("g_name");
				String g_jooso = rs.getString("g_jooso");
				String g_phone = rs.getString("g_phone");
				double g_jumsoo = rs.getDouble("g_jumsoo");
				String m_name = rs.getString("mu_name");
				int m_money = rs.getInt("mu_money");
				
				Mt_VO vo = new Mt_VO(g_name,g_jooso,g_phone,g_jumsoo,m_name,m_money);
				
				gagaeLArray.add(vo);
				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return gagaeLArray;
	}
	
	//최근에 이 음식을 먹은 날짜(select)
	public ArrayList<Mt_VO> getCurtMemList(String mem_id,int mu_id) {
		
		ArrayList<Mt_VO> mtArray = new ArrayList<Mt_VO>();
		
		String sql = "select to_char(c.curt_date) 날짜, g.g_name 가게이름 , m.mu_name 메뉴이름"
				+ " from curt_menu c, gagea g, menu m"
				+ " where c.g_id = g.g_id"
				+ " and c.mu_id = m.mu_id"
				+ " and c.mem_id = ?"
				+ " and m.mu_id = ?"
				+ " order by 1 desc";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			pstmt.setInt(2, mu_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String date = rs.getString("날짜");
				String g_name = rs.getString("가게이름");
				String mu_name = rs.getString("메뉴이름");
				Mt_VO vo = new Mt_VO(date,g_name,mu_name);
				
				mtArray.add(vo);
				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return mtArray;
	}
	
	//최근 먹은 음식 삭제(delete)
    public boolean delete_curt(String mem_id, String curt_date) {
            String sql = "delete"
            		+ " from curt_menu"
            		+ " where mem_id = ?"
            		+ " and curt_date = to_date(?)";
            try {
                    pstmt = con.prepareStatement(sql);
                    pstmt.setString(1, mem_id);
                    pstmt.setString(2, curt_date);
                    pstmt.executeUpdate();
                    
                    
            } catch (SQLException e) {
                    System.out.println("delete Exception");
                    return false;
            }
            return true; 
    }

    //리스트 평점 업데이트(update)
    public boolean update_jumsoo(int g_id) {
        
    String sql = "update gagea set g_jumsoo = "
                    + "(select avg(g_score) "
                    + "from score where g_id = ?) "
                    + "where g_id = ?";
    try {
            pstmt=con.prepareStatement(sql);
            pstmt.setInt(1, g_id);
            pstmt.setInt(2, g_id);
            pstmt.executeUpdate();
    }catch (SQLException e) {
            System.out.println(e.getMessage());
    		System.out.println("update Exception");
            return false;
    }                
    return true;
}

	 

}//MtDAO-end

