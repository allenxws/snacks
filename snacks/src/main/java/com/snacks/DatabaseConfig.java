package com.snacks;


import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuwushun on 2016/11/7.
 */
public class DatabaseConfig {
	private static final String url = "jdbc:mysql://localhost:3306/%s?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
	private static final String database = "snacks";
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String username = "root";
	private static final String password = "xuwushun";
	private static final String sourceRoot = "/src/main/resources/database";
	private static final String projectRoot = System.getProperty("user.dir");
	private static final String queryTableName = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = '%s';";
	private static final String showCreateSql = "show create table %s";

	public static void main(String[] args) {
		pull();
		//push();
	}

	public static void push() {
		List<String> toCreate = new ArrayList<String>();
		List<String> toUpdate = new ArrayList<String>();
		List<String> toDelete = new ArrayList<String>();
		String filePath = projectRoot + sourceRoot + "/" + database;
		File directory = new File(filePath);
		if (!directory.isDirectory()) {
			return;
		}
		File[] files = directory.listFiles();
		for (File file : files) {
			String content = readFile(file);

		}
	}

	public static void pull() {
		List<String> tables = getAllTables();
		for (String table : tables) {
			String createSql = showCreateTable(table);
			String filePath = projectRoot + sourceRoot + "/" + database;//+ "/" + table + ".sql";
			writeCreateSqlFileBytable(filePath, createSql, table);
		}
	}

	public static void writeCreateSqlFileBytable(String filePath, String createSql, String table) {
		File directory = new File(filePath);
		if (!directory.exists()) {
			directory.mkdirs();
		}
		File file = new File(filePath + "/" + table + ".sql");
		if (file.exists()) {
			file.delete();
		}
		writeFile(file, createSql);
	}

	public static void writeFile(File file, String content) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(content);
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String readFile(File file) {
		String content = "";
		String line;
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while ((line = bufferedReader.readLine()) != null) {
				content += line;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}

	public static String showCreateTable(String table) {
		String createSql = "";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection(driver, String.format(url, database), username, password);
			statement = connection.createStatement();
			String querySql = String.format(showCreateSql, table);
			resultSet = statement.executeQuery(querySql);
			while (resultSet.next()) {
				createSql = resultSet.getString("create table");
			}
			return createSql;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			doClose(resultSet, statement, connection);
		}
		return createSql;
	}

	public static List<String> getAllTables() {
		List<String> tables = new ArrayList<String>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection(driver, String.format(url, database), username, password);
			statement = connection.createStatement();
			String queryTableSql = String.format(queryTableName, database);
			resultSet = statement.executeQuery(queryTableSql);
			while (resultSet.next()) {
				String tableName = resultSet.getString("TABLE_NAME");
				tables.add(tableName);
			}
			return tables;
		} catch (ClassNotFoundException e) {
			System.out.println("找不到驱动程序类 ，加载驱动失败！");
			e.printStackTrace();
			return tables;
		} catch (SQLException se) {
			System.out.println("数据库连接失败！");
			se.printStackTrace();
			return tables;
		} finally {
			doClose(resultSet, statement, connection);
		}
	}

	public static ResultSet doQuery(String sql) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection(driver, String.format(url, database), username, password);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			return resultSet;
		} catch (ClassNotFoundException e) {
			System.out.println("找不到驱动程序类 ，加载驱动失败！");
			e.printStackTrace();
			return resultSet;
		} catch (SQLException se) {
			System.out.println("数据库连接失败！");
			se.printStackTrace();
			return resultSet;
		} finally {
			doClose(resultSet, statement, connection);
		}
	}

	public static void doClose(ResultSet resultSet, Statement statement, Connection connection) {
		closeResultSet(resultSet);
		closeStatement(statement);
		closeConnection(connection);
	}

	public static void doClose(Statement statement, Connection connection) {
		closeStatement(statement);
		closeConnection(connection);
	}

	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void closeResultSet(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void closeStatement(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static Connection getConnection(String driver, String url, String username, String password) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Class.forName(driver);
		connection = DriverManager.getConnection(url, username, password);
		return connection;
	}
}
