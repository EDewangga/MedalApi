package com.example.apimedal;

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

public class InsertActivity extends AppCompatActivity {

    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        Button button = findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View view) {
                TextView negaraView = findViewById(R.id.insertNegara);
                TextView goldView = findViewById(R.id.insertGold);
                TextView silverView = findViewById(R.id.inserSilver);
                TextView bronzeView = findViewById(R.id.insertBronze);
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

                    Call<PostPutDelMedal> postMedalCall = mApiInterface.postMedal(negara, gold, silver, bronze);
                    postMedalCall.enqueue(new Callback<PostPutDelMedal>() {
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

    }
}
