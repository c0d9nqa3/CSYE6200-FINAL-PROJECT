package Model;

import java.sql.ResultSet;

import Dbutil.SQLHelper;

public class BUserDao {
	public boolean checkBUserPwd(String BUserId, String BUserPwd) {
		boolean flag = false;
		String sql = "select * from partyb_user_info where User_id = '"+BUserId+"'";
		ResultSet rs = SQLHelper.executeQuery(sql);
		String dataPwd;
        try{
            while (rs.next()) {
            	dataPwd=rs.getString(1);
                if(dataPwd.equals(BUserPwd)) {
                	flag=true;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flag;
	}
}
