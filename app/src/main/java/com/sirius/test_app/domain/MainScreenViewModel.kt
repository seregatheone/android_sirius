package com.sirius.test_app.domain

import androidx.lifecycle.ViewModel
import com.sirius.test_app.data.DataModel
import com.sirius.test_app.data.ReviewModel

class MainScreenViewModel : ViewModel() {
    private val dataModel = DataModel()
    fun getGameImage(): String = dataModel.image
    fun getGameLogo(): String = dataModel.logo
    fun getGameName(): String = dataModel.name
    fun getGradeCnt(): String = dataModel.gradeCnt
    fun getGameRating(): Float = dataModel.rating
    fun getTags():List<String> = dataModel.tags
    fun getDescription(): String = dataModel.description
    fun getReviews() : List<ReviewModel> = dataModel.reviews

}