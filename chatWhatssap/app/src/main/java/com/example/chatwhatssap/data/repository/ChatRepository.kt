package com.example.chatwhatssap.data.repository

import android.util.Log
import com.example.chatwhatssap.data.model.Message
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.FirebaseFirestore

class ChatRepository {

    private val firestore = FirebaseFirestore.getInstance()
    private val messagesRef = firestore.collection("message")

    // Enviar mensaje
    fun sendMessage(message: Message) {
        messagesRef.add(message)
    }

    // Escuchar mensajes en tiempo real
    fun getMessages(onMessageReceived: (List<Message>) -> Unit) {
        messagesRef.addSnapshotListener { snapshot, error ->
            Log.e("ChatRepository", "entroooooooooooooooooooooo")
            if (error != null) {
                Log.e("ChatRepository", "Error al obtener los mensajes: ${error.message}")
                return@addSnapshotListener
            }

            val messages = snapshot?.documents?.mapNotNull { it.toObject(Message::class.java) } ?: emptyList()
            Log.e("ChatRepository", "${messages}")
            onMessageReceived(messages)

        }
    }

}