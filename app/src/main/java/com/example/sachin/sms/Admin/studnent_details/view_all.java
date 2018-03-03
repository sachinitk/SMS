package com.example.sachin.sms.Admin.studnent_details;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.sachin.sms.R;

public class view_all extends AppCompatActivity {

    TableLayout t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);
        t1 = (TableLayout)findViewById(R.id.viewall);
        TableRow tr_head = new TableRow(this);
       // tr_head.setId();
        //tr_head.setBackground();
        tr_head.setLayoutParams(new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        TextView label_date = new TextView(this);
        label_date.setText("Date");
        tr_head.addView(label_date);

        TextView label_weight = new TextView(this);
        label_weight.setText("Wt kg");
        tr_head.addView(label_weight);
        t1.addView(tr_head, new TableLayout.LayoutParams(
                ViewGroup.LayoutParams.FILL_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
    }
}
