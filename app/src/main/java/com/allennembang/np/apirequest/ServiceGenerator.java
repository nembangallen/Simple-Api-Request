package com.allennembang.np.apirequest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    /**
     * Step 1
     * create service
     * @return
     */
    public static ApiInterface createService()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.icndb.com/jokes/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ApiInterface.class);
    }
}
