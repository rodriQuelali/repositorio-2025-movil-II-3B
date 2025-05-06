package com.example.chatwhatssap.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chatwhatssap.data.model.Message
import com.example.chatwhatssap.data.repository.ChatRepository

class ChatViewModel : ViewModel(){

    private  val repository= ChatRepository()
    private val _messages = MutableLiveData<List<Message>>()
    val messages: LiveData<List<Message>> = _messages

    fun sendMessage(message: Message){
        repository.sendMessage(message)
    }

    fun loadMessage(){
        repository.getMessages { newMessage ->
            Log.e("ViewModel", "${newMessage}")
            _messages.value = newMessage
        }
    }

}