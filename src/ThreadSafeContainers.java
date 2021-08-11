import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ThreadSafeContainers {
    Map<String,Integer> hm = new HashMap<String,Integer>();
    Map<String,Integer> shm = Collections.synchronizedMap(hm);
}
