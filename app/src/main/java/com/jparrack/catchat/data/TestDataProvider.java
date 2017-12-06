package com.jparrack.catchat.data;

import android.util.Log;

import com.jparrack.catchat.listeners.DataCallback;
import com.jparrack.catchat.models.Chat;
import com.jparrack.catchat.models.ChatItem;
import com.jparrack.catchat.models.Story;
import com.jparrack.catchat.models.StoryItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jparrack on 10/6/17
 */

public class TestDataProvider implements DataProvider {
    private static final String TAG = TestDataProvider.class.getName();
    private Chat createConversation(int mode) {
        Log.d(TAG, "createConversation: ");
        Chat conversation = new Chat();
        List<ChatItem> messages = new ArrayList<>();

        ChatItem other1 = new ChatItem();
        other1.setImageUrl("https://firebasestorage.googleapis.com/v0/b/catchat-c3f14.appspot.com/o/6ef8ae26-710a-48bb-99df-61cec4673a75_pic.jpg?alt=media&token=dcf74737-3b12-4f55-a398-63efc160e7df");
        other1.setDuration(5000);
        messages.add(other1);

        ChatItem third = new ChatItem();
        third.setImageUrl("https://firebasestorage.googleapis.com/v0/b/catchat-c3f14.appspot.com/o/3399bbaf-c8be-4336-9973-9aa4a6d8e279_pic.jpg?alt=media&token=1c38e92e-7c1d-48a8-82c5-818381b60130");
        third.setDuration(3000);
        messages.add(third);

        ChatItem fourth = new ChatItem();
        fourth.setVideoUrl("https://firebasestorage.googleapis.com/v0/b/catchat-c3f14.appspot.com/o/Snapchat-1877163156.mp4?alt=media&token=e5ee25c6-4836-44d7-803a-1e7ac0375744");
        messages.add(fourth);

        ChatItem chatMessage = new ChatItem();
        switch(mode%3) {
            case 0:
                chatMessage.setDuration(1000);
                chatMessage.setImageUrl("https://firebasestorage.googleapis.com/v0/b/catchat-c3f14.appspot.com/o/85db6f40-84a4-435a-9082-52eb7f0230d0_pic.jpg?alt=media&token=728b5549-7420-4d1a-8a76-93946580b308");
                break;
            case 1:
                chatMessage.setVideoUrl("https://firebasestorage.googleapis.com/v0/b/catchat-c3f14.appspot.com/o/Snapchat-1877163156.mp4?alt=media&token=e5ee25c6-4836-44d7-803a-1e7ac0375744");
                break;
            case 2:
                chatMessage.setMessage("Hello!");
                break;
        }
        messages.add(chatMessage);

        conversation.setChatMessages(messages);
        return conversation;
    }

    private Story createStory(int mode) {
        Log.d(TAG, "createStory: ");
        Story conversation = new Story();
        List<StoryItem> messages = new ArrayList<>();

        StoryItem chatMessage = new StoryItem();
        switch(mode%3) {
            case 0:
                chatMessage.setDuration(5000);
                chatMessage.setImageUrl("https://firebasestorage.googleapis.com/v0/b/catchat-c3f14.appspot.com/o/85db6f40-84a4-435a-9082-52eb7f0230d0_pic.jpg?alt=media&token=728b5549-7420-4d1a-8a76-93946580b308");
                break;
            case 1:
                chatMessage.setVideoUrl("https://firebasestorage.googleapis.com/v0/b/catchat-c3f14.appspot.com/o/Snapchat-1877163156.mp4?alt=media&token=e5ee25c6-4836-44d7-803a-1e7ac0375744");
                StoryItem other1 = new StoryItem();
                other1.setImageUrl("https://firebasestorage.googleapis.com/v0/b/catchat-c3f14.appspot.com/o/3399bbaf-c8be-4336-9973-9aa4a6d8e279_pic.jpg?alt=media&token=1c38e92e-7c1d-48a8-82c5-818381b60130");
                other1.setDuration(5000);
                messages.add(other1);
                break;
            case 2:
                chatMessage.setDuration(4000);
                chatMessage.setImageUrl("https://firebasestorage.googleapis.com/v0/b/catchat-c3f14.appspot.com/o/6ef8ae26-710a-48bb-99df-61cec4673a75_pic.jpg?alt=media&token=dcf74737-3b12-4f55-a398-63efc160e7df");
                StoryItem other = new StoryItem();
                other.setDuration(3000);
                other.setImageUrl("https://firebasestorage.googleapis.com/v0/b/catchat-c3f14.appspot.com/o/6ef8ae26-710a-48bb-99df-61cec4673a75_pic.jpg?alt=media&token=dcf74737-3b12-4f55-a398-63efc160e7df");
                messages.add(other);
                break;
        }

        messages.add(chatMessage);
        conversation.setStoryItems(messages);
        return conversation;
    }

    @Override
    public void getConversations(String userId, DataCallback<List<Chat>> dataCallback) {
        List<Chat> list = new ArrayList<>();
        int number = 24;
        for(int i = 0; i < number; i++) {
            Chat conversation = createConversation(i);
            list.add(conversation);
        }

        dataCallback.onDataFetched(list, null);
    }

    @Override
    public void getStories(String userId, DataCallback<List<Story>> dataCallback) {
        List<Story> list = new ArrayList<>();
        int number = 24;
        for(int i = 0; i < number; i++) {
            Story conversation = createStory(i);
            list.add(conversation);
        }

        dataCallback.onDataFetched(list, null);
    }
}
