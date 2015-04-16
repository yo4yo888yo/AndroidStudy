package com.mori.calc;

import android.widget.TextView;

public class DisplayPanel {
    // �\���pObject�i�e�L�X�g�j
    private TextView mText = null;
    // �\�����e�o�b�t�@
    private String mDispContent = "";

    /**
     * �R���X�g���N�^
     */
    public DisplayPanel( TextView display )
    {
    	mText = display;
    }

    /**
     * �������p���\�b�h
     *
     * @return void
     */

    /**
     * ���l�\���p��TextField�̎擾�i����`�Ȃ�쐬�j
     *
     * @return �\���p�I�u�W�F�N�g
     */

    /**
     * �\�����e�Ɏw�蕶����ǉ�����
     * @param letter �ǉ�����
     * @return �V�K�\�����e
     */
    public String addDispContent( String letter )
    {
    	mDispContent += letter;
        return mDispContent;
    }

    /**
     * Setter
     * @param letter �ݒ�l
     */
    public void setDispContent( String letter )
    {
    	mDispContent = letter;
    }

    /**
     * Getter
     * @return �\�����e
     */
    public String getDispContent()
    {
        return mDispContent;
    }

    /**
     * �w�蕶���̕\���̍X�V
     * @param letter �w�蕶���i�\���j
     */
    public void display( String letter )
    {
        mText.setText(letter);
    }

    /**
     * �\���e�L�X�g�̍X�V
     */
    public void display()
    {
    	mText.setText(mDispContent);
    }
}
