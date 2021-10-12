package fr.doranco.projetFinal.utils;

import java.text.SimpleDateFormat;

public final class Dates {

	private static final String formatDate = "dd/MM/yyyy";
	
	private Dates() {
	}
	
	public static final java.util.Date stringToDateUtil(String dateStr) throws Exception {
		
		SimpleDateFormat formatter = new SimpleDateFormat(formatDate);
		return formatter.parse(dateStr);
	}

	public static final String dateUtilToString(java.util.Date dateUtil) {
		
		SimpleDateFormat formatter = new SimpleDateFormat(formatDate);
		return formatter.format(dateUtil);
	}

	public final static java.util.Date dateSqlToUtil(java.sql.Date dateSql) {
		
		return new java.util.Date(dateSql.getTime());
	}
	
	public final static java.sql.Date dateUtilToSql(java.util.Date dateUtil) {
		
		return new java.sql.Date(dateUtil.getTime());
	}
}
