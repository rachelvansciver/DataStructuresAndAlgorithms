public class testMyHashMap {
    /**@author Rachel Van Sciver, COSC 2336 DS&A
     * Exercise 3. Modify MyHashMap Java class to allow duplicate keys for entries.
     * You may need to modify the implementation for the put(key, value) method. Also add a new method named getAll(key)
     * that returns a set of values that match the key in the map.*/
    public static void main(String[] args){
        MyHashMap<String, Integer> test = new MyHashMap<>();
        test.put("rachel", 1996);
        test.put("rachel", 1996);
        test.put("krysti", 1993);
        System.out.println(test.toString());
        System.out.println(test.getAll("rachel"));
    }
}

