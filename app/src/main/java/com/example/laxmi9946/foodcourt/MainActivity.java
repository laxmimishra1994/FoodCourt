package com.example.laxmi9946.foodcourt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    FoodAdapter foodAdapter;
    ArrayList<FoodItems> foodItems;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.editTextSearch)
    EditText editTextSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        setListener();
    }

    private void setListener() {
        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //doFilter(editable.toString());
                foodAdapter.getFilter().filter(editable.toString());
            }
        });
    }

    private void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        foodAdapter = new FoodAdapter(this, foodMock());
        recyclerView.setAdapter(foodAdapter);
    }

    ArrayList<FoodItems> foodMock() {
        foodItems = new ArrayList<>();
        FoodItems dummyContent = new
                FoodItems("Sandwich", "eibwefibeibewifbewibfebwfew", "2", R.drawable.sandwich);
        foodItems.add(dummyContent);

        dummyContent = new
                FoodItems("Burger", "eibwefibeibewifbewibfebwfew", "2", R.drawable.burger);
        foodItems.add(dummyContent);
        dummyContent = new
                FoodItems("French Fries", "eibwefibeibewifbewibfebwfew", "2", R.drawable.french_fries);
        foodItems.add(dummyContent);
        dummyContent = new
                FoodItems("Pagina", "eibwefibeibewifbewibfebwfew", "2", R.drawable.pagina);
        foodItems.add(dummyContent);
        dummyContent = new
                FoodItems("Pizza", "eibwefibeibewifbewibfebwfew", "2", R.drawable.pizza);
        foodItems.add(dummyContent);
        dummyContent = new
                FoodItems("Vada Pav", "eibwefibeibewifbewibfebwfew", "2", R.drawable.vadapav);
        foodItems.add(dummyContent);


        return foodItems;
    }
}
