package demo2;

import java.util.*;

public class DAO <T>{

    private Map<String,T> map = new HashMap<>();

    public void save(String id,T entity){
        map.put(id,entity);
    }

    public T get(String id){
        return map.get(id);
    }

    public void update(String id,T entity){
        if (map.containsKey(id)){
            map.put(id,entity);
        }
    }
    public List<T> list(){
        /* 错误的
        Collection<T> values = map.values();
        return (List<T>) values;    */
        //正确的
        ArrayList<T> list = new ArrayList<>();
        Collection<T> values = map.values();
        for (T t:values){
            list.add(t);
        }
        return list;
    }

    public void delete(String id){
        map.remove(id);
    }
}
