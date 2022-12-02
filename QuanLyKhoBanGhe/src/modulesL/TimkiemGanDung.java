package modulesL;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.regex.Pattern;

import BanGhe1_2.BanGhe;
import BanGhe1_2.User;

public class TimkiemGanDung {
	public static String unAccent(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("").replaceAll("Đ", "D").replace("đ", "d");
	}
	public static ArrayList<BanGhe> TimGanDung(ArrayList<BanGhe> a, String c) {
		ArrayList<BanGhe> found = new ArrayList<BanGhe>();
		ArrayList<Integer> foundPer = new ArrayList<Integer>();
		
		c = unAccent(c);
		c = c.toUpperCase();
		String b = "";
		for (int i = 0 ;i < c.length();i++) {
			if (c.charAt(i) == ' ' && c.charAt(i+1) != ' ')
				b += c.charAt(i);
			else if (c.charAt(i) != ' ') b += c.charAt(i);
		}
		System.out.println("Vua nhap: " + b);
		for (int i = 0;i < a.size();i++) {
			String ctString = a.get(i).getTensp(); 
			ctString = unAccent(ctString);
			ctString = ctString.toUpperCase();
			int dem = 0, chB = 0;
			boolean wait = false;
			for (int j = 0;j < ctString.length();j++) {
				if (b.charAt(chB) == ctString.charAt(j) && !wait) {dem++;chB++;} 
				else if (chB == 0) wait = true;
				else if (b.charAt(chB-1) == ' ' && b.charAt(chB) != ' ') wait = true;
				else {
					wait = true;
					while (chB < b.length()) {
						if (b.charAt(chB) != ' ') chB++;
						else {
							while (chB < b.length()) {
								if (b.charAt(chB) == ' ') chB++;
								else break;
							} 
							break;
						}
					}
				}
				if (ctString.charAt(j) == ' ' && ctString.charAt(j+1) != ' ' && wait) wait = false;
				if (chB >= b.length()) break;
			}
			if (b.length() > 1) {
				if (dem >= 2) {
					found.add(a.get(i));
					foundPer.add(dem);
				}
			} else if (dem > 0) {
				found.add(a.get(i));
				foundPer.add(dem);
			}
			System.out.println(ctString + "\t" + dem);
		}
		for (int i = 0;i < found.size()-1;i++) {
			for (int j= i+1;j < found.size();j++) {
				if (foundPer.get(i) < foundPer.get(j)) {
					int t = foundPer.get(i);
					BanGhe t1 = new BanGhe(); 
					t1 = found.get(i);
					
					foundPer.set(i, foundPer.get(j));
					found.set(i, found.get(j));
					
					foundPer.set(j, t);
					found.set(j, t1);
				}
			}
		}
		return found;
	}
	public static ArrayList<User> TimUserGanDung(ArrayList<User> a, String c) {
		ArrayList<User> found = new ArrayList<User>();
		ArrayList<Integer> foundPer = new ArrayList<Integer>();
		
		c = unAccent(c);
		c = c.toUpperCase();
		String b = "";
		for (int i = 0 ;i < c.length();i++) {
			if (c.charAt(i) == ' ' && c.charAt(i+1) != ' ')
				b += c.charAt(i);
			else if (c.charAt(i) != ' ') b += c.charAt(i);
		}
		System.out.println("Vua nhap: " + b);
		for (int i = 0;i < a.size();i++) {
			String ctString = a.get(i).getUsername(); 
			ctString = unAccent(ctString);
			ctString = ctString.toUpperCase();
			int dem = 0, chB = 0;
			boolean wait = false;
			for (int j = 0;j < ctString.length();j++) {
				if (b.charAt(chB) == ctString.charAt(j) && !wait) {dem++;chB++;} 
				else if (chB == 0) wait = true;
				else if (b.charAt(chB-1) == ' ' && b.charAt(chB) != ' ') wait = true;
				else {
					wait = true;
					while (chB < b.length()) {
						if (b.charAt(chB) != ' ') chB++;
						else {
							while (chB < b.length()) {
								if (b.charAt(chB) == ' ') chB++;
								else break;
							} 
							break;
						}
					}
				}
				if (ctString.charAt(j) == ' ' && ctString.charAt(j+1) != ' ' && wait) wait = false;
				if (chB >= b.length()) break;
			}
			if (b.length() > 1) {
				if (dem >= 2) {
					found.add(a.get(i));
					foundPer.add(dem);
				}
			} else if (dem > 0) {
				found.add(a.get(i));
				foundPer.add(dem);
			}
			System.out.println(ctString + "\t" + dem);
		}
		for (int i = 0;i < found.size()-1;i++) {
			for (int j= i+1;j < found.size();j++) {
				if (foundPer.get(i) < foundPer.get(j)) {
					int t = foundPer.get(i);
					User t1 = new User(); 
					t1 = found.get(i);
					
					foundPer.set(i, foundPer.get(j));
					found.set(i, found.get(j));
					
					foundPer.set(j, t);
					found.set(j, t1);
				}
			}
		}
		return found;
	}
	
	public static ArrayList<User> TimHotenGanDung(ArrayList<User> a, String c) {
		ArrayList<User> found = new ArrayList<User>();
		ArrayList<Integer> foundPer = new ArrayList<Integer>();
		
		c = unAccent(c);
		c = c.toUpperCase();
		String b = "";
		for (int i = 0 ;i < c.length();i++) {
			if (c.charAt(i) == ' ' && c.charAt(i+1) != ' ')
				b += c.charAt(i);
			else if (c.charAt(i) != ' ') b += c.charAt(i);
		}
		System.out.println("Vua nhap: " + b);
		for (int i = 0;i < a.size();i++) {
			String ctString = a.get(i).getHoten(); 
			ctString = unAccent(ctString);
			ctString = ctString.toUpperCase();
			int dem = 0, chB = 0;
			boolean wait = false;
			for (int j = 0;j < ctString.length();j++) {
				if (b.charAt(chB) == ctString.charAt(j) && !wait) {dem++;chB++;} 
				else if (chB == 0) wait = true;
				else if (b.charAt(chB-1) == ' ' && b.charAt(chB) != ' ') wait = true;
				else {
					wait = true;
					while (chB < b.length()) {
						if (b.charAt(chB) != ' ') chB++;
						else {
							while (chB < b.length()) {
								if (b.charAt(chB) == ' ') chB++;
								else break;
							} 
							break;
						}
					}
				}
				if (ctString.charAt(j) == ' ' && ctString.charAt(j+1) != ' ' && wait) wait = false;
				if (chB >= b.length()) break;
			}
			if (b.length() > 1) {
				if (dem >= 2) {
					found.add(a.get(i));
					foundPer.add(dem);
				}
			} else if (dem > 0) {
				found.add(a.get(i));
				foundPer.add(dem);
			}
			System.out.println(ctString + "\t" + dem);
		}
		for (int i = 0;i < found.size()-1;i++) {
			for (int j= i+1;j < found.size();j++) {
				if (foundPer.get(i) < foundPer.get(j)) {
					int t = foundPer.get(i);
					User t1 = new User(); 
					t1 = found.get(i);
					
					foundPer.set(i, foundPer.get(j));
					found.set(i, found.get(j));
					
					foundPer.set(j, t);
					found.set(j, t1);
				}
			}
		}
		return found;
	}
}
