package assignment02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class AssignmentTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String exit = "";
		do {
			System.out.println(
					"Select the number to execute the function : \n1. Function 1\n2. Function 2\n3. Function 3\n4. Function 4\n5. Function 5\n6. Function 6");
			String s = sc.next();
			switch (s) {
			case "1": {
				System.out.println("Function 1");
				ArrayList<String> S1 = new ArrayList<>();
				System.out.print("Enter the number of strings to be stored in Function 1 : ");
				int n1 = sc.nextInt();
				for (int i = 0; i < n1; i++) {
					S1.add(sc.next());
				}
				System.out.println("Input (S1): " + S1);
				countOfString(S1);
				break;
			}
			case "2": {
				System.out.println("Function 2");
				ArrayList<String> S2 = new ArrayList<>();
				System.out.print("Enter the number of strings to be stored in Function 2 : ");
				int n2 = sc.nextInt();
				for (int i = 0; i < n2; i++) {
					S2.add(sc.next());
				}
				System.out.println("Input (S1): " + S2);
				System.out.println("Output (M1): " + stringConcatenation(S2) + "\n");
				break;
			}
			case "3": {
				System.out.println("Function 3");
				ArrayList<Integer> A1 = new ArrayList<>();
				System.out.print("Enter the number of values to be stored in Function 3 : ");
				int n3 = sc.nextInt();
				for (int i = 0; i < n3; i++) {
					A1.add(sc.nextInt());
				}
				System.out.println("Input (A1): " + A1);
				integerIncrement(A1);
				break;
			}
			case "4": {
				System.out.println("Function 4");
				ArrayList<String> A2 = new ArrayList<>();
				System.out.print("Enter the number of strings to be stored in Function 4 : ");
				int n4 = sc.nextInt();
				for (int i = 0; i < n4; i++) {
					A2.add(sc.next());
				}
				System.out.println("Input (A1): " + A2);
				System.out.println("Output (A2): " + strDistinct(A2));
				break;
			}
			case "5": {
				System.out.println("Function 5");
				ArrayList<String> A = new ArrayList<>();
				System.out.print("Enter the number of strings to be stored in Function 5 : ");
				int n5 = sc.nextInt();
				for (int i = 0; i < n5; i++) {
					A.add(sc.next());
				}
				System.out.println("Input : " + A);
				System.out.println("Output : " + strFirstLast(A));
				break;
			}
			case "6": {
				System.out.println("Function 6");
				ArrayList<String> A2 = new ArrayList<>();
				System.out.print("Enter the number of strings to be stored in Function 6 : ");
				int n6 = sc.nextInt();
				for (int i = 0; i < n6; i++) {
					A2.add(sc.next());
				}
				System.out.println("Input (S1): " + A2);
				System.out.println("Output(M1): " + strRepeat(A2));
				break;
			}
			default: {
				System.out.println("Please enter the correct one.\n");
			}
			}
			System.out.print("If you want to stop execution type exit : ");
			exit = sc.next();
			System.out.println();
		} while (!exit.equalsIgnoreCase("exit"));
		sc.close();
	}

	public static void countOfString(ArrayList<String> S1) {
		Map<String, Integer> M = new HashMap<>();
		for (int i = 0; i < S1.size(); i++) {
			int count = Collections.frequency(S1, S1.get(i));
			M.put(S1.get(i), count);
		}
		System.out.println("Output : " + M + "\n");
	}

	public static Map<Character, String> stringConcatenation(ArrayList<String> S1) {
		Map<Character, String> M1 = new HashMap<>();
		for (int i = 0; i < S1.size(); i++) {
			String val = S1.get(i);
			if (M1.containsKey(S1.get(i).charAt(0))) {
				M1.computeIfPresent(val.charAt(0), (K1, V1) -> V1 = V1 + val);
			} else {
				M1.put(S1.get(i).charAt(0), S1.get(i));
			}
		}
		return M1;
	}

	public static void integerIncrement(ArrayList<Integer> A1) {
		Set<Integer> S = new HashSet<>();
		System.out.print("Output (S): [");
		for (int i = 0; i < A1.size(); i++) {
			int v = A1.get(i);
			if (S.contains(v)) {
				while (S.contains(v)) {
					v++;
				}
				S.add(v);
			} else {
				S.add(v);
			}
			System.out.print(v);
			if (i != A1.size() - 1) {
				System.out.print(",");
			}
		}
		System.out.println("]");
	}

	public static ArrayList<String> strDistinct(ArrayList<String> A1) {
		ArrayList<String> A2 = new ArrayList<>();
		for (int i = 0; i < A1.size(); i++) {
			char c[] = A1.get(i).toCharArray();
			Map<Character, Integer> map = new HashMap<>();
			String str = "";
			for (int j = 0; j < c.length; j++) {
				if (!map.containsKey(c[j])) {
					str += c[j];
					map.put(c[j], 1);
				}
			}
			A2.add(str);
		}
		return A2;
	}

	public static Map<String, String> strFirstLast(ArrayList<String> A) {
		Map<String, String> M = new HashMap<>();
		for (int i = 0; i < A.size(); i++) {
			String first = Character.toString(A.get(i).charAt(0));
			String last = Character.toString(A.get(i).charAt(A.get(i).length() - 1));
			if (M.containsKey(first)) {
				M.computeIfPresent(first, (K1, V1) -> V1 = last);
			} else {
				M.put(first, last);
			}
		}
		return M;
	}

	public static Map<String, Boolean> strRepeat(ArrayList<String> S1) {
		Map<String, Boolean> M1 = new HashMap<>();
		for (int i = 0; i < S1.size(); i++) {
			if (M1.containsKey(S1.get(i))) {
				M1.computeIfPresent(S1.get(i), (K1, V1) -> V1 = true);
			} else {
				M1.put(S1.get(i), false);
			}
		}
		return M1;
	}
}


	


