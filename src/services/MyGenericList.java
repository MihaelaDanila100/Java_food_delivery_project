package services;

import java.util.ArrayList;
import java.util.List;

public class MyGenericList<T>{
    private List<T> t = new ArrayList<>();

    public void add(T t){
        this.t.add(t);
    }

    public List<T> get(){
        return t;
    }

    @Override
    public String toString() {
        String result;
        result = "Generic class: ";
        for (T el : t) {
            result = result + el.toString() + "\n";
        }
        return result;
    }
}
