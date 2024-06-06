package com.example.animevault.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.animevault.R
import com.example.animevault.databinding.FragmentFirstBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class  FirstFragment : Fragment() {

    private lateinit var viewBinding: FragmentFirstBinding
    private val viewModel by viewModel<FirstFragViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return FragmentFirstBinding.inflate(layoutInflater, container, false).also {
            viewBinding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.isAuthed.observe(viewLifecycleOwner) { isAuthed ->
            if (isAuthed) {
                findNavController().navigate(R.id.action_firstFragment_to_authFragment)
            }
        }

        viewModel.checkLogin()

//        if (viewModel.checkLogin()) {
//            // User is logged in, load MainFragment
//            findNavController().navigate(R.id.action_firstFragment_to_animeFragment)
//        }

        viewBinding.btnLogin.setOnClickListener {
            it.findNavController().navigate(R.id.action_firstFragment_to_loginFragment)
        }
    }

}