public class testMyHashMap {
    public static void main(String[] args){
        MyHashMap<String, Integer> test = new MyHashMap<>();
        test.put("rachel", 1996);
        test.put("rachel", 1996);
        test.put("krysti", 1993);
        System.out.println(test.toString());
        System.out.println(test.getAll("rachel"));
    }
}

