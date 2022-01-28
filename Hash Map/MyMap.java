public interface MyMap<K, V> {
    /**@author Rachel Van Sciver, COSC 2336 DS&A
     * Exercise 3. Modify MyHashMap Java class to allow duplicate keys for entries.
     * You may need to modify the implementation for the put(key, value) method. Also add a new method named getAll(key)
     * that returns a set of values that match the key in the map.*/
    public void clear();

    public boolean containsKey(K key);

    public boolean containsValue(V value);

    public java.util.Set<Entry<K, V>> entrySet();

    public V get(K key);

    public boolean isEmpty();

    public java.util.Set<K> keySet();

    public V put(K key, V value);

    public void remove(K key);

    public int size();

    public java.util.Set<V> values();

    public static class Entry<K, V>{
        K key;
        V value;

        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey(){
            return key;
        }
        public V getValue(){
            return value;
        }
        public String toString(){
            return "[" + key + ", " + value + "]";
        }
    }
}
