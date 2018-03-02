package com.codejam.google._2016_.qualification.round;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class CountingSheep {
	
	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\eclipse-workspace\\JavaProject\\src\\com\\codejam\\google\\_2016_\\qualification\\round\\A-large-practice.in"))) {
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				int numOfTcs = Integer.valueOf(sCurrentLine);
				for(int i=0; i<numOfTcs; i++) {
					int res = checkIfASheepCanSleep(Integer.valueOf(br.readLine()));
					System.out.println("Case #"+(i+1)+": " + (res==-1?"INSOMNIA":res));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int numOfTcs = scr.nextInt();
		scr.nextLine();
		for(int i=0; i<numOfTcs; i++) {
			int res = checkIfASheepCanSleep(scr.nextInt());
			System.out.println("Case #"+(i+1)+": " + (res==-1?"INSOMNIA":res));
		}
	}*/

	private static int checkIfASheepCanSleep(int num) {
		int res = -1;
		if (num!=0) {
			HashSet<Integer> numList = new HashSet<Integer>();
			for (int i = 0; i <= 9; i++)
				numList.add(i);
			int temp = num;
			for (int j = 1; numList.size() > 0; j++) {
				temp = num * j;
				res = temp;
				while (temp != 0) {
					if (numList.contains(temp % 10)) {
						numList.remove(temp % 10);
					}
					temp = temp / 10;
				}
			} 
		}
		return res;
	}
}
