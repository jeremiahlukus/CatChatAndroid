package com.jparrack.catchat.fragment;

import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.jparrack.catchat.MainActivity;
import com.jparrack.catchat.Constants;
import com.jparrack.catchat.R;
import com.jparrack.catchat.adapter.ConversationsAdapter;
import com.jparrack.catchat.data.DataProvider;
import com.jparrack.catchat.data.TestDataProvider;
import com.jparrack.catchat.listeners.DataCallback;
import com.jparrack.catchat.models.Chat;
import com.jparrack.catchat.models.ChatItem;
import com.jparrack.catchat.models.StoryItem;
import com.jparrack.catchat.util.FirebaseListenMessage;
import com.jparrack.catchat.util.ObjectMessage;
import com.jparrack.catchat.view.StoryViewer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jparrack.catchat.ui.login.LoginFragment.EMAIL;

/**
 * Created by jparrack on 3/3/17
 */

public class ChatFragment extends BaseFragment implements FirebaseListenMessage.OnListenMessage {
    private static final String TAG = ChatFragment.class.getName();
    private ConversationsAdapter mAdapter;
    public static List<Chat> listChat = new ArrayList<>();
    public static ChatFragment create() {
        return new ChatFragment();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_chat;
    }

    @Override
    public void inOnCreateView(View root, @Nullable ViewGroup container, Bundle savedInstanceState) {
        RecyclerView list = (RecyclerView) findViewById(R.id.fc_recycler_view);
        new FirebaseListenMessage(ChatFragment.this);
        list.setLayoutManager(new LinearLayoutManager(getActivity()));
        list.setAdapter(mAdapter = new ConversationsAdapter());
        mAdapter.setItems(listChat);
        /*DataProvider dataProvider = new TestDataProvider();

        //dataProvider.getConversations(Constants.USER_ID, new DataCallback<List<Chat>>() {

            @Override
            public void onDataFetched(List<Chat> data, Exception error) {
                Log.d(TAG, "onDataFetched: " + data.size());
                mAdapter.setItems(data);
            }

        });*/

        mAdapter.setOnConversationClickedListener(new ConversationsAdapter.OnConversationClickedListener() {

            @Override
            public void onConversationClicked(final int index, Chat conversation, Point point) {
                if(getActivity() instanceof MainActivity) {
                    if(conversation.hasUnwatchedItems()) {
                        ((MainActivity) getActivity()).showStory(conversation, point, new StoryViewer.StoryViewListener() {
                            @Override
                            public void onStoryHidden() {
                                mAdapter.notifyItemChanged(index);
                            }
                        });
                    }
                }
            }

        });
    }


    private void generaMessage(){
        listChat.clear();
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for(ObjectMessage objectMessage: FirebaseListenMessage.listMessage){
            if(objectMessage.getEmailReceive().equals(EMAIL)){
                if(!hashMap.containsKey(objectMessage.getEmailSend())) {
                    List<String> list = new ArrayList<>();
                    for (ObjectMessage object : FirebaseListenMessage.listMessage) {
                        if (object.getEmailSend().equals(objectMessage.getEmailSend())) {
                            list.add(object.getMessage());
                        }
                    }
                    hashMap.put(objectMessage.getEmailSend(), list);
                }
            }
        }


        for(Map.Entry<String, List<String>> entry : hashMap.entrySet()) {
            Chat chat = new Chat();
            String key = entry.getKey();
            List<String> value = entry.getValue();

            List<ChatItem> messages = new ArrayList<>();
            for(String s: value){
                ChatItem chatMessage = new ChatItem();
                chatMessage.setMessage(s);
                messages.add(chatMessage);
            }
            chat.setChatMessages(messages);
            listChat.add(chat);
        }
    }


    @Override
    public void listenMessage(String emailSend, String message) {
        Log.d(TAG, "listenMessage: ");
        generaMessage();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mAdapter.notifyDataSetChanged();
            }
        });
    }
}
