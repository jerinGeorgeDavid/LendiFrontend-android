package com.jaydee.lendi.networking;

import com.jaydee.lendi.model.TransactionL;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Methods {
    @GET("/getAllTransactions")
    Call<List<TransactionL>> getAllData();
}

