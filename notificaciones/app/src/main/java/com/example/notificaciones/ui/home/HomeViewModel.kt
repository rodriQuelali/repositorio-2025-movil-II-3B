package com.example.notificaciones.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }

    private val _textMensaje = MutableLiveData<String>().apply {
        value = "Hello Alan Brito....."
    }

    val text: LiveData<String> = _text
    val textMensaje: LiveData<String> = _textMensaje

}