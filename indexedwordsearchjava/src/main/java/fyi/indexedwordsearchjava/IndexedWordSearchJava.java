package fyi.indexedwordsearchjava;


import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * The class Indexed word search.
 * Concept used in B4X search
 */
public class IndexedWordSearchJava {

    private int MINIMUM_INDEX_LIMIT = 1, MAXIMUM_INDEX_LIMIT = 4;
    private static final String TAG = IndexedWordSearchJava.class.getSimpleName();

    /**
     * The Prefix map.
     */
    private HashMap<String, List<Integer>> prefixMap,
    /**
     * The Suffix map.
     */
    suffixMap;
    /**
     * The All items List.
     */
    private List<String> allItems;

    /**
     * Gets minimum index limit.
     *
     * @return the minimum index limit
     */
    public int getMINIMUM_INDEX_LIMIT() {
        return MINIMUM_INDEX_LIMIT;
    }

    /**
     * Sets minimum index limit. The minimum number of letters used for creating index. Default
     * value is 2
     *
     * @param MINIMUM_INDEX_LIMIT the minimum index limit
     */
    public void setMINIMUM_INDEX_LIMIT(int MINIMUM_INDEX_LIMIT) {
        this.MINIMUM_INDEX_LIMIT = MINIMUM_INDEX_LIMIT;
    }

    /**
     * Gets maximum index limit.
     *
     * @return the maximum index limit
     */
    public int getMAXIMUM_INDEX_LIMIT() {
        return MAXIMUM_INDEX_LIMIT;
    }

    /**
     * Sets maximum index limit. The maximum number of letters used for creating index. Default
     * value is 4
     *
     * @param MAXIMUM_INDEX_LIMIT the maximum index limit
     */
    public void setMAXIMUM_INDEX_LIMIT(int MAXIMUM_INDEX_LIMIT) {
        this.MAXIMUM_INDEX_LIMIT = MAXIMUM_INDEX_LIMIT;
    }


    /**
     * Create indexed word for the each element in the list
     *
     * @param stringList          the string list
     * @param displayIndexedWords to display indexed words in log with TAG = IndexedWordSearch
     */
    public void createIndexedWord(List<String> stringList, Boolean displayIndexedWords) {

        allItems = stringList;

        HashMap<String, String> stringMapWoRepeat = new HashMap<>();
        List<Integer> indexList;

        prefixMap = new HashMap<>();
        suffixMap = new HashMap<>();

        for (int i = 0; i < stringList.size(); i++) {
            String singleItem;
            singleItem = stringList.get(i);
            singleItem = singleItem.toLowerCase();
            stringMapWoRepeat.clear();

            for (int initial = 0; initial < singleItem.length(); initial++) {
                int count;
                count = MINIMUM_INDEX_LIMIT;
                while ((count <= MAXIMUM_INDEX_LIMIT) && ((initial + count) <= singleItem.length
                        ())) {
                    String subString = singleItem.substring(initial, initial + count);

                    if (!(stringMapWoRepeat.containsKey(subString))) {
                        stringMapWoRepeat.put(subString, "");

                        if (initial == 0) {
                            indexList = prefixMap.get(subString);
                            if (indexList == null) {
                                indexList = new ArrayList<>();
                            }

                            indexList.add(i);
                            prefixMap.put(subString, indexList);
                        } else {
                            indexList = suffixMap.get(subString);
                            if (indexList == null) {
                                indexList = new ArrayList<>();
                            }

                            indexList.add(i);
                            suffixMap.put(subString, indexList);
                        }
                    }
                    count++;

                }
            }
        }

        if (displayIndexedWords) {
            Log.i(TAG, "prefix Map: " + prefixMap.toString());
            Log.i(TAG, "suffix Map: " + suffixMap.toString());
            Log.i(TAG, "all Items: " + allItems.toString());
        }

    }


    /**
     * Get filtered results.
     *
     * @param filter                the filter - string/word
     * @param displayFilteredResult the display filtered result - string List in log with TAG =
     *                              IndexedWordSearch
     * @return the filtered results
     */
    public List<String> getFilteredResults(String filter, Boolean displayFilteredResult) {
        List<String> filteredResult = new ArrayList<>();

        if (filter.length() < MINIMUM_INDEX_LIMIT) {
            return allItems;
        } else {
            String s1, s2;
            s1 = filter.toLowerCase();
            if (s1.length() > MAXIMUM_INDEX_LIMIT) {
                s2 = s1.substring(0, MAXIMUM_INDEX_LIMIT);
            } else {
                s2 = s1;
            }


            List<Integer> indexList = prefixMap.get(s2);
            if (indexList != null) {
                addToFilteredResult(filteredResult, prefixMap.get(s2), s1);
            }

            indexList = suffixMap.get(s2);
            if (indexList != null) {
                addToFilteredResult(filteredResult, suffixMap.get(s2), s1);
            }

        }


        if(displayFilteredResult) Log.i(TAG, "getFilteredResults: " + filteredResult.toString());


        return filteredResult;
    }

    private void addToFilteredResult(List<String> stringList, List<Integer> indexList, String
            filter) {

        for (int i = 0; i < indexList.size(); i++) {
            String filteredItem = allItems.get(indexList.get(i));
            if((filter.length()>MAXIMUM_INDEX_LIMIT) && (!(filteredItem.toLowerCase().contains
                    (filter)))){
                continue;
            }

            stringList.add(filteredItem);
        }
    }

}


