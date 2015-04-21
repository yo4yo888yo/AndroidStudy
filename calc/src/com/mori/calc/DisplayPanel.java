package com.mori.calc;

import android.widget.TextView;

public class DisplayPanel {
    private TextView mText = null;
    private String mDispContent = "";

    /**
     * Constructor
     */
    public DisplayPanel( TextView display ) {
        mText = display;
    }


    /**
     *
     * @param   String letter
     * @return  mDispContent
     */
    public String addDispContent( String letter ) {
        mDispContent += letter;
        return mDispContent;
    }

    /**
     * Setter
     * @param String letter
     */
    public void setDispContent( String letter ) {
        mDispContent = letter;
    }

    /**
     * Getter
     * @return mDispContent
     */
    public String getDispContent() {
        return mDispContent;
    }

    /**
     *
     * @param String letter
     */
    public void display( String letter ) {
        mText.setText(letter);
    }

    /**
     *
     * @param None
     */
    public void display() {
        mText.setText(mDispContent);
    }
}
