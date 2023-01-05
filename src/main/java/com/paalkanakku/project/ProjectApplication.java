package com.paalkanakku.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.*;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(ProjectApplication.class, args);

//		SimpleDateFormat inputFormat = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss 'GMT'Z (zzzz)");
//
//		// Parse the input date string
//		Date date = inputFormat.parse("Thu Dec 29 2022 00:00:00 GMT+0530 (India Standard Time)");
//
//		System.out.println(date);

//		String date1 = new SimpleDateFormat("dd-MM-yyyy").format(date);
//		System.out.println(date1);


//		List<String> s = Arrays.asList("karan", "kumar");
//		s.stream().forEach(i -> System.out.println(i));
//
//		String date = "2022-12-28T18:30:00.000Z";
//		SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//		Date result = sdt.parse(date);
//		System.out.println(result);
//		String date1 = new SimpleDateFormat("dd-MM-yyyy").format(result);
//		System.out.println(date1);


//		StringBuilder builder = new StringBuilder();
//		StringBuilder numerics = new StringBuilder();
//		String ss = "99999";
//		System.out.println(ss.charAt(0));
//		char ind = 0;
//		String sp[] = ss.split("0");
//		for(int s=0; s<ss.length(); s++) {
//			if(ss.charAt(s)!= '0') {
//				builder.append(ss.charAt(s));
//				ind = ss.charAt(s);
//				System.out.println("ind " + ind);
//				break;
//			}
//		}
//        int x = ss.indexOf(ind);
//		int xy = Integer.parseInt(ss.substring(x)) + 1;
//		String finalf = String.valueOf(xy);
//		StringBuilder bu = new StringBuilder();
//		if(finalf.length() == 1) {
//			bu.append("0000");
//			bu.append(finalf);
//		} else if(finalf.length() == 2) {
//			bu.append("000");
//			bu.append(finalf);
//		}else if(finalf.length() == 3) {
//			bu.append("00");
//			bu.append(finalf);
//		}else if(finalf.length() == 4) {
//			bu.append("0");
//			bu.append(finalf);
//		} else {
//			bu.append(finalf);
//		}
//		System.out.println("substring  " + bu);
//
//		String s = null;
//
//		for(int i =0; i < 100 ; i++) {
//			if( i == 2) {
//				System.out.println(i);
//				break;
//			}
//		}
//		System.out.println("breaked for loop");
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
//		String d = sdf.format(new Date());
//
//		Instant instant = Instant.parse("2017-02-17T09:28:03.000Z");
//		Date da = Date.from(instant);
//
//		String filename = new SimpleDateFormat("yyyyMMddHHmm'.json'").format(new Date());
//		System.out.println(da);
//		System.out.println(d);
//
//		String aString="JUST_A_TEST_STRING";
//		String result = UUID.nameUUIDFromBytes(aString.getBytes()).toString();
//		System.out.println(result);
//
//		String aString1="JUST_A_TEST_STRING";
//		String result1 = UUID.nameUUIDFromBytes(aString.getBytes()).toString();
//		System.out.println(result1);

	}

}
