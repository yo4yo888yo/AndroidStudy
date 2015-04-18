package com.mori.calc;

public class CalculatorLogic {
    private DisplayPanel    mDisplayPanel;

    // ���Z�q�{�^���������O�̒l
    private double mStackedValue = 0.0;
    // stackedValue�ɐ��l����͂������ǂ���
    private boolean mIsStacked = false;
    // ���Z�q�{�^�����������ォ�ǂ���
    private boolean mAfterOp = false;
    // �����ꂽ���Z�q�{�^���̖��O
    String mCurrentOp = "";

    /*
     * �R���X�g���N�^�[
     */
    public CalculatorLogic(DisplayPanel displayPanel)
    {
        mDisplayPanel = (DisplayPanel)displayPanel;
    }

    /*
     * ���Z
     */
    public void calculate( String key )
    {
        // �����L�[
        if ( key.equals("0") || key.equals("1") || key.equals("2")
             || key.equals("3") || key.equals("4") || key.equals("5")
             || key.equals("6") || key.equals("7") || key.equals("8")
             || key.equals("9") || key.equals(".") )
        {
            appendToDispContent( key );
        }
        // �N���A�L�[
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
        
        // ���Z�L�[
        else if ( key.equals("+") || key.equals("-") || key.equals("x") || key.equals("��")
                || key.equals("=") )
        {
            // �f�[�^���X�^�b�N��ɂ������ꍇ
            if(mIsStacked)
            {
                double resultValue = (Double.valueOf(mDisplayPanel.getDispContent())).doubleValue();
                if ( mCurrentOp.equals("+") )
                    mStackedValue += resultValue;
                else if ( mCurrentOp.equals("-") )
                	mStackedValue -= resultValue;
                if ( mCurrentOp.equals("x") )
                	mStackedValue *= resultValue;
                if ( mCurrentOp.equals("��") )
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
     * ���͌�\������
     * @param key ���̓L�[
     */
    private void appendToDispContent(String key)
    {
        if( !mAfterOp ) //���Z�q�{�^��������������łȂ��Ȃ�
        	mDisplayPanel.setDispContent(mDisplayPanel.getDispContent() + key); //�������{�^���̖��O���Ȃ���
        else
        {
        	mDisplayPanel.setDispContent( key ); //�������{�^���̕����񂾂���ݒ肷��i��������N���A�������Ɍ�����j
            mAfterOp =false;
        }
        mDisplayPanel.display();
    }
}
