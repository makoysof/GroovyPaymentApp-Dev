package com.imobile3.groovypayments.ui.orderhistory;

import com.imobile3.groovypayments.concurrent.GroovyExecutors;
import com.imobile3.groovypayments.data.CartRepository;
import com.imobile3.groovypayments.data.Result;
import com.imobile3.groovypayments.data.model.Cart;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * The ViewModel serves as an async bridge between the View (Activity, Fragment)
 * and our backing data repository (Database).
 */
public class OrderHistoryViewModel extends ViewModel {

    private int mCartClicks;
    private CartRepository mRepository;

    OrderHistoryViewModel(CartRepository repository) {
        mCartClicks = 0;
        mRepository = repository;
    }

    //reused the function in OrderEntryViewModel to display the order history
    public LiveData<List<Cart>> getOrderHistory(){
        final MutableLiveData<List<Cart>> observable =
                new MutableLiveData<>(new ArrayList<>());

        GroovyExecutors.getInstance().getDiskIo().execute(() -> {
            Result<List<Cart>> result = mRepository.getDataSource().loadCarts();
            if (result instanceof Result.Success) {
                List<Cart> resultSet = ((Result.Success<List<Cart>>)result).getData();
                observable.postValue(resultSet);
            }
            else{
                observable.postValue(new ArrayList<>());
            }
        });
        return observable;
    }

    public void addCartClick() {
        mCartClicks++;
    }

    public int getCartClicks() {
        return mCartClicks;
    }
}
