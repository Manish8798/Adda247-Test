package com.prady.adda247task;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.prady.adda247task.jsontopojo.Adda247;
import com.prady.adda247task.jsontopojo.Datum;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    List<Datum> datumList;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(Color.GRAY);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(this,datumList);
        recyclerView.setAdapter(adapter);
        fetchData();
    }

    private void fetchData() {

        Call<Adda247> call;
        ApiInterface apiInterface = GetMethod.getRetrofit().create(ApiInterface.class);
        call = apiInterface.getDetails();
        call.enqueue(new Callback<Adda247>() {
            @Override
            public void onResponse(Call<Adda247> call, Response<Adda247> response) {
                if (response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Error1", Toast.LENGTH_SHORT).show();
                    Log.d("RES_CALL","Successful");
                    Adda247 adda247 = response.body();
                    assert adda247 != null;
                    datumList = adda247.getData();
                    adapter.setDatumList(datumList);
                    adapter.notifyDataSetChanged();
                    return;
                }

                Log.d("RES_CALL","UnSuccessful");

            }

            @Override
            public void onFailure(Call<Adda247> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();

            }
        });

    }
}