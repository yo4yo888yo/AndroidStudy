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

public class MainActivity extends Activity implements OnClickListener
{
    private String[][] mKey = {
            { "+", "-", "x", "÷" },
            { "7", "8", "9","=" },
            { "4", "5", "6", ""},
            { "1", "2", "3", "C" },
            { "±", "0", ".", "AC" } };

	private DisplayPanel mDisplayPanel;
	private CalculatorLogic mLogic;

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        // setContentView(R.layout.main);

        // 全体
        LinearLayout layout0 = new LinearLayout( this );
        layout0.setOrientation( LinearLayout.VERTICAL );
        layout0.setLayoutParams( new LayoutParams( LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT ) );
        setContentView( layout0 );

        // 電卓表示器
        TextView display = new TextView( this );
        display.setText( "0.0" );
        display.setTextSize( 30.0f );
        display.setTextColor( Color.rgb( 0x50, 0x50, 0x50 ) );
        display.setBackgroundColor( Color.rgb( 0xee, 0xee, 0xee ) );
        display.setGravity( Gravity.RIGHT );
        display.setLayoutParams( new LayoutParams( LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT ) );
        layout0.addView( display );

        mDisplayPanel = new DisplayPanel( display );
        mLogic = new CalculatorLogic( mDisplayPanel );

        // 電卓ボタン
        TableLayout layout = new TableLayout( this );

        TableLayout.LayoutParams tableLp = new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.MATCH_PARENT, 1 );

        layout0.addView( layout, tableLp );

        // 列
        TableRow.LayoutParams columnLp = new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.MATCH_PARENT, 1 );

        for ( int row = 0; row < 5; row++ )
        {
            // TableRowを作成
            TableRow tableRow = new TableRow( this );
            tableRow.setLayoutParams( tableLp );

            //
            for ( int col = 0; col < 4; col++ )
            {
                Button button = new Button( this );
                button.setText( mKey[row][col] );
                button.setOnClickListener( this );
                button.setTextSize( 50.0f );
                tableRow.addView( button, columnLp );
            }
            layout.addView( tableRow );
        }
    }

    @Override
    public void onClick( View v )
    {
        String key = ((Button)v).getText().toString();
        mLogic.calculate( key );
    }
}