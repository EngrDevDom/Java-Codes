import java.util.LinkedList;
import java.util.Queue;

public class LinearProbing {

    private int currentSize;
    private int maxSize;
    private double loadFactor;
    public String[] keys;
    private String[] values;

    public LinearProbing(int maxSize, double loadFactor) {
        currentSize = 0;
        this.maxSize = maxSize;
        this.loadFactor = loadFactor;
        keys = new String[maxSize];
        values = new String[maxSize];
    }

    public LinearProbing() {
        this(4, 0.5);
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public double getLoadFactor() {
        return loadFactor;
    }

    public double getCurrentLoadFactor() {
        return (double)currentSize/maxSize;
    }

    public Iterable<String> getKeys() {
        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i < maxSize; i++) {
            if (keys[i] != null)
                queue.add(keys[i]);
            else
                queue.add("");
        }

        return queue;
    }

    public String getValue(String key) {
        int n = 0;
        for (int i = hashCalc(key); keys[i] != null; i = (i + 1) % maxSize) {
            n++;
            if (keys[i].equals(key))
                return values[i];
            if(n == 21)
                break;
        }
        return "";
    }

    public boolean contains(String key) {
        return !"".equals(getValue(key));
    }

    public int hashCalc(String key) {
        int hash = 0;
        try {
            hash += Integer.parseInt(key);
        } catch (NumberFormatException e) {
            for(int i = 0; i < key.length(); i++){
                hash+= (int) key.charAt(i);
            }
        }

        return hash%maxSize;
    }

    private void resize(int maxSize) {
        LinearProbing temp = new LinearProbing(maxSize, loadFactor);

        for (int i = 0; i < this.maxSize; i++) {
            if (keys[i] != null) {
                temp.insert(keys[i], values[i]);
            }
        }

        keys = temp.keys;
        values = temp.values;
        this.maxSize = temp.maxSize;
    }

    public void insert(String key, String val) {

        if (getCurrentLoadFactor() >= loadFactor && maxSize < 21) {
            if(maxSize * 2 > 21)
                resize(21);
            else
                resize(2 * maxSize);
        }

        int i;
        for (i = hashCalc(key); keys[i] != null; i = (i + 1) % maxSize) {
            if (keys[i].equals(key)) {
                values[i] = val;
                return;
            }
        }

        keys[i] = key;
        values[i] = val;
        currentSize++;

    }

    public void delete(String key) {

        int i = hashCalc(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % maxSize;
        }

        keys[i] = null;
        values[i] = null;

        i = (i + 1) % maxSize;
        while (keys[i] != null) {
            String  keyTemp = keys[i];
            String valTemp = values[i];
            keys[i] = null;
            values[i] = null;
            currentSize--;
            insert(keyTemp, valTemp);
            i = (i + 1) % maxSize;
        }

        currentSize--;

    }

}