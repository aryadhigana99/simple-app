package com.example.mys.util;

import java.util.ArrayList;
import java.util.List;

public class HttpUtil {

	public static List<String> getHeaderList() {
		List<String> headerlist = new ArrayList<>();
		headerlist.add("Content-Type");
		headerlist.add(" Accept");
		headerlist.add("X-Requested-With");
		headerlist.add("Authorization");
		return headerlist;
	}

	public static List<String> getExposeList() {
		List<String> exposeList = new ArrayList<>();
		exposeList.add("Authorization");
		return exposeList;
	}
	
}
