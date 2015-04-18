package com.mori.calc;

public class CalculatorLogic {
    private DisplayPanel    mDisplayPanel;

    // 演算子ボタンを押す前の値
    private double mStackedValue = 0.0;
    // stackedValueに数値を入力したかどうか
    private boolean mIsStacked = false;
    // 演算子ボタンを押した後かどうか
    private boolean mAfterOp = false;
    // 押された演算子ボタンの名前
    String mCurrentOp = "";

    /*
     * コンストラクター
     */
    public CalculatorLogic(DisplayPanel displayPanel)
    {
        mDisplayPanel = (DisplayPanel)displayPanel;
    }

    /*
     * 演算
     */
    public void calculate( String key )
    {
        // 数字キー
        if ( key.equals("0") || key.equals("1") || key.equals("2")
             || key.equals("3") || key.equals("4") || key.equals("5")
             || key.equals("6") || key.equals("7") || key.equals("8")
             || key.equals("9") || key.equals(".") )
        {
            appendToDispContent( key );
        }
        // クリアキー
        else if ( key.equals("C") )
        {
        	mDisplayPanel.setDispContent( "" );
        	mDisplayPanel.display();
        }
        else if ( key.equals("AC") )
        {
        	mDisplayPanel.setDispContent( "0.0" );
        	mDisplayPanel.display();
            mIsStacked = false;
        	
        }
        
        // 演算キー
        else if ( key.equals("+") || key.equals("-") || key.equals("x") || key.equals("÷")
                || key.equals("=") )
        {
            // データがスタック上にあった場合
            if(mIsStacked)
            {
                double resultValue = (Double.valueOf(mDisplayPanel.getDispContent())).doubleValue();
                if ( mCurrentOp.equals("+") )
                    mStackedValue += resultValue;
                else if ( mCurrentOp.equals("-") )
                	mStackedValue -= resultValue;
                if ( mCurrentOp.equals("x") )
                	mStackedValue *= resultValue;
                if ( mCurrentOp.equals("÷") )
                	mStackedValue /= resultValue;
                mDisplayPanel.setDispContent(String.valueOf(mStackedValue));
            }
            mCurrentOp = key;
            mStackedValue = (Double.valueOf(mDisplayPanel.getDispContent())).doubleValue();
            mAfterOp = true;
            if ( mCurrentOp.equals("=") )
                mIsStacked = false;
            else
                mIsStacked = true;
            mDisplayPanel.display();
        }
    }

    /**
     * 入力後表示処理
     * @param key 入力キー
     */
    private void appendToDispContent(String key)
    {
        if( !mAfterOp ) //演算子ボタンを押した直後でないなら
        	mDisplayPanel.setDispContent(mDisplayPanel.getDispContent() + key); //押したボタンの名前をつなげる
        else
        {
        	mDisplayPanel.setDispContent( key ); //押したボタンの文字列だけを設定する（いったんクリアしたかに見える）
            mAfterOp =false;
        }
        mDisplayPanel.display();
    }
}
