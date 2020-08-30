package com.group.com.artifact;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.commons.lang3.exception.ExceptionUtils;

public class Test {

	public static void main(String[] args) {
		//testCase1();
		testCase2();

	}

	private static void testCase2() {

		int x = 10;

		try {
			int y = 10 / 0;
		} catch (ArithmeticException e) {
			String strace = ExceptionUtils.getStackTrace(e);
			System.out.println(strace);
		}
	}

	private static void testCase1() {
		int x = 10;

		try {
			int y = 10 / 0;
		} catch (ArithmeticException e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			System.out.println(sw.toString());
		}

	}

}
