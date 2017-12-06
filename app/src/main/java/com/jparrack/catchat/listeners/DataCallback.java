package com.jparrack.catchat.listeners;

/**
 * Created by jparrack on 9/7/17
 */

public interface DataCallback<T> {
    void onDataFetched(T data, Exception error);
}
