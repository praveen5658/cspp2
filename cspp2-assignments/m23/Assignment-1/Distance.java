/**
 ******************************************************************************
 *                    HOMEWORK, 15-121
 ******************************************************************************
 *                  THE DOCUMENT DISTANCE
 ******************************************************************************
 *
 * The document distance problem is the problem of computing the distance
 * between two given text documents.
 *
 * The distance between two documents is the angle between their word
 * frequency vectors.
 *
 *
 *****************************************************************************/

import java.util.*;
import java.io.*;
import java.net.*;

public class Distance {
	//requirements are defined by provided tests
	//       Test1.java, Test2.java, Test3.java, Test4.java
	private int nolines;
	private int nowords;
	private int nodistinctwords;
	private String[] tokens;
	private String sample;
	private String sampletextfile;
	private HashSet<String> hashset = new HashSet<>();
	private TreeMap<String, Integer> treemap = new TreeMap<>();
	Distance (final String textfile) {
		nolines = 0;
		sampletextfile = textfile.toLowerCase();
		tokens = sampletextfile.split("\\W");
		nowords = tokens.length;
		for (int i = 0; i < tokens.length; i++) {
			hashset.add(tokens[i]);
			// System.out.println(tokens[i]);
		}
		nodistinctwords = hashset.size();
		// System.out.println(hashset);
		int cou = 0;
		// System.out.println(cou);
		Iterator<String> it = hashset.iterator();
		while (it.hasNext()) {
			cou = 0;
			// System.out.println(cou);
			sample = it.next();
			// System.out.println(sample);
			for (int j = 0; j < tokens.length; j++) {
				if (sample.equals(tokens[j])) {
					cou ++;
				}
			}
			// System.out.println(sample);
			// System.out.println(cou);
			treemap.put(sample, cou);
		}
	}
	Distance(final File file) {
		nolines = 0;
		nowords = 0;
		nodistinctwords = 0;
		sampletextfile = "";
		String sam;
		String str = "";
		ArrayList<String> token = new ArrayList<>();
		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNext()) {
				sam = scan.nextLine();
				sampletextfile = sam.toLowerCase();
				// str += sampletextfile;
				sampletextfile = sampletextfile.replaceAll("[^a-zA-Z0-9_]", " ");
				tokens = sampletextfile.split(" ");
				for (int i = 0; (i < tokens.length); i++) {
					if (tokens[i].length() > 0) {
						hashset.add(tokens[i]);
						token.add(tokens[i]);
						nowords ++;
					}
				}
				nolines ++;
			}
			// tokens = sampletextfile.split("\\W");
			// for (int i = 0; ((i < tokens.length) && (tokens[i].length() > 0)); i++) {
			// 	hashset.add(tokens[i]);
			// 	nowords ++;
			// }
			nodistinctwords = hashset.size();
			// System.out.println(hashset);
			int cou = 0;
			// System.out.println(cou);
			Iterator<String> it = hashset.iterator();
			while (it.hasNext()) {
				cou = 0;
				// System.out.println(cou);
				sample = it.next();
				// em.out.println(sample);
				for (int j = 0; j < token.size(); j++) {
					if (sample.equals(token.get(j))) {
						cou ++;
					}
				}
				// System.out.println(sample);
				// System.out.println(cou);
				treemap.put(sample, cou);
			}
		// System.out.println(treemap);
		} catch (FileNotFoundException e) {
			System.out.println("No File Found");
		}
	}
	public int getNumOfLines() {
		return nolines;
	}
	public int getNumOfWords() {
		return nowords;
	}
	public int getNumOfDistinctWords() {
		return nodistinctwords;
	}
	public double norm() {
		Iterator<String> it1 = hashset.iterator();
		int sum = 0;
		while (it1.hasNext()) {
			sample = it1.next();
			// System.out.println(sample);
			sum += Math.pow((int)treemap.get(sample), 2);
			// System.out.println(sum);
		}
		return Math.sqrt(sum);
	}
	public TreeMap getMap() {
		return treemap;
	}
	public double innerProduct(final TreeMap other) {
		String key1;
		double val = 0.0;
		for (Map.Entry<String, Integer> entry : treemap.entrySet()) {
			key1 = entry.getKey();
			if (other.containsKey(key1)) {
				// System.out.println(other.get(key1));
				val += (treemap.get(key1) * (int)other.get(key1));
			}
		}
		return val;
	}
	public double angle(final TreeMap other) {
		double val = innerProduct(other);
		Object[] values = (other.values()).toArray();
		int k = 0;
		for (int i = 0; i < values.length; i++) {
			k += Math.pow((int)values[i], 2);
		}
		// System.out.println(val);
		// System.out.println(norm());
		// System.out.println(Math.sqrt(k));
		return (val / (norm() * Math.sqrt(k)));
	}
}