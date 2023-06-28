package com.jaydee.lendi.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jaydee.lendi.model.TransactionL;
import com.jaydee.lendi.repository.ToGetRepo;

import java.util.List;

public class ToGetViewModel extends ViewModel {
    private ToGetRepo repoToGet;
    private MutableLiveData<List<TransactionL>> mListToget;
    private MutableLiveData<Boolean> fetchError;

    public ToGetViewModel() {
        repoToGet = new ToGetRepo(this);
        mListToget = new MutableLiveData<>();
        fetchError = new MutableLiveData<>();
    }

    public MutableLiveData<List<TransactionL>> getmListToget() {
        return mListToget;
    }
    public void setData(List<TransactionL> mData){
        mListToget.setValue(mData);

    }
    public LiveData<List<TransactionL>> getData(){
        return mListToget;
    }

    public void setmListToget(MutableLiveData<List<TransactionL>> mListToget) {
        this.mListToget = mListToget;
    }

    public MutableLiveData<Boolean> getFetchError() {
        return fetchError;
    }

    public void setFetchError(MutableLiveData<Boolean> fetchError) {
        this.fetchError = fetchError;
    }
    public void triggerNetworkOperation(){
        repoToGet.getAlldata();
    }
}
