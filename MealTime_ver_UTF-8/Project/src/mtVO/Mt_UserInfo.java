package mtVO;

public final class Mt_UserInfo {
			
		// gagae 테이블
		private int g_id;
		private String g_name;
		private String g_jooso;
		private String g_phone;
		private double g_jumsoo;
		
		// menu 테이블
		private int mu_id;
		private String mu_name;
		private String mu_jong;
		private String mu_rnn;
		private String mu_meaoon;
		private String mu_ondo;
		private String mu_meat; 
		private int mu_money;
		
		// member 테이블
		private String mem_id;
		private String mem_ps;
		private String mem_birth;
		private String mem_name;
		private String mem_email;
		private String mem_phone;
		
		// curt_menu 테이블
		private String curt_date;
		// 다른 테이블에 이미 있음
		//	private String mem_id;
		//	private int g_id;	
		//	private int mu_id;
		
		// score 테이블
	    private int g_scoer;
	    
	    static Mt_UserInfo userInfo = new Mt_UserInfo();
	    
	    private Mt_UserInfo() {}
	    
	    public static Mt_UserInfo getUserInfo() {
			return userInfo;
		}
	    
		public int getG_id() {
			return g_id;
		}

		public void setG_id(int g_id) {
			this.g_id = g_id;
		}

		public String getG_name() {
			return g_name;
		}

		public void setG_name(String g_name) {
			this.g_name = g_name;
		}

		public String getG_jooso() {
			return g_jooso;
		}

		public void setG_jooso(String g_jooso) {
			this.g_jooso = g_jooso;
		}

		public String getG_phone() {
			return g_phone;
		}

		public void setG_phone(String g_phone) {
			this.g_phone = g_phone;
		}

		public double getG_jumsoo() {
			return g_jumsoo;
		}

		public void setG_jumsoo(double g_jumsoo) {
			this.g_jumsoo = g_jumsoo;
		}

		public int getMu_id() {
			return mu_id;
		}

		public void setMu_id(int mu_id) {
			this.mu_id = mu_id;
		}

		public String getMu_name() {
			return mu_name;
		}

		public void setMu_name(String mu_name) {
			this.mu_name = mu_name;
		}

		public String getMu_jong() {
			return mu_jong;
		}

		public void setMu_jong(String mu_jong) {
			this.mu_jong = mu_jong;
		}

		public String getMu_rnn() {
			return mu_rnn;
		}

		public void setMu_rnn(String mu_rnn) {
			this.mu_rnn = mu_rnn;
		}

		public String getMu_meaoon() {
			return mu_meaoon;
		}

		public void setMu_meaoon(String mu_meaoon) {
			this.mu_meaoon = mu_meaoon;
		}

		public String getMu_ondo() {
			return mu_ondo;
		}

		public void setMu_ondo(String mu_ondo) {
			this.mu_ondo = mu_ondo;
		}

		public String getMu_meat() {
			return mu_meat;
		}

		public void setMu_meat(String mu_meat) {
			this.mu_meat = mu_meat;
		}

		public int getMu_money() {
			return mu_money;
		}

		public void setMu_money(int mu_money) {
			this.mu_money = mu_money;
		}

		public String getMem_id() {
			return mem_id;
		}

		public void setMem_id(String mem_id) {
			this.mem_id = mem_id;
		}

		public String getMem_ps() {
			return mem_ps;
		}

		public void setMem_ps(String mem_ps) {
			this.mem_ps = mem_ps;
		}

		public String getMem_birth() {
			return mem_birth;
		}

		public void setMem_birth(String mem_birth) {
			this.mem_birth = mem_birth;
		}

		public String getMem_name() {
			return mem_name;
		}

		public void setMem_name(String mem_name) {
			this.mem_name = mem_name;
		}

		public String getMem_email() {
			return mem_email;
		}

		public void setMem_email(String mem_email) {
			this.mem_email = mem_email;
		}

		public String getMem_phone() {
			return mem_phone;
		}

		public void setMem_phone(String mem_phone) {
			this.mem_phone = mem_phone;
		}

		public String getCurt_date() {
			return curt_date;
		}

		public void setCurt_date(String curt_date) {
			this.curt_date = curt_date;
		}

		public int getG_scoer() {
			return g_scoer;
		}

		public void setG_scoer(int g_scoer) {
			this.g_scoer = g_scoer;
		}

		public void setReset() {
			g_id = 0;
			g_name = "";
			g_jooso = "";
			g_phone = "";
			g_jumsoo = 0;
			
			// menu 테이블
			mu_id  = 0;
			mu_name = "";
			mu_jong = "";
			mu_rnn = "";
			mu_meaoon = "";
			mu_ondo = "";
			mu_meat = ""; 
			mu_money = 0;
			
			// member 테이블
			mem_id = "";
			mem_ps = "";
			mem_birth = "";
			mem_name = "";
			mem_email = "";
			mem_phone = "";
			
			// curt_menu 테이블
			curt_date = "";
			System.out.println("userinfo.logout");
		}

	   
}
