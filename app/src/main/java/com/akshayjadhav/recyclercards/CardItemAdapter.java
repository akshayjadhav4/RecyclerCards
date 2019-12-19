package com.akshayjadhav.recyclercards;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CardItemAdapter extends RecyclerView.Adapter<CardItemAdapter.CardItemHolder> {

//    Step 7.2
    private  ArrayList<CardItem> mcardList;
//    Step1 Create this class file
//    Step2  this below class
    public static class CardItemHolder extends RecyclerView.ViewHolder{

//        Step5
        public ImageView imageView;
        public TextView textView;


//        Step3 create constructor and also on line8 <CardItemAdapter.CardItemHolder> added
        public CardItemHolder(@NonNull View itemView) {
            super(itemView);

//            Step5 here itemView is param to constructor
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }

//    Step7.1 to know how many items need to generate and what properties need to set
//    this is a constructor
    public CardItemAdapter(ArrayList<CardItem> cardItemArrayList){
        mcardList = cardItemArrayList;
    }

//    Step4 Create this below 3 methods
    @NonNull
    @Override
    public CardItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

//        Step6 inflate view
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
        CardItemHolder cardItemHolder = new CardItemHolder(view);
        return  cardItemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardItemHolder cardItemHolder, int i) {

//        Step 8
        CardItem currentItem = mcardList.get(i);
        cardItemHolder.imageView.setImageResource(currentItem.getmImageResource());
        cardItemHolder.textView.setText(currentItem.getmText());
    }

    @Override
    public int getItemCount() {
//        Step 9
        return mcardList.size();
    }


}
