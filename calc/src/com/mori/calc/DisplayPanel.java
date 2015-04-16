package com.mori.calc;

import android.widget.TextView;

public class DisplayPanel {
    // 表示用Object（テキスト）
    private TextView mText = null;
    // 表示内容バッファ
    private String mDispContent = "";

    /**
     * コンストラクタ
     */
    public DisplayPanel( TextView display )
    {
    	mText = display;
    }

    /**
     * 初期化用メソッド
     *
     * @return void
     */

    /**
     * 数値表示用のTextFieldの取得（未定義なら作成）
     *
     * @return 表示用オブジェクト
     */

    /**
     * 表示内容に指定文字を追加する
     * @param letter 追加文字
     * @return 新規表示内容
     */
    public String addDispContent( String letter )
    {
    	mDispContent += letter;
        return mDispContent;
    }

    /**
     * Setter
     * @param letter 設定値
     */
    public void setDispContent( String letter )
    {
    	mDispContent = letter;
    }

    /**
     * Getter
     * @return 表示内容
     */
    public String getDispContent()
    {
        return mDispContent;
    }

    /**
     * 指定文字の表示の更新
     * @param letter 指定文字（表示）
     */
    public void display( String letter )
    {
        mText.setText(letter);
    }

    /**
     * 表示テキストの更新
     */
    public void display()
    {
    	mText.setText(mDispContent);
    }
}
