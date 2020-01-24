package com.kellydouglass.venmo2.Utils;

import com.kellydouglass.venmo2.Models.Me;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HttpTransactionApi {

    @GET("posts")
    Call<List<Me>> getPosts();

}
