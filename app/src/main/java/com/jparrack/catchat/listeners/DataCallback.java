package com.jparrack.catchat.listeners;

/**
 * Created by jparrack on 3/7/17
 */

public interface DataCallback<T> {
    void onDataFetched(T data, Exception error);
}
