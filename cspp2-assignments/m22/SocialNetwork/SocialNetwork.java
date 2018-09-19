import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Arrays;
class User {
	private String[] values;
	private String key;
	User(final String k, final String[] val) {
		key = k;
		values = val;
	}
	public String getKey() {
		return key;
	}
	public String[] getValues() {
		return values;
	}
	public void setValues(final String[] val) {
		int len = values.length + val.length;
		String[] sample = new String[len];
		int i = 0;
		for (i = 0; i < values.length; i++) {
			sample[i] = values[i];
		}
		for (int j = 0; j < val.length; j++) {
			sample[i] = val[j];
			i++;
		}
		values = sample;
	}
	public String toString() {
		String s = "[";
		int i = 0;
		for (i = 0; i < values.length - 1; i++) {
			s += values[i] + ", ";
		}
		s += values[i] + "]";
		return s;
	}
}
public class SocialNetwork {
	private static ArrayList<User> user = new ArrayList<>();
	private SocialNetwork() {
	}
	public static void main(final String[] args) {
		// 	File f = new File("SocialNetwork.txt");
		Scanner scan = new Scanner(System.in);
		String line;
		String trimmedline;
		String[] tokens;
		String[] tokenvalues;
		String[] first = scan.nextLine().split(" ");
		int n = Integer.parseInt(first[1]);
		while (n != 0) {
			line = scan.nextLine();
			trimmedline = line.substring(0, line.length() - 1);
			tokens = trimmedline.split(" is connected to ");
			tokenvalues = tokens[1].split(", ");
			user.add(new User(tokens[0], tokenvalues));
			n--;
		}
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			tokens = s.nextLine().split(" ");
			switch (tokens[0]) {
			case "getConnections":
				getConnections(tokens[1]);
				break;
			case "addConnections":
				addConnections(tokens[1], tokens[2].split(","));
				break;
			case "commonConnections":
				getConnections(tokens[1], tokens[2]);
				break;
			case "Network":
				printNetwork();
				break;
			default:
				break;
			}
		}
		// for (int i = 0; i < user.size(); i++) {
		// 	System.out.println(user.get(i));
		// }
	}
	public static void getConnections(final String key) {
		int k = 0;
		for (int i = 0; i < user.size(); i++) {
			if (user.get(i).getKey().equals(key)) {
				System.out.println(user.get(i));
				k++;
				break;
			}
		}
		if (k == 0) {
			System.out.println("Not a user in Network");
		}
	}
	public static void getConnections(final String k1, final String k2) {
		String[] commonvalues = new String[10];
		String[] values1 = new String[10];
		String[] values2 = new String[10];
		int len1 = 0;
		int len2 = 0;
		for (int i = 0; i < user.size(); i++) {
			if (user.get(i).getKey().equals(k1)) {
				len1 = user.get(i).getValues().length;
				values1 = user.get(i).getValues();
			}
			if (user.get(i).getKey().equals(k2)) {
				len2 = user.get(i).getValues().length;
				values2 = user.get(i).getValues();
			}
		}
		int m = 0;
		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				if (values1[i].equals(values2[j])) {
					commonvalues[m] = values1[i];
					m++;
				}
			}
		}
		if (m == 0) {
			System.out.println("[]");
		} else {
			String s = "[";
			int i = 0;
			for (i = 0; i < m - 1; i++) {
				s += commonvalues[i] + ", ";
			}
			s += commonvalues[i] + "]";
			System.out.println(s);
		}
	}
	public static void addConnections(final String k, final String[] val) {
		int k1 = 0;
		for (int i = 0; i < user.size(); i++) {
			if ((user.get(i).getKey()).equals(k)) {
				user.get(i).setValues(val);
				k1++;
				break;
			}
		}
		if (k1 == 0) {
			System.out.println("Not a user in Network");
		}
	}
	public static void printNetwork() {
		String[] users = new String[30];
		String str = new String();
		for (int i = 0; i < user.size(); i++) {
			users[i] = user.get(i).getKey();
		}
		Arrays.sort(users, 0, user.size() - 1);
		for (int i = 0;i<user.size();i++) {
			for (int j = 0; j< user.size();j++) {
				if (users[i].equals(user.get(j).getKey())) {
					str += users[i] + ": " + user.get(j).toString() + ", ";
					break;
				}
			}
		}
		String st = str.substring(0, str.length() - 2);
		System.out.println(st);
	}
}