import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class sjfld {
	
	public static void main(String args[]) {
		
		Connection con=DBInfo.con;
		try {
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery("select * from BookData");
			System.out.print(rs);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
