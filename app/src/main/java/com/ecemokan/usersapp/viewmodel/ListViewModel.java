package com.ecemokan.usersapp.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ecemokan.usersapp.model.UserModel;
import com.ecemokan.usersapp.model.UsersService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class ListViewModel extends ViewModel {
    public MutableLiveData<List<UserModel>> users= new MutableLiveData<List<UserModel>>();
    public MutableLiveData<Boolean> userLoadError = new MutableLiveData<Boolean>();
    public MutableLiveData<Boolean> loading = new MutableLiveData<Boolean>();

    private UsersService usersService= UsersService.getInstance();

    private CompositeDisposable disposable=new CompositeDisposable();

    public void refresh(){
        fetchUsers();
    }

    private void fetchUsers() {
        loading.setValue(true);
        disposable.add(
                usersService.getUsers()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<UserModel>>() {
                    @Override
                    public void onSuccess(List<UserModel> userModels) {
                        users.setValue(userModels);
                        userLoadError.setValue(false);
                        loading.setValue(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        userLoadError.setValue(true);
                        loading.setValue(true);
                        e.printStackTrace();
                    }
                })
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
