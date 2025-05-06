package com.example.chatwhatssap.data.model

import com.google.firebase.Timestamp

data class Message(
    var id: String = "",
    var sendId: String = "",
    var message: String = "",
    var timestamp: Timestamp = Timestamp.now()
)
