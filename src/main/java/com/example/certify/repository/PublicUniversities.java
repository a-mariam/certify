package com.example.certify.repository;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

@Component
public class PublicUniversities {

    private static final Map<String, String> list = new HashMap<>();

    public static void main(String[] args) {
        list.put( "Ahmadu bello university", "6173");
        list.put( "Advanced teacher's college zaria", "6172");
        list.put( "ALVAN IKOKU COLLEGE OF EDUCATION OWERRI", "6174");
        list.put( "Auchi polytechnic", "6175");
        list.put( "Bayero university kano", "6176");
        list.put( "College of science and technology", "6177");
        list.put( "Federal college of agriculture  ", "6117");
        list.put( "federal polytechnic ilaro", "7043");
        list.put( "federal polytechnic bauchi", "6179");
        list.put( "federal university of technology owerri ", "6181");
        list.put( "inst of management and technology", "6182");
        list.put( "institute of medical laboratory tech", "6183");
        list.put( "kaudna polytechnic", "6184");
        list.put( "Kamwenja Teachers college", "6708");
        list.put( "kwara state college of technology", "6185");
        list.put( "michael okpara state college of agric ", "6750");
        list.put( "national technical teachers college yaba", "6186");
        list.put( "obafemi awolowo university ", "6189");
        list.put( "ondo state college of education", "7233");
        list.put( "university of benin", "7106");
        list.put( "university of ibadan", "6188");
        list.put( "university of ilorin", "6408");
        list.put( "university of lagos ", "6190");
        list.put( "university of nigeria", "6191");
        list.put( "university of uyo", "7048");
        list.put( "yaba college of technology", "6192");

    }
    public static void add(String key, String value){
        list.put(key, value);
    }
    public static boolean match(String key, String value ){

        return false;
    }

}
