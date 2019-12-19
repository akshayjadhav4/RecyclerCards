package com.akshayjadhav.recyclercards;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<CardItem> cardItemArrayList;
    //    Step1
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private EditText edittextadd;
    private EditText edittextdelete;
    private Button buttonadd;
    private Button buttondelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edittextadd = findViewById(R.id.edittextadd);
        edittextdelete = findViewById(R.id.edittextdelete);
        buttonadd = findViewById(R.id.buttonadd);
        buttondelete = findViewById(R.id.buttondelete);

//        Step2
        generateFakeData();
//        Step3 config for recyclerView
        recyclerViewConfig();

//        Step4
        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String value = edittextadd.getText().toString();
                if (TextUtils.isEmpty(value)){
                    edittextadd.setError("Empty");
                }else{
                    int position = Integer.parseInt(value);
                    addCard(position);
                }
            }
        });

        buttondelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = edittextdelete.getText().toString();
                if (TextUtils.isEmpty(value)){
                    edittextdelete.setError("Empty");
                }else{
                    int position = Integer.parseInt(value);
                    removeCard(position);
                }
            }
        });




    }

    public void generateFakeData() {

        cardItemArrayList = new ArrayList<>();
//        add items
        cardItemArrayList.add(new CardItem(R.drawable.node, "Clicked at studio"));
        cardItemArrayList.add(new CardItem(R.drawable.oner, "Clicked at studio"));
        cardItemArrayList.add(new CardItem(R.drawable.twor, "Clicked at studio"));
        cardItemArrayList.add(new CardItem(R.drawable.threer, "Clicked at studio"));
        cardItemArrayList.add(new CardItem(R.drawable.fourr, "Clicked at studio"));
        cardItemArrayList.add(new CardItem(R.drawable.fiver, "Clicked at studio"));
        cardItemArrayList.add(new CardItem(R.drawable.sixr, "Clicked at studio"));

    }

    public void recyclerViewConfig() {
        recyclerView = findViewById(R.id.recyclerView);
//        If the size of the RecyclerView (the RecyclerView itself)
//        doesn't depend on the adapter content:
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new CardItemAdapter(cardItemArrayList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


    public void addCard(int position){
        cardItemArrayList.add(position,new CardItem(R.drawable.node,"added Card"));
//        adapter.notifyDataSetChanged();  ->> to refresh RV to know data is added(not efficient way)
        adapter.notifyItemInserted(position);
    }


    public void removeCard(int position){
        cardItemArrayList.remove(position);
        adapter.notifyItemRemoved(position);
    }
}
