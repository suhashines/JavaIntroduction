package MyCollection.Assignment;

import java.util.HashMap;
import java.util.Hashtable;

public class HashMain {
    public static void main(String[] args) {
        String str = "hello world";
        HashMap<Character, Integer> charOccurrences = countCharacterOccurrences(str);
        System.out.println("Character Occurrences: " + charOccurrences);

        //Character Occurrences: {r=1, d=1, e=1, w=1, h=1, l=3, o=2}

        Hashtable<String, Integer> table1 = new Hashtable<>();
        table1.put("a", 1);
        table1.put("b", 2);
        table1.put("c", 3);

        Hashtable<String, Integer> table2 = new Hashtable<>();
        table2.put("b", 3);
        table2.put("c", 4);
        table2.put("d", 5);

        Hashtable<String, Integer> combinedTable = combineMaps(table1, table2);
        System.out.println("Combined Hashtable: " + combinedTable);

        //Combined Hashtable: {b=3, a=1, d=5, c=4}
    }

    public static HashMap<Character, Integer> countCharacterOccurrences(String str) {
        // Implement this method

        char[] characters = str.toCharArray();

        HashMap<Character,Integer>map = new HashMap<>();

        for(char ch:characters){

            if(ch<'a' || ch>'z') continue;

            if(!map.containsKey(ch)){
                map.put(ch,1);
            }else{

                int occurrence = map.get(ch) ;

                map.put(ch,occurrence+1);
            }
        }

        return map;

    }

    public static Hashtable<String, Integer> combineMaps(Hashtable<String, Integer> table1, Hashtable<String, Integer> table2) {
        // Implement this method

        for(String key2 : table2.keySet()){

            int value2 = table2.get(key2);

            if(table1.contains(key2)){

                int value1 = table1.get(key2);

                table1.put(key2,value1+value2);
            }else{
                table1.put(key2,value2);
            }
        }

        return table1;
    }
}

