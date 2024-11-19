package com.example.lab8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {

    private List<ChatMessage> messages;
    private OnItemClickListener listener;

    // Define an interface for the click listener
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    // Set the item click listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the item view
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item, parent, false);
        return new ChatViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ChatViewHolder holder, int position) {
        ChatMessage message = messages.get(position);
        holder.bind(message);

        // Set the click listener on the itemView
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(v, position); // Notify the activity when a message is clicked
            }
        });
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    // ViewHolder class for chat messages
    public static class ChatViewHolder extends RecyclerView.ViewHolder {

        private TextView messageContent;

        public ChatViewHolder(View itemView) {
            super(itemView);
            messageContent = itemView.findViewById(R.id.message_content);
        }

        public void bind(ChatMessage message) {
            messageContent.setText(message.getMessageContent());
        }
    }

    // Method to get the message at a specific position
    public ChatMessage getMessageAt(int position) {
        return messages.get(position);
    }
}
