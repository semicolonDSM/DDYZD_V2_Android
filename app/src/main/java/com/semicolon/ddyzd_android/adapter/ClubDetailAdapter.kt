package com.semicolon.ddyzd_android.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.semicolon.ddyzd_android.databinding.ItemClubDetailHeaderBinding
import com.semicolon.ddyzd_android.databinding.ItemClubDetailMembersBinding
import com.semicolon.ddyzd_android.databinding.ItemFeedBinding
import com.semicolon.ddyzd_android.databinding.ItemImageFeedBinding
import com.semicolon.ddyzd_android.model.ClubProfiles
import com.semicolon.ddyzd_android.model.MainFeedData
import com.semicolon.ddyzd_android.viewmodel.MainFeedViewModel

class ClubDetailAdapter(private val feeds:MutableLiveData<List<MainFeedData>>,private val club:ClubProfiles,private val feedViewModel: MainFeedViewModel) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val TYPE_HEADER=0
    private val TYPE_MEMBER=1
    private val TYPE_FEED=2
    private val TYPE_IMAGE_FEED=3
    lateinit var pageAdapter:FeedPagerAdapter

    inner class HeaderDetailViewHolder(val binding: ItemClubDetailHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(club:ClubProfiles){
            binding.club=club
            binding.executePendingBindings()
        }
    }

    inner class MembersDetailViewHolder(val binding: ItemClubDetailMembersBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(){

        }
    }

    inner class ClubFeedViewHolder(val binding: ItemFeedBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int){
            binding.vm=feedViewModel
            binding.position = position-2
            binding.executePendingBindings()
        }
    }

    inner class ClubImageFeedViewHolder(val binding: ItemImageFeedBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int){
            pageAdapter=FeedPagerAdapter(feeds.value?.get(position-1)!!.media,feedViewModel,position-1,binding)
            binding.vm = feedViewModel
            binding.position = position-2
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            TYPE_HEADER->{
                val binding=ItemClubDetailHeaderBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                HeaderDetailViewHolder(binding)
            }
            TYPE_MEMBER->{
                val binding=ItemClubDetailMembersBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                MembersDetailViewHolder(binding)
            }
            TYPE_IMAGE_FEED->{
                val binding=ItemImageFeedBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                ClubImageFeedViewHolder(binding)
            }
            else->{
                val binding=ItemFeedBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                ClubFeedViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int {
        return if(feeds.value!=null){
            feeds.value!!.size+2
        }else{
            2
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(position==0){
            (holder as HeaderDetailViewHolder).bind(club)
        }
        else if(position==1){
            (holder as MembersDetailViewHolder).bind()
        }
        else{
            val obj = feeds.value?.get(position-2)
            if(obj!=null){
                if (obj.media.size>0) {
                    (holder as ClubFeedViewHolder).bind(position)
                } else {
                    (holder as ClubImageFeedViewHolder).bind(position)
                }
            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        return if(position==0){
            TYPE_HEADER
        }else if(position==1){
            TYPE_MEMBER
        }else if(feeds.value?.get(position-2)?.media?.size!! >0){
            TYPE_IMAGE_FEED
        }else{
            TYPE_FEED
        }
    }
}