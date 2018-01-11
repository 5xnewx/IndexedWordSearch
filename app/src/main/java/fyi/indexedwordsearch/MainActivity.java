package fyi.indexedwordsearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import fyi.indexedwordsearchjava.IndexedWordSearchJava;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> stringList = new ArrayList<>();
        stringList.addAll(Arrays.asList("google","facebook","instagram","amazon","tata","apple",
                "nokia","samsung","bose","bayalu","shaale","ge","dell"));


        IndexedWordSearchJava indexedWordSearchJava = new IndexedWordSearchJava();

        //create an index for the list of words
        indexedWordSearchJava.createIndexedWord(stringList,true);

        //search the word based on the index
        stringList = indexedWordSearchJava.getFilteredResults("o",true);


        Log.d(TAG, "onCreate: " + stringList);

    }


}
