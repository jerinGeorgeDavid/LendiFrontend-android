package com.jaydee.lendi.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaydee.lendi.R;
import com.jaydee.lendi.adapters.ListToGetAdapter;
import com.jaydee.lendi.model.TransactionL;
import com.jaydee.lendi.networking.Methods;
import com.jaydee.lendi.networking.RetrofitClient;
import com.jaydee.lendi.viewmodel.ToGetViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TogetFragment extends Fragment {
    public static final String TAG = "TogetFragment";
    RecyclerView rViewToGet;
    ListToGetAdapter adapterToGet;
    List<TransactionL> mListToget;

    ToGetViewModel mViewModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mListToget == null) {
            mListToget = new ArrayList<>();
        }
        rViewToGet=requireActivity().findViewById(R.id.rvToGet);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_toget, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rViewToGet = requireActivity().findViewById(R.id.rvToGet);
        //loadDataFromNet();


        //setADapter for recycler view
        adapterToGet = new ListToGetAdapter();
        rViewToGet.setAdapter(adapterToGet);
        rViewToGet.setLayoutManager(new LinearLayoutManager(requireActivity(),LinearLayoutManager.VERTICAL,false));
        //initialise viewmodel
        mViewModel = new ViewModelProvider(this).get(ToGetViewModel.class);
        //observe data
        mViewModel.getData().observe(requireActivity(), new Observer<List<TransactionL>>() {
            @Override
            public void onChanged(List<TransactionL> transactionLS) {
                adapterToGet.setData(transactionLS);

            }
        });
        mViewModel.triggerNetworkOperation();
        //trigger network op


    }

    private void loadDataFromNet() {
        Log.i(TAG, "loadDataFromNet: ---------->Reached");
        Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
        Call<List<TransactionL>> call = methods.getAllData();

        call.enqueue(new Callback<List<TransactionL>>() {
            @Override
            public void onResponse(Call<List<TransactionL>> call, Response<List<TransactionL>> response) {
                Log.i(TAG, "onResponse:  response is _>" + response.body().toString());
                mListToget = response.body();
                displayData();
            }

            @Override
            public void onFailure(Call<List<TransactionL>> call, Throwable t) {
                Log.i(TAG, "onFailure: ------->" + t);

            }
        });

    }

    private void displayData() {


    }
}