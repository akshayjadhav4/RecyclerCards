package com.akshayjadhav.recyclercards;

public class CardItem {

    //Step1
    private  int mImageResource;
    private  String mText;

    //Step2 Constructor
    public CardItem(int imageResource,String text){
        mImageResource = imageResource;
        mText = text;
    }

    //Step3 getters for both
    public int getmImageResource() {
        return mImageResource;
    }

    public String getmText() {
        return mText;
    }
}
