package com.example.materialdesign.ui.main.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.materialdesign.R
import com.example.materialdesign.data.api.ServiceBuilder
import com.example.materialdesign.data.model.public
import com.example.materialdesign.ui.main.adapter.ApiAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class APIFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_api, container, false)
        loadPublics(view)
        return view
    }

    private fun loadPublics(view: View) {
        //initiate the service


        val requestCall = ServiceBuilder.requestCall
        //val requestCall =destinationService.getPublicList()
        //make network call asynchronously

        requestCall.enqueue(object : Callback<public> {
            override fun onResponse(call: Call<public>, response: Response<public>) {
                Log.d("Response", "onResponse: ${response.body()}")
                if (response.isSuccessful) {
                    val publiclist = response.body()!!
                    for (public in publiclist.entries) {
                        Log.d("Response", "publiclist size : ${public.Auth}")
                    }

                    val recyclerview = view.findViewById<RecyclerView>(R.id.RvApi)
                    recyclerview.addItemDecoration(
                        DividerItemDecoration(
                            recyclerview.getContext(),
                            DividerItemDecoration.VERTICAL
                        )
                    )
                    recyclerview.apply {
                        setHasFixedSize(true)
                        layoutManager = GridLayoutManager(context, 1)
                        adapter = ApiAdapter(response.body()!!)
                    }
                } else {
                    Toast.makeText(
                        context,
                        "Something went wrong ${response.message()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<public>, t: Throwable) {
                Toast.makeText(context, "Something went wrong $t", Toast.LENGTH_SHORT).show()
            }
        })

    }


    companion object {

        @JvmStatic
        fun newInstance() =
            APIFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}