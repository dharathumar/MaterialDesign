package com.example.materialdesign.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.materialdesign.R
import com.example.materialdesign.ui.main.adapter.LocalDBAdapter
import com.example.materialdesign.ui.main.viewmodel.UserViewModel


class DataFragment : Fragment() {

    lateinit var recyclerViewAdapter: LocalDBAdapter
    lateinit var viewModel: UserViewModel

    companion object {
        @JvmStatic
        fun newInstance() =
            DataFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {


        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

       val view= inflater.inflate(R.layout.fragment_localdb, container, false)
        initRecyclerview(view)
        return view
    }
    private fun initRecyclerview(view: View) {

        //lateinit var userviewModal: UserViewModel
        val userRV= view.findViewById<RecyclerView>(R.id.usersRV)
        userRV.layoutManager = LinearLayoutManager(activity)
        userRV.addItemDecoration(
            DividerItemDecoration(
                userRV.getContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        val userRVAdapter = LocalDBAdapter()
        userRV.adapter=userRVAdapter

        viewModel=ViewModelProvider(this).get(UserViewModel::class.java)

        viewModel.allUser.observe(viewLifecycleOwner , Observer { list ->
            list?.let {
                // on below line we are updating our list.
                userRVAdapter.updateList(it)
            }
        })
    }

}