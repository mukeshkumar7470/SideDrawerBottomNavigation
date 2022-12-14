package com.mukesh.sidedrawerbottomnavigation.ui.account


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.mukesh.sidedrawerbottomnavigation.R
import com.mukesh.sidedrawerbottomnavigation.databinding.FragmentAccountsBinding
import com.mukesh.sidedrawerbottomnavigation.databinding.FragmentDashboardBinding
import com.mukesh.sidedrawerbottomnavigation.ui.dashboard.DashboardViewModel

/**
 * AccountsFragment
 */

class AccountsFragment : Fragment() {
    private var _binding: FragmentAccountsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val accountViewModel =
            ViewModelProvider(this).get(AccountViewModel::class.java)

        _binding = FragmentAccountsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.tvAccount
        accountViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
