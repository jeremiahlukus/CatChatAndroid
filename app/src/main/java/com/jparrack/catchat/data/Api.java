package com.jparrack.catchat.data;

import com.jparrack.catchat.models.Chat;
import com.jparrack.catchat.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jparrack on 3/7/17
 */

public interface Api {

    @GET("chats")
    Call<List<Chat>> getChats(
            @Query("orderBy") String orderBy,
            @Query("equalTo") String equalTo
    );

    @GET("users")
    Call<List<User>> getUsers(
            @Query("orderBy") String orderBy,
            @Query("equalTo") String equalTo
    );

}
