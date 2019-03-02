package com.allennembang.np.apirequest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Step 2
 * create interface
 */
public interface ApiInterface {
    @GET("random/{count}")
    Call<JokesRP> getRandomJokes(@Path("count") int count);

    @GET("random")
    Call<JokesByNameRP> getJokesByName(@Query("firstName") String firstName, @Query("lastName") String lastName);
}
