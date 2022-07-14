package com.sirius.test_app.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.sirius.test_app.R
import com.sirius.test_app.databinding.FragmentMainScreenBinding
import com.sirius.test_app.domain.MainScreenViewModel
import kotlin.math.roundToInt

class MainScreenFragment : Fragment() {

    private var _binding :FragmentMainScreenBinding? = null
    private val binding get() = _binding!!

    private var ratingRecViewAdapter : RatingRecViewAdapter? = RatingRecViewAdapter()
    private var categoryRecViewAdapter : CategoryRecViewAdapter? = CategoryRecViewAdapter()
    private var commentsRecViewAdapter : CommentsRecViewAdapter? = null


    private val mainScreenViewModel : MainScreenViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentMainScreenBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //image
        Glide.with(this)
            .load(mainScreenViewModel.getGameImage())
            .into(binding.banner)

        //logo
        Glide.with(this)
            .load(mainScreenViewModel.getGameLogo())
            .into(binding.icon)

        //name and GradeCnt x2
        binding.title.text = mainScreenViewModel.getGameName()
        binding.downloads.text = mainScreenViewModel.getGradeCnt()
        binding.textViewReviews.text = mainScreenViewModel.getGradeCnt() + " Reviews"

        //rating recView x2
        val ratingRecView = binding.rating
        ratingRecView.adapter = ratingRecViewAdapter
        ratingRecView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

        val recyclerViewRating = binding.recyclerViewRating
        recyclerViewRating.adapter = ratingRecViewAdapter
        recyclerViewRating.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        ratingRecViewAdapter!!.setRating(mainScreenViewModel.getGameRating().roundToInt())


        //category recView
        val categoryRecView = binding.categoryRecView
        categoryRecView.adapter = categoryRecViewAdapter
        categoryRecView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        categoryRecViewAdapter!!.setCategory(mainScreenViewModel.getTags())

        //description textview
        binding.description.text = mainScreenViewModel.getDescription()

        //float rating
        binding.floatRating.text = mainScreenViewModel.getGameRating().toString()

        //review recView
        commentsRecViewAdapter = CommentsRecViewAdapter(requireContext())
        val reviewRecView = binding.commentsRecView
        reviewRecView.adapter = commentsRecViewAdapter
        reviewRecView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        commentsRecViewAdapter!!.setReview(mainScreenViewModel.getReviews())


        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        _binding = null
        ratingRecViewAdapter = null
        categoryRecViewAdapter = null
        commentsRecViewAdapter = null
        super.onDestroy()
    }


}