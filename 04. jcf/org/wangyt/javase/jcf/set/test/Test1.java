package org.wangyt.javase.jcf.set.test;

import java.util.LinkedHashSet;
import java.util.Set;

public class Test1 {
    
    public static void main(String[] args){
        Set<String> s = new LinkedHashSet<String>();
        
        s.add("bbb");
        s.add("aaa");
        s.add("aaa");
        s.add("ddd");
        
        System.out.println(s);
    }

}
