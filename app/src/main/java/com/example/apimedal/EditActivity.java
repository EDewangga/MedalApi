package com.example.apimedal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.apimedal.Model.PostPutDelMedal;
import com.example.apimedal.Rest.ApiClient;
import com.example.apimedal.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditActivity extends AppCompatActivity {

    ApiInterface mApiInterface;
    TextView negaraView, goldView, silverView, bronzeView;
    Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        negaraView = findViewById(R.id.editNegara);
        goldView = findViewById(R.id.editGold);
        silverView = findViewById(R.id.editSilver);
        bronzeView = findViewById(R.id.editBronze);

        mIntent = getIntent();

        negaraView.setText(mIntent.getStringExtra("Country"));
        goldView.setText(mIntent.getStringExtra("Gold"));
        silverView.setText(mIntent.getStringExtra("Silver"));
        bronzeView.setText(mIntent.getStringExtra("Bronze"));

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        Button button = findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View view) {
                int status = 0;

                if( TextUtils.isEmpty(negaraView.getText())){
                    negaraView.setError( "Country is required!");
                    status = 1;
                }
                if( TextUtils.isEmpty(goldView.getText())){
                    goldView.setError( "Gold medal is required!");
                    status = 1;
                }
                if( TextUtils.isEmpty(silverView.getText())){
                    silverView.setError( "Silver medal is required!");
                    status = 1;
                }
                if( TextUtils.isEmpty(bronzeView.getText())){
                    bronzeView.setError( "Bronze medal is required!");
                    status = 1;
                }
                if (status==0){
                    String negara = negaraView.getText().toString();
                    String gold = goldView.getText().toString();
                    String silver = silverView.getText().toString();
                    String bronze = bronzeView.getText().toString();
                    String id = mIntent.getStringExtra("Position");

                    Call<PostPutDelMedal> putMedalCall = mApiInterface.putMedal(id, negara, gold, silver, bronze);
                    putMedalCall.enqueue(new Callback<PostPutDelMedal>() {
                        @Override
                        public void onResponse(Call<PostPutDelMedal> call, Response<PostPutDelMedal> response) {
                            MainActivity.ma.refresh();
                            finish();
                        }

                        @Override
                        public void onFailure(Call<PostPutDelMedal> call, Throwable t) {
                            Snackbar.make(view, "Error", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }
                    });
                }

            }
        });

        Button buttonDelete = findViewById(R.id.hapus);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View view) {
                String id = mIntent.getStringExtra("Position");

                Call<PostPutDelMedal> deleteMedalCall = mApiInterface.deleteMedal(id);
                deleteMedalCall.enqueue(new Callback<PostPutDelMedal>() {
                    @Override
                    public void onResponse(Call<PostPutDelMedal> call, Response<PostPutDelMedal> response) {
                        MainActivity.ma.refresh();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelMedal> call, Throwable t) {
                        Snackbar.make(view, "Error", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                });
            }
        });
    }
}
