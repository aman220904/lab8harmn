package com.example.lab8;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.fragment.app.FragmentTransaction;

public class ChatRoomActivity extends AppCompatActivity {

    private ChatRoomViewModel chatModel;
    private RecyclerView recyclerView;
    private ChatAdapter chatAdapter; // Assuming you have a ChatAdapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room);

        // Initialize ViewModel
        chatModel = new ViewModelProvider(this).get(ChatRoomViewModel.class);

        // Set up RecyclerView and Adapter
        recyclerView = findViewById(R.id.recycler_view);
        chatAdapter = new ChatAdapter(); // Your adapter should handle displaying the messages
        recyclerView.setAdapter(chatAdapter);

        // Observe the selectedMessage LiveData
        chatModel.selectedMessage.observe(this, (newMessageValue) -> {
            if (newMessageValue != null) {
                // Handle selected message, for example, display in a Fragment
                openMessageDetailsFragment(newMessageValue);
            }
        });

        // Set click listener for the RecyclerView items
        chatAdapter.setOnItemClickListener((view, position) -> {
            // Get the selected message from the list
            ChatMessage selectedMessage = chatAdapter.getMessageAt(position);
            chatModel.selectedMessage.postValue(selectedMessage); // Post selected message to ViewModel
        });
    }

    // Method to open the fragment to show the selected message details
    private void openMessageDetailsFragment(ChatMessage message) {
        // Create a new Fragment to show the details
        MessageDetailFragment fragment = MessageDetailFragment.newInstance(message);

        // Begin the transaction to add the fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment); // Assuming you have a container for fragments
        transaction.addToBackStack(null); // Optionally add the transaction to back stack
        transaction.commit();
    }
}
