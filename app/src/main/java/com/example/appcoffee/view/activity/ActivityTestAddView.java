package com.example.appcoffee.view.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.appcoffee.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityTestAddView extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail_tam);
        LinearLayout layout = findViewById(R.id.linear);

        TextView tv;
        List<View> viewList = new ArrayList<>();
        for(int i=0; i<4;i++) {
            tv = new TextView(this);
            tv.setText("ABC");
            tv.setBackgroundColor(ContextCompat.getColor(this, R.color.white88));
            viewList.add(tv);
            layout.addView(tv);
        }




    }
}
