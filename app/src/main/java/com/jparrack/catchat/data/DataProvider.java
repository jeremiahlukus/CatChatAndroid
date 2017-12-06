package com.jparrack.catchat.data;

import com.jparrack.catchat.listeners.DataCallback;
import com.jparrack.catchat.models.Chat;
import com.jparrack.catchat.models.Story;

import java.util.List;

/**
 * Created by jparrack on 9/4/17
 */

public interface DataProvider {

    void getConversations(String userId, DataCallback<List<Chat>> dataCallback);
    void getStories(String userId, DataCallback<List<Story>> dataCallback);

}
