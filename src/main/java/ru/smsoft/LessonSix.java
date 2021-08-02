package ru.smsoft;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class LessonSix {

    public static <T> boolean containAllElements(Collection<T> collection, T ... elements){
        boolean ret = true;
        for(T element : elements){
            ret = collection.contains(element);
            if(!ret)break;
        }
        return ret;
    }

    public static <T> Collection<T> unique(Collection<T> a, Collection<T> b){
        Collection<T> result = new ArrayList<>();

        Collection<T> a1 = new ArrayList<>(a);
        Collection<T> b1 = new ArrayList<>(b);

        a1.removeAll(b);
        result.addAll(a1);

        b1.removeAll(a);
        result.addAll(b1);

        return result;
    }

    public static <K,V> Map<K,V> mergeMap(Map<K,V> a, Map<K,V> b){
        Map<K,V> resultMap = new HashMap<>();
        resultMap.putAll(a);
        resultMap.putAll(b);
        return resultMap;
    }
}
