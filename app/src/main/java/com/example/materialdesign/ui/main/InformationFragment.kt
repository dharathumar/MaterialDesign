package com.example.materialdesign.ui.main

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.example.materialdesign.R
import com.example.materialdesign.data.entity.Users
import com.example.materialdesign.ui.main.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_information.*


class InformationFragment : Fragment() {
    lateinit var userviewModal: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_information, container, false)
        val btn_save: Button? = view?.findViewById(R.id.btn_save)
        btn_save?.setOnClickListener { v: View -> buttonClicked(v) }
        return view
    }

    private fun buttonClicked(v: View) {
        userviewModal = ViewModelProvider(
            this, ViewModelProvider.AndroidViewModelFactory.getInstance(application = Application())
        ).get(UserViewModel::class.java)
        val userName = edt_name.text.toString()
        val userNumber = edt_number.text.toString()
        val userCity = edt_city.text.toString()
        val userState = edt_state.text.toString()
        if (userName.isNotEmpty() && userNumber.isNotEmpty()) {
            userviewModal.insertUserInfo(Users(0, userName, userNumber, userCity, userState))
            //Toast.makeText(this, "$userName Added", Toast.LENGTH_LONG).show()
            edt_name.setText("")
            edt_number.setText("")
            edt_city.setText("")
            edt_state.setText("")
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            InformationFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}