package com.techelevator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SalesAuditLog {

	File logFile = new File("Log.txt");
	DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	Date dateobj = new Date();
	String prodName = null;
	Double transactionBalance = 0.00;
	Double machineBalance = 0.00;

	public void logMethod(String prodName, Double transactionBalance, Double machineBalance) throws IOException {
		
		logFile.createNewFile(); //create new file
		Calendar loggerCalendar = Calendar.getInstance();

		try (PrintWriter out = new PrintWriter(new FileOutputStream(logFile, true))) {
			this.prodName = prodName;
			this.transactionBalance = transactionBalance;
			this.machineBalance = machineBalance;

			out.append(df.format(loggerCalendar.getTime()) + " " + prodName + " : $" + transactionBalance + "     "
					+ machineBalance + "\n");
		}
	}
}