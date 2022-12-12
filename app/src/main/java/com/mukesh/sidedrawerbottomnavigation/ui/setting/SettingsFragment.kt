package com.mukesh.sidedrawerbottomnavigation.ui.setting


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.mukesh.sidedrawerbottomnavigation.R
import com.mukesh.sidedrawerbottomnavigation.databinding.FragmentAccountsBinding
import com.mukesh.sidedrawerbottomnavigation.databinding.FragmentSettingsBinding
import com.mukesh.sidedrawerbottomnavigation.ui.account.AccountViewModel

/**
 * SettingsFragment
 */

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val settingViewModel =
            ViewModelProvider(this).get(SettingViewModel::class.java)

        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val root: View = binding.root

       /* val textView: TextView = binding.text_dashboard
        settingViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
