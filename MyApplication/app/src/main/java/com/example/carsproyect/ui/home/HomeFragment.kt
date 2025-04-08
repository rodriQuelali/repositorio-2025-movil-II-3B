package com.example.carsproyect.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.carsproyect.databinding.FragmentHomeBinding
import com.example.carsproyect.model.cars.CarDataSource
import com.example.carsproyect.model.cars.CarRepository

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val factory = HomeViewModelFactory(CarRepository(CarDataSource(requireContext())))
        homeViewModel = ViewModelProvider(this, factory).get(HomeViewModel::class.java)

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        observandoHttp()
        homeViewModel.getCars()
        return root
    }


    private fun observandoHttp(){
        homeViewModel.getAll.observe(this){ posts ->
            posts?.forEach {
                Log.d("Cars","Datos de la HTTP: ${it}")
            }
        }
        homeViewModel.error.observe(this){errors ->
            errors?.let {
                Log.d("Cars","Eroor en la peticion: ${it}")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}