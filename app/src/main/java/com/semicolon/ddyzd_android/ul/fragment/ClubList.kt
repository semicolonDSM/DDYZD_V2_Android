package com.semicolon.ddyzd_android.ul.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayout
import com.semicolon.ddyzd_android.ActivityNavigator
import com.semicolon.ddyzd_android.R
import com.semicolon.ddyzd_android.adapter.ClubAdapter
import com.semicolon.ddyzd_android.databinding.FragmentClublistBinding
import com.semicolon.ddyzd_android.model.ClubProfiles
import com.semicolon.ddyzd_android.ul.activity.MainActivity
import com.semicolon.ddyzd_android.viewmodel.ClubListViewModel


class ClubList: Fragment() {

    lateinit var mContext: Context
    lateinit var binding : FragmentClublistBinding
    lateinit var navigator: MainActivity
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        navigator=ActivityNavigator.mainActivity
        val viewModel = ClubListViewModel(navigator)
        mContext=navigator.applicationContext
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_clublist,container,false)
        binding.vm = viewModel
        binding.clubTabLayout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {
                viewModel.changeSelcted(tab!!.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewModel.changeSelcted(tab!!.position)
            }

        })
        binding.lifecycleOwner = this
        val list = binding.clubListRv
        viewModel.liveData1.observe(viewLifecycleOwner,Observer{
            val proflieList = viewModel.proflieList
            list.layoutManager = LinearLayoutManager(this@ClubList.context, LinearLayoutManager.VERTICAL,false)
            list.setHasFixedSize(true)
            list.adapter = ClubAdapter(clubAdapter = proflieList as ArrayList<ClubProfiles>,
                viewModel = viewModel
            )
        })

        return binding.root
    }




}