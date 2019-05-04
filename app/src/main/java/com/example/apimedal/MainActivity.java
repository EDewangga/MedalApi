package com.example.apimedal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.apimedal.Adapter.MedalViewAdapter;
import com.example.apimedal.Model.GetMedal;
import com.example.apimedal.Model.Medal;
import com.example.apimedal.Rest.ApiClient;
import com.example.apimedal.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static MainActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.create);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, InsertActivity.class));
            }
        });
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma=this;
        refresh();
    }

    public void refresh() {
        Call<GetMedal> medalCall = mApiInterface.getMedal();
        medalCall.enqueue(new Callback<GetMedal>() {
            @Override
            public void onResponse(Call<GetMedal> call, Response<GetMedal>
                    response) {
                List<Medal> MedalList = response.body().getListDataMedal();
                Log.d("Retrofit Get", "Jumlah data Medal: " +
                        String.valueOf(MedalList.size()));
                mAdapter = new MedalViewAdapter(MedalList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetMedal> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}
