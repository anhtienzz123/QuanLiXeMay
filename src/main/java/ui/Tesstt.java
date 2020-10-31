package ui;

import java.sql.SQLException;

import dao.DongXeDao;
import db.DatabaseConnect;

public class Tesstt {

	public static void main(String[] args) throws SQLException {
		DatabaseConnect.connect();
		DongXeDao dongXeDao = DongXeDao.getInstance();
		System.out.println(dongXeDao.getDongXes());

	}

}
