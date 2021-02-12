package com.semicolon.ddyzd_android.ul.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.semicolon.ddyzd_android.R
import com.semicolon.ddyzd_android.adapter.ClubAdapter
import com.semicolon.ddyzd_android.databinding.ClublistBinding
import com.semicolon.ddyzd_android.model.ClubProfiles
import com.semicolon.ddyzd_android.ul.activity.MainActivity
import com.semicolon.ddyzd_android.viewmodel.ClubListViewModel


class ClubList(val navigator:MainActivity): Fragment() {

    //lateinit var viewModel : Frag1ViewModel
    private lateinit var binding : ClublistBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val viewModel = ClubListViewModel(navigator)
        //binding =Frag1Binding.inflate(inflater,container,false) // 이거는 안됨
        binding= DataBindingUtil.inflate(inflater, R.layout.clublist,container,false)
        binding.frag1 = viewModel
        binding.lifecycleOwner = this
        val view = inflater.inflate(R.layout.clublist, container,false) // 이거는 됨

        val list = view?.findViewById<RecyclerView>(R.id.rv_proflie)


        viewModel.liveData1.observe(viewLifecycleOwner,Observer{
            val proflieList = viewModel.proflieList
            list?.layoutManager = LinearLayoutManager(this@ClubList.context, LinearLayoutManager.VERTICAL,false)
            list?.setHasFixedSize(true)
            list?.adapter = ClubAdapter(clubAdapter = proflieList as ArrayList<ClubProfiles>,navigator = navigator)
        })

        val bottom =view.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottom.setOnNavigationItemSelectedListener(viewModel.bottomNavigationView)
        return view
    }


}