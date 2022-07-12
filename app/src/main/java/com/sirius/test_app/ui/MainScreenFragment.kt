package com.sirius.test_app.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sirius.test_app.R
import com.sirius.test_app.databinding.FragmentMainScreenBinding

class MainScreenFragment : Fragment() {

    private var _binding :FragmentMainScreenBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentMainScreenBinding.inflate(layoutInflater,container,false)
        return binding.root
    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}