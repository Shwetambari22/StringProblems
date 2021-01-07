package com.example.stringproblems;
/*
* Given array of string
* string = ["9000 vmware.myspace.com", "200 yahoo.mail.com", "1000 yahoo.com", "50 wiki.org"]
* count the sum of each domain separately
*
* */

import java.util.*;

public class DomainCount {

    public static void main(String[] args){
        String[] givenString = {"9000 vmware.myspace.com", "200 yahoo.mail.com", "1000 rediff.mail.com", "50 wiki.org"};
        int count = getDomainCountApp2(givenString, "com");
        System.out.println("The count is " + count);
    }

    /********************************************************************************/
    /* Approach 2
    * Here sum of count of each subdomain is present as the value in the result map
     */
    public static int getDomainCountApp2(String[] givenString, String findDomain) {
        Map<String, Integer> resultMap = new HashMap<String, Integer>();
        int count;
        for (String str : givenString) {
            String[] splitString = str.split(" ");
            count = Integer.parseInt(splitString[0]);
            addToMap(resultMap,splitString[1], count);
            String domainString = splitString[1];
            int index;
            while(true){
                index = domainString.indexOf(".");
                if(index < 0 ) {
                    break;
                }
                domainString = domainString.substring(index+1);
                addToMap(resultMap, domainString, count);
            }

        }
        return resultMap.get(findDomain);
    }

    public static void addToMap(Map<String, Integer> resultMap, String key, Integer value) {
        int countValue;
        if(resultMap.containsKey(key)){
            countValue = resultMap.get(key);
            resultMap.put(key,countValue+value);
        } else {
            resultMap.put(key, value);
        }
    }


    /*********************************************************************************/
    /*
    * approach 1 starts
    *  Here count of each subdomain is stored in the value of Map as a
    * list of integer.
     */
    public static int getDomainCountApp1(String[] givenString, String findDomain){
        int count;
        Map<String, List<Integer>> resultsMap = new HashMap<String, List<Integer>>();
        for ( String str : givenString){
            String[] splitBySpace = str.split(" ");
            count = Integer.parseInt(splitBySpace[0]);
            addToResultMap(resultsMap, splitBySpace[1], count);
            String domainString = splitBySpace[1];
            int index;
            while(true){
                index = domainString.indexOf(".");
                if(index < 0 ) {
                    break;
                }
                domainString = domainString.substring(index+1);
                addToResultMap(resultsMap, domainString, count);
            }
        }

    //count occurances of specific domain
        List<Integer> countList = resultsMap.get(findDomain);
        Integer sum = countList.stream()
                .reduce(0, (a, b) -> a + b);

        return sum;
    }

    public static void addToResultMap(Map<String,List<Integer>> resultsMap, String key, Integer count){
        if(resultsMap.containsKey(key)) {
            List<Integer> valueOfKey = resultsMap.get(key);
            valueOfKey.add(count);
        }else{
            List<Integer> intValue = new ArrayList<Integer> ();
            intValue.add(count);
            resultsMap.put(key,intValue);
        }
    }

    /* Approach 1 ends ************************************/
}
