package com.example.lab8;

import android.os.Parcel;
import android.os.Parcelable;

public class ChatMessage implements Parcelable {

    private String userName;
    private String messageContent;

    // Constructor
    public ChatMessage(String userName, String messageContent) {
        this.userName = userName;
        this.messageContent = messageContent;
    }

    // Getter for userName
    public String getUserName() {
        return userName;
    }

    // Setter for userName
    public void setUserName(String userName) {
        this.userName = userName;
    }

    // Getter for messageContent
    public String getMessageContent() {
        return messageContent;
    }

    // Setter for messageContent
    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    // Parcelable implementation (optional but required for passing between activities/fragments)
    protected ChatMessage(Parcel in) {
        userName = in.readString();
        messageContent = in.readString();
    }

    public static final Creator<ChatMessage> CREATOR = new Creator<ChatMessage>() {
        @Override
        public ChatMessage createFromParcel(Parcel in) {
            return new ChatMessage(in);
        }

        @Override
        public ChatMessage[] newArray(int size) {
            return new ChatMessage[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userName);
        dest.writeString(messageContent);
    }
}
