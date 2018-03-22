package com;

import java.util.Scanner;

public class TestJiSuanQI {

public static void main(String[]args){
		System.out.println("请输入您要计算的数据");
		Scanner s = new Scanner(System.in);
		String str = s.next();

		System.out.println(mathString(str));
		
	}
	
	public static String mathString(String str) {

		//获取乘号
		int cheng = str.indexOf("*");

		//获取除号
		int chu = str.indexOf("/");

		//如果乘号的下标不是-1，并且除号不等于-1
		if (cheng != -1 && chu != -1) {
			//如果乘号在前，先算乘法，否则，先算除法
			if (cheng < chu) {
				str = mathCheng(str);
			} else {
				str = mathChu(str);
			}

		} else {
			if (cheng > 0) {
				str = mathCheng(str);
			} else if (chu > 0) {
				str = mathChu(str);
			} else {
				str = mathString2(str);
				return str;
			}
		}

		return mathString(str);
	}
	
	
	public static String mathString2(String str) {

		int jia = str.indexOf("+");

		int jian = str.indexOf("-");

		if (jia != -1 && jian != -1) {
			if (jia < jian) {
				str = mathJia(str);
			} else {
				str = mathJian(str);
			}

		} else {
			if (jia > 0) {
				str = mathJia(str);
			} else if (jian > 0) {
				str = mathJian(str);
			} else {
				return str;
			}
		}

		return mathString2(str);
	}

	public static String mathCheng(String str) {

		String[] strs = str.split("\\*");

		String lastFront = getLastFront(strs);

		String firstRear = getFirstRear(strs);

		double d = Double.parseDouble(lastFront)
				* Double.parseDouble(firstRear);

		str = str.replace(lastFront + "*" + firstRear, d+"");

		return str;

	}
	
	public static String mathChu(String str) {

		String[] strs = str.split("/");

		String lastFront = getLastFront(strs);

		String firstRear = getFirstRear(strs);

		double d = Double.parseDouble(lastFront)
				/ Double.parseDouble(firstRear);

		str = str.replace(lastFront + "/" + firstRear, d+"");

		return str;

	}
	
	public static String mathJia(String str) {

		String[] strs = str.split("\\+");

		String lastFront = getLastFront(strs);

		String firstRear = getFirstRear(strs);

		double d = Double.parseDouble(lastFront)
				+ Double.parseDouble(firstRear);

		str = str.replace(lastFront + "+" + firstRear, d+"");

		return str;

	}
	
	public static String mathJian(String str) {

		String[] strs = str.split("-");

		String lastFront = getLastFront(strs);

		String firstRear = getFirstRear(strs);

		double d = Double.parseDouble(lastFront)
				- Double.parseDouble(firstRear);

		str = str.replace(lastFront + "-" + firstRear, d+"");

		return str;

	}

	private static String getFirstRear(String[] strs) {
		String firstRear;
		String[] s = strs[1].split("\\+");
		s = s[0].split("-");
		s = s[0].split("\\*");
		s = s[0].split("/");

		firstRear = s[0];
		return firstRear;
	}

	private static String getLastFront(String[] strs) {
		String lastFront;
		int jiaIndex = strs[0].indexOf("+");
		int jianIndex = strs[0].indexOf("-");
		if (jiaIndex > jianIndex) {
			String[] fronts = strs[0].split("\\+");
			lastFront = fronts[fronts.length - 1];
		} else if (jiaIndex < jianIndex) {
			String[] fronts = strs[0].split("-");
			lastFront = fronts[fronts.length - 1];
		} else {
			lastFront = strs[0];
		}
		return lastFront;
	}


	
}
