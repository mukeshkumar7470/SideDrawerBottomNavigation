package com.mukesh.sidedrawerbottomnavigation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mukesh.sidedrawerbottomnavigation.MainActivity
import com.mukesh.sidedrawerbottomnavigation.R
import com.mukesh.sidedrawerbottomnavigation.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var navController: NavController
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = findNavController() //Initialising navController

        //Initialising button click event listener
        binding.homeNextFragBtn.setOnClickListener(this)
        binding.homeCloseAppBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) { //When click occurs this function is triggered
        when(v?.id) { //Check for the id of the view i which click event happened
            R.id.home_next_frag_btn -> goToNextFragment()
            R.id.home_close_app_btn -> closeApp()
        }
    }

    private fun goToNextFragment() {
        val action = R.id.action_homeFragment_to_profileFragment //if needed pass values to frag here NB: add that arguments to nav_graph also
        navController.navigate(action) //navigation
    }

    private fun closeApp() {
        (activity as MainActivity).exitApp()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}