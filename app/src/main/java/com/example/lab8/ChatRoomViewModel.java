package com.example.lab8;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;

public class ChatRoomViewModel extends ViewModel {
    // LiveData for a list of chat messages
    public MutableLiveData<ArrayList<ChatMessage>> messages = new MutableLiveData<>();

    // LiveData for a selected chat message
    public MutableLiveData<ChatMessage> selectedMessage = new MutableLiveData<>();
}
