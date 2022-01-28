import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;
import java.io.File;
public class Huffman {
    static String[] actualHuffmanCode = new String[7];
    //holds huffman codes to test against generated huffman codes
    ArrayList<String> generatedHuffmanCode = new ArrayList<>();
    //holds generated huffman codes to see if they are correct.
    static int tmp;
    //placeholder for int value
    static char temp;
    //placeholder for character value
    static TreeMap<Character, Integer> freq = new TreeMap<Character, Integer>();
    //holds characters and frequencies in nice k,v pairs
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("C:/Users/Rachel/Documents/test.txt"));
        /**The table must be in a text file, I cannot get it to read the tables in microsoft word.
         * The text file looks like this:
         * ‘A’  .36	0
         * ‘B’  .19	111
         * ‘C’  .16	101
         * ‘D’  .12	100
         * ‘T’  .08	1100
         * ‘E’  .06	11011
         * ‘F’  .03	11010 */
        int j = 0;
        //allows for incrementing of array that hold the encoding.
        while(scan.hasNext()){
            String[] c = scan.nextLine().split("\\s");
            //splits whitespace.
            temp = c[0].charAt(1);
            //holds character
            tmp= (int)(Double.parseDouble(String.valueOf(c[2])) * 100);
            //multiplies by 100 and casts to int for proper encoding.
            actualHuffmanCode[j] = String.valueOf(c[3]);
            //holds actual huffman encoding to be later checked.
            j++;
            freq.put(temp,tmp);
            //puts this key, value pair in a hashmap

        }
       Huffman h = new Huffman();
       h.buildTree();
       if(h.isValidEncoding()){
           System.out.println("This Huffman Code is correct");
       }
    }
    public class huffmanNode implements Comparable<huffmanNode>{
        //creates a huffman node
        int frequency;
        huffmanNode left, right;
        Character c;
        @Override
        public int compareTo(huffmanNode o) {

            return (int) ((int)frequency - o.frequency);
        }
    }
    public void printTree(huffmanNode root, String s) {
        /**@returns null,
         * prints tree
         * recursively searches the huffman tree
         * from the root the last child.*/
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            generatedHuffmanCode.add(s);
            System.out.println(root.c + " : " + s);
            return;
        }
            printTree(root.left, s + "0");
            printTree(root.right, s + "1");
            
    }
    public void buildTree() throws FileNotFoundException {
        /**@returns calls printTree method,
         * which returns a printed huffman tree.
         * bulids a huffman tree based on the priority queue data structure*/
        PriorityQueue<huffmanNode> pq = new PriorityQueue<huffmanNode>();
        for (Map.Entry<Character, Integer> i : freq.entrySet()) {
            huffmanNode r = new huffmanNode();
            r.c = i.getKey();
            r.frequency = i.getValue();
            pq.add(r);
        }
        huffmanNode root = null;
        while (pq.size() > 1) {
            //removes left and right child.
            huffmanNode left = pq.poll();
            huffmanNode right = pq.poll();
            huffmanNode tmp = new huffmanNode();
            tmp.c = '-';
            //placeholder for actual character
            tmp.frequency = left.frequency + right.frequency;
            //sums frequencies
            tmp.left = left;
            //becomes left child
            tmp.right = right;
            //becomes right child
            root = tmp;
            //becomes root
            pq.add(root);

            }
            printTree(root, "");
    }
    public boolean isValidEncoding(){
        /**@returns boolean
         * checks if the generated
         * encoding is the same as the actual encoding.*/
        java.util.Collections.sort(generatedHuffmanCode);
        java.util.Arrays.sort(actualHuffmanCode);
        for(int i =0; i < generatedHuffmanCode.size(); i++){
            for(int j = 0; j < actualHuffmanCode.length; j++){
                if(generatedHuffmanCode.get(i).equals(actualHuffmanCode[j])){
                   return true;
                } else {
                    System.out.println("Index " + i + " is mismatched");
                }
            }
        }
       return false;
    }
}
