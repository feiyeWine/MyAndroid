package com.test;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import com.test2.R;

/**
 * Created by YR on 2015/5/16.
 */
public class AutoCompleteDemo extends Activity {
    private AutoCompleteTextView auto;
    private MultiAutoCompleteTextView mauto;
    private String [] books = new String[]{"I like book","I like food","I dont't like meat","Hi","Hello world'"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_autocompletetextview);

        auto = (AutoCompleteTextView)findViewById(R.id.view_autoComplete);
        mauto = (MultiAutoCompleteTextView)findViewById(R.id.view_mauto);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(AutoCompleteDemo.this,android.R.layout.simple_dropdown_item_1line
            ,books);
        auto.setAdapter(adapter);
        mauto.setAdapter(adapter);
        mauto.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
