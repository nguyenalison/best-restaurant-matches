package org.alisonnguyen.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MatchingCriteria {
    public static ArrayList<String> matchByName(String userInput, List<String>names){
        ArrayList<String> matches = new ArrayList<>();
        for (String name: names){
            if(inputMatchesOrder(name, userInput)){
                matches.add(name);
            }
        }
        return matches;
    }

    private static boolean inputMatchesOrder(String userInput, String name){
        int cIndex = 0;
        int inputLen = 0;
        int nameLen = name.length();

        for (int i = 0; i <nameLen; i++){
            if(Character.toLowerCase(userInput.charAt(i)) == Character.toLowerCase(name.charAt(cIndex))){
                cIndex++;
                if (cIndex == inputLen) {
                    return true;
                }
            }
        }
        return false;
    }

}
