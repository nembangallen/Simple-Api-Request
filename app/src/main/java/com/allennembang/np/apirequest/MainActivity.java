package com.allennembang.np.apirequest;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Check";
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * step 10
         */
        swipeRefreshLayout = findViewById(R.id.swipe);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        swipeRefreshLayout.setRefreshing(true);
        getJokes();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getJokes();

            }
        });
    }

    public void getJokes()
    {
        /**
         * step 3/4
         */
        ApiInterface apiInterface = ServiceGenerator.createService();
        Call<JokesRP> call = apiInterface.getRandomJokes(5); // function call
        call.enqueue(new Callback<JokesRP>() {
            @Override
            public void onResponse(Call<JokesRP> call, Response<JokesRP> response) {
                JokesRP jokesRP = response.body();
                jokesRP.getType();

                if (jokesRP!=null)
                {
                    if (jokesRP.getType().equalsIgnoreCase("success"))
                    {
                        Log.d(TAG, "onResponse: ");
                        /**
                         * step 11
                         */
                        JokesListAdapter adapter = new JokesListAdapter(jokesRP.getValue());
                        recyclerView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
//                        for (JokesRP.ValueBean value: jokesRP.getValue()){
//                            Log.d(TAG, "onResponse: "+ value.getJoke());
//                        }
                    }
                }else{
                    Log.d(TAG, "onResponse:Failed");
                }

                if (swipeRefreshLayout.isRefreshing())
                {
                    swipeRefreshLayout.setRefreshing(false);
                }

            }

            @Override
            public void onFailure(Call<JokesRP> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
                if (swipeRefreshLayout.isRefreshing())
                {
                    swipeRefreshLayout.setRefreshing(false);
                }
            }
        });
    }
}
