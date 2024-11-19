package com.example.lab8;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ChatDetailFragment extends Fragment {

    private static final String ARG_MESSAGE = "message";

    private ChatMessage chatMessage;

    public ChatDetailFragment() {
        // Required empty public constructor
    }

    public static ChatDetailFragment newInstance(ChatMessage message) {
        ChatDetailFragment fragment = new ChatDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_MESSAGE, message); // Assuming ChatMessage implements Parcelable
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            chatMessage = getArguments().getParcelable(ARG_MESSAGE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message_chat, container, false);

        TextView messageContent = view.findViewById(R.id.message_content_detail);
        if (chatMessage != null) {
            messageContent.setText(chatMessage.getMessageContent());
        }

        return view;
    }
}
