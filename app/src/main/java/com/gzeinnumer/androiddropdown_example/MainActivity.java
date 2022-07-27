package com.gzeinnumer.androiddropdown_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;

import com.gzeinnumer.ad.AdapterAutoCompleteText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AutoCompleteTextView act = findViewById(R.id.act);

        ArrayList<String> list = new ArrayList<String>();
        list.add("Satu");
        list.add("Dua");
        list.add("Tiga");
        list.add("Empat");

        AdapterAutoCompleteText<String> adapter = new AdapterAutoCompleteText<String>(getApplicationContext(), list);
        adapter.setItemStyle(R.style.AutoCompleteTextViewStyle);
        act.setAdapter(adapter);
        act.setFreezesText(false);

        act.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                    act.setText(list.get(position), false);
                } else {
                    act.setText(list.get(position));
                }
            }
        });
    }
}