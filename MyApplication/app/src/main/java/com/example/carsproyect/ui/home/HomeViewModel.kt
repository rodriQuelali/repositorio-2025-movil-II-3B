package com.example.carsproyect.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carsproyect.model.cars.Car
import com.example.carsproyect.model.cars.CarRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val carRepository: CarRepository) : ViewModel() {

    val getAll: LiveData<List<Car>?> get() = carRepository.cars
    val error:LiveData<String> get() = carRepository.error

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    fun getCars() {
        viewModelScope.launch {
            carRepository.getCars()
        }
    }
}