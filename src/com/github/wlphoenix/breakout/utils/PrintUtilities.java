package com.github.wlphoenix.breakout.utils;


public class PrintUtilities {


	public static final boolean LOGGING_ON = true;
	
	public static void logPrint(String s) {
		if(LOGGING_ON)
			System.out.print(s);
	}
	
	public static void logPrintln(String s) {
		if(LOGGING_ON)
			System.out.println(s);
	}
	
	public static void logPrintln() {
		if(LOGGING_ON)
			System.out.println();
	}
	
}
