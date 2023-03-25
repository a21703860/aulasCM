package com.example.aulascm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aulascm.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(
            R.layout.fragment_history, container, false
        )
        binding = FragmentHistoryBinding.bind(view)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        requireActivity().title = "Histórico"
        val builder = StringBuilder()
        val history = Calculator.history
        history.forEach {builder.append("${it.expression}=${it.result}\n")}
        binding.tvHistory.text = builder.toString()
    }

}