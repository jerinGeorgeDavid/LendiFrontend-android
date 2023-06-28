package com.jaydee.lendi.repository;

import android.util.Log;

import com.jaydee.lendi.model.TransactionL;
import com.jaydee.lendi.networking.Methods;
import com.jaydee.lendi.networking.RetrofitClient;
import com.jaydee.lendi.viewmodel.ToGetViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ToGetRepo {
    public static final String TAG="ToGetRepo";
    private ToGetViewModel mViewModelToGet;
    private List<TransactionL> mData;


    public ToGetRepo(ToGetViewModel mViewModelToGet) {
        this.mViewModelToGet = mViewModelToGet;
    }
    public void getAlldata(){
        Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
        Call<List<TransactionL>> call = methods.getAllData();

        call.enqueue(new Callback<List<TransactionL>>() {
            @Override
            public void onResponse(Call<List<TransactionL>> call, Response<List<TransactionL>> response) {
                Log.i(TAG, "onResponse:  response is _>" + response.body().toString());
                mData = response.body();
                mViewModelToGet.setData(mData);

            }

            @Override
            public void onFailure(Call<List<TransactionL>> call, Throwable t) {
                Log.i(TAG, "onFailure: ------->" + t);

            }
        });
    }
}
