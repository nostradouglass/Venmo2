package com.kellydouglass.venmo2.utils;

import com.kellydouglass.venmo2.models.Me;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HttpTransactionApi {

    @GET("me")
    Call<List<Me>> getMeTransactions();

}
