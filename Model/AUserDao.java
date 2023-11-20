package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Dbutil.SQLHelper;
public class AUserDao {
	public boolean checkAUserPwd(String AUserId, String AUserPwd) {
		boolean flag = false;
		String sql = "select * from partya_user_info where User_id = '"+AUserId+"'";
		ResultSet rs = SQLHelper.executeQuery(sql);
		String dataPwd;
        try{
            while (rs.next()) {
            	dataPwd=rs.getString(1);
                if(dataPwd.equals(AUserPwd)) {
                	flag=true;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flag;
	}
}
