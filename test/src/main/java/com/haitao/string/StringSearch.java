/**
 * 
 */
package com.haitao.string;

import java.util.HashSet;
import java.util.Set;


/**
 * @author huoht
 *
 */
public class StringSearch {

	public static boolean hasString(String[] strs,String targetStr){
		for(String s0 : strs){
			if(s0.indexOf(targetStr)<0)  return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] s = new String[]{"abcxcde","3abc24cde3","abc3d24cde3","sdcdeafsabcs"};
		String minStr = s[0];
		for(String s0 : s){
			if(minStr.length()<=s0.length()) continue;
			minStr = s0;
		}
		char[] cs = minStr.toCharArray();
		Set<String> rs = new HashSet<String>();
		StringBuilder ss = new StringBuilder();
		for(int i=0;i<cs.length;i++){
			ss.append(cs[i]);
			for(int j=i+1;j<cs.length;j++){
				ss.append(cs[j]);
				if(!hasString(s, ss.toString())) break;
				rs.add(ss.toString());
			}
			ss.setLength(0);
		}
		System.out.println("匹配到的公共字符串:"+rs.toString());
		int maxLen = 0;
		for(String s1 : rs){
			int len = s1.length();
			if(len<=maxLen) continue;
			maxLen = len;
		}
		Set<String> srs = new HashSet<String>();
		for(String s2 : rs){
			if(s2.length()<maxLen) continue;
			srs.add(s2);
		}
		System.out.println("最长公共字符串："+srs);
	}
}
