package com.mori.calc;

public class CalculatorLogic {
    private DisplayPanel mDisplayPanel;

    private double mStackedValue = 0.0;
    private boolean mIsStacked = false;
    private boolean mAfterOp = false;
    String mCurrentOp = "";

    /*
     * Constructor
     */
    public CalculatorLogic(DisplayPanel displayPanel) {
        mDisplayPanel = (DisplayPanel)displayPanel;
    }

    public void calculate( String key ) {
        // Number
        if ( key.equals("0") || key.equals("1") || key.equals("2")
             || key.equals("3") || key.equals("4") || key.equals("5")
             || key.equals("6") || key.equals("7") || key.equals("8")
             || key.equals("9") || key.equals(".") ) {
            appendToDispContent( key );
        }
        // Clear
        else if ( key.equals("C") ) {
            mDisplayPanel.setDispContent( "" );
            mDisplayPanel.display();
            mAfterOp = false;
        }
        else if ( key.equals("AC") ) {
            mDisplayPanel.setDispContent( "0.0" );
            mDisplayPanel.display();
            mIsStacked = false;
            mAfterOp = false;
        }

        // Operator
        else if ( key.equals("+") || key.equals("-") || key.equals("*") || key.equals("/")
                || key.equals("=") ) {
            if(mIsStacked) {
                double resultValue = (Double.valueOf(mDisplayPanel.getDispContent())).doubleValue();
                if ( mCurrentOp.equals("+") ) {
                    mStackedValue += resultValue;
                } else if ( mCurrentOp.equals("-") ) {
                    mStackedValue -= resultValue;
                }
                if ( mCurrentOp.equals("*") ) {
                    mStackedValue *= resultValue;
                }
                if ( mCurrentOp.equals("/") ) {
                    mStackedValue /= resultValue;
                }
                mDisplayPanel.setDispContent(String.valueOf(mStackedValue));
            }
            mCurrentOp = key;
            mStackedValue = (Double.valueOf(mDisplayPanel.getDispContent())).doubleValue();
            mAfterOp = true;
            if ( mCurrentOp.equals("=") ) {
                mIsStacked = false;
            } else {
                mIsStacked = true;
            }
            mDisplayPanel.display();
        }
    }

    /**
     * Output onto Display Panel
     * @param String key
     */
    private void appendToDispContent(String key)
    {
        if( !mAfterOp )
            mDisplayPanel.setDispContent(mDisplayPanel.getDispContent() + key);
        else
        {
            mDisplayPanel.setDispContent( key );
            mAfterOp =false;
        }
        mDisplayPanel.display();
    }
}
