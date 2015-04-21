package com.mori.calc;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
    private int[] keys = {  R.id.number0, R.id.number1, R.id.number2, R.id.number3, R.id.number4,
                            R.id.number5, R.id.number6, R.id.number7, R.id.number8, R.id.number9,
                            R.id.comma, R.id.plus, R.id.minus, R.id.star, R.id.hash,
                            R.id.equal, R.id.clear, R.id.ac    };

    private DisplayPanel mDisplayPanel;
    private CalculatorLogic mLogic;


    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.activity_main);

        TextView display = (TextView) findViewById(R.id.textView1);
        mDisplayPanel = new DisplayPanel( display );
        mLogic = new CalculatorLogic( mDisplayPanel );

        int len = keys.length;
        for(int i = 0; i < len; i++) {
            findViewById(keys[i]).setOnClickListener(this);
        }
    }

    @Override
    public void onClick( View v ) {
        String key = ((Button)v).getText().toString();
        mLogic.calculate( key );
    }
}