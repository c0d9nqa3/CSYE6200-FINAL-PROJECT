package Model;

import java.sql.ResultSet;

import Dbutil.SQLHelper;

public class AdminDao {
	public boolean checkAdminPwd(String AdminUserId, String AdminUserPwd) {
		boolean flag = false;
		String sql = "select * from Admin_user_info where User_id = '"+AdminUserId+"'";
		ResultSet rs = SQLHelper.executeQuery(sql);
		String dataPwd;
        try{
            while (rs.next()) {
            	dataPwd=rs.getString(1);
                if(dataPwd.equals(AdminUserPwd)) {
                	flag=true;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flag;
	}
}
