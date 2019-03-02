package com.allennembang.np.apirequest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestActivity extends AppCompatActivity {
    AppCompatEditText first,last;
    AppCompatButton btn;
    AppCompatTextView txtView;
    String getFirst,getLast;
    private static final String TAG = "CheckTest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        first = findViewById(R.id.eTFName);
        last = findViewById(R.id.eTLName);
        btn = findViewById(R.id.btnGo);
        txtView = findViewById(R.id.showJoke);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFirst = first.getText().toString();
                getLast = last.getText().toString();
                Log.d(TAG, "onClick: "+getFirst + getLast);
                ApiInterface apiInterface = ServiceGenerator.createService();
                Call<JokesByNameRP> call = apiInterface.getJokesByName(getFirst,getLast); // function call
                call.enqueue(new Callback<JokesByNameRP>() {
                    @Override
                    public void onResponse(Call<JokesByNameRP> call, Response<JokesByNameRP> response) {
                        JokesByNameRP jokesByNameRP = response.body();
                        jokesByNameRP.getType();

                        if (jokesByNameRP!=null)
                        {
                            if (jokesByNameRP.getType().equalsIgnoreCase("success"))
                            {
                                Log.d(TAG, "onResponse: ");
                                /**
                                 * step 11
                                 */
                                txtView.setText(jokesByNameRP.getValue().getJoke());


                            }
                        }else{
                            Log.d(TAG, "onResponse:Failed");
                        }


                    }

                    @Override
                    public void onFailure(Call<JokesByNameRP> call, Throwable t) {
                        Log.d(TAG, "onFailure: ");
                    }
                });
            }
        });


    }

}
