package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Queries {

	Connection con = model.Connection.getCon();
	String query;
	int resSignUp = -1;

	public boolean signUp(String userName, String password) {

		query = "insert into login_details values(?,?)";
		boolean status = false;
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(query);
			pst.setString(1, userName);
			pst.setString(2, password);

			resSignUp = pst.executeUpdate();

			return status = (resSignUp == 1);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean signIn(String userName, String password) {

		query = "select * from login_details where username = ? AND password = ?";
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(query);
			pst.setString(1, userName);
			pst.setString(2, password);

			ResultSet rs = pst.executeQuery();

			if (rs.next())
				return true;

			return false;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}
}
