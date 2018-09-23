import java.util.*;
import java.io.*;
class Plagiarism {

    private List<String> documentList;

    public Plagiarism() {
        documentList = new List<String>();
    }

    public List<String> getDocumentList() {
        return this.documentList;
    }
    public void setDocumentList(List<String> document) {
        this.documentList = document;
    }
    public String toString(File filename) throws Exception {
        String s = "";
        Scanner sc = new Scanner(new FileReader(filename));
        StringBuffer sb = new StringBuffer();
        while(sc.hasNext()) {
            sb.append(sc.nextLine());
            // sb.append(" ");
        }
        sc.close();
        s = sb.toString();
        return s;
    }
    // public void addDocument(String doc) {
    //  documentList.add(doc);
    // }
    public int bagOfWords(String doc, String doc1) throws Exception {
        Hashtable<String, Integer> ht1 = count(doc);
        Hashtable<String, Integer> ht2 = count(doc1);
        int dotproduct = dotProduct(ht1, ht2);
        // System.out.println(ht2);
        // System.out.println(dotproduct);
        int sqrt = eculidean(ht1);
        // System.out.println(sqrt);
        int sqrt1 = eculidean(ht2);
        // System.out.println(sqrt1);
        double res = (dotproduct / Math.sqrt(sqrt * sqrt1)) * 100;
        // System.out.println(res);
        return (int) Math.round(res);
    }
    public int dotProduct(Hashtable<String, Integer> ht1, Hashtable<String, Integer> ht2 ) {
        int product = 0;
        for (String element : ht1.keySet()) {
            for(String element1 : ht2.keySet()) {
                if(element.equals(element1)){
                    product += ht1.get(element) * ht2.get(element);
                }
            }
        }
        return product;
    }


    public int eculidean(Hashtable<String, Integer> ht) {
        int sum = 0;
        for (String element : ht.keySet()) {
            sum += Math.pow(ht.get(element), 2);
        }
        // System.out.println("sum" + sum);
        // double sq = Math.sqrt(sum);
        return sum;
    }


    public List<String> loadStopWords() throws Exception {
        List<String> stopWordsList = new List<String>();
        Scanner scan = new Scanner(new File("stopwords.txt"));
        while(scan.hasNext()) {
            String line = scan.nextLine();
            stopWordsList.add(line);
        }
        return stopWordsList;
    }


    public List<String> removeStopWords(String[] tokens) throws Exception {
        List<String> resWords = new List<String>();
        List<String> stopWords = loadStopWords();
        for(String word : tokens) {
            if (!stopWords.contains(word)) {
                resWords.add(word);
            }
        }
        return resWords;
    }
    public Hashtable<String, Integer> count(String doc) throws Exception {
        Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
        doc = doc.toLowerCase();
        String token = doc.replaceAll("[^a-zA-Z0-9_]", " ");
        // System.out.println(token);
        String[] tokens = token.split(" ");
        // List<String> wrdList = removeStopWords(tokens);
        List<String> resWords = new List<String>();
        for(String word : tokens) {
            if(word.length() != 0) {
                resWords.add(word);
            }
        }
        // System.out.println(resWords);
        for (int i = 0;i < resWords.size(); i++) {
            if (ht.containsKey(resWords.get(i))) {
                ht.put(resWords.get(i), ht.get(resWords.get(i)) + 1);
            } else {
                ht.put(resWords.get(i), 1);
            }
        }
        return ht;
    }
    public void print(double[][] matrix, File[] listFiles) {
        StringBuffer sb = new StringBuffer();
        long maxval = 0;
        String file1 = "";
        String file2 = "";
        int space = 0;
        sb.append("             ");
        for(int i = 0; i < listFiles.length-1; i++) {
            sb.append(listFiles[i].getName() + "    ");
        }
        sb.append(listFiles[listFiles.length - 1].getName() + " \n");
        for(int i = 0; i < listFiles.length - 1; i++) {
            sb.append(listFiles[i].getName() + "    ");
            for(int k = 0; k < listFiles.length - 1; k++) {
                space = String.valueOf((double)Math.round(matrix[i][k])).length();
                space = 9 - space;
                for (int m = 0; m< space;m++) {
                    sb.append(" ");
                }
                sb.append((double)Math.round(matrix[i][k]) + "    ");
            }
            space = String.valueOf((double)Math.round(matrix[i][listFiles.length - 1])).length();
                space = 9 - space;
                for (int m = 0; m< space;m++) {
                    sb.append(" ");
                }
                sb.append((double)Math.round(matrix[i][listFiles.length - 1])+ " ");
            sb.append("\n");
        }
        sb.append(listFiles[listFiles.length - 1].getName() + "    ");
        for(int k = 0; k < listFiles.length - 1; k++) {
            space = String.valueOf((double)Math.round(matrix[listFiles.length - 1][k])).length();
            space = 9 - space;
                for (int m = 0; m< space;m++) {
                    sb.append(" ");
                }
            sb.append((double)Math.round(matrix[listFiles.length - 1][k]) + "    ");
        }
        space = String.valueOf((double)Math.round(matrix[listFiles.length - 1][listFiles.length - 1])).length();
        space = 9 - space;
                for (int m = 0; m< space;m++) {
                    sb.append(" ");
                }
        sb.append((double)Math.round(matrix[listFiles.length - 1][listFiles.length - 1]) + " ");
        System.out.println(sb.toString());
        for (int i = 0;i< listFiles.length;i++) {
            for (int j = 0;j< listFiles.length;j++) {
                if (!(listFiles[i].getName().equals(listFiles[j].getName()))) {
                    if (maxval < Math.round(matrix[i][j])) {
                        maxval = Math.round(matrix[i][j]);
                        file1 = listFiles[i].getName();
                        file2 = listFiles[j].getName();
                    }
                }
            }
        }
        System.out.println("Maximum similarity is between " + file1 + " and " + file2);
    }
    public static int longestSubstring(String s1, String s2) {
        // System.out.println("in method");
        int m = s1.length();
        // System.out.println(m);
        int n = s2.length();
        // System.out.println(n);
        s1 = s1.replaceAll("[ ]", "");
        s2 = s2.replaceAll("[ ]", "");
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int res = 0;
        int[][] LCS = new int[c1.length + 1][c2.length + 1];
        for(int i=0; i <= c1.length; i++){
            for(int j=0; j <= c2.length; j++){
                if(i == 0 || j == 0){
                    LCS[i][j]=0;
                }else if (c1[i-1] == c2[j-1]) {
                    LCS[i][j] = LCS[i-1][j-1]+1;
                    res = Math.max(res, LCS[i][j]);
                }
                else {
                    LCS[i][j] = 0;
                }

            }
        }
        System.out.println(res);
        float sum = m + n;
        System.out.println(sum);
        float res1 = (res * 2);
        System.out.println(res1);
        float res2 = res1 / sum;
        System.out.println(res2);
        float res3 = res2 * 100;
        System.out.println(res3);
        int val = (int) res2;
        System.out.println(val);
        return val;
    }
}