package com.vinay.byjus.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vinay.byjus.ui.home.HeadlinesDataSource
import com.vinay.byjus.response.headlines.Article
import com.vinay.byjus.network.RequestStatus
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created on 4/26/2021.
 *
 * @author Vinay
 *
 * vinay6kr@gmail.com
 */
class HeadlinesViewModel @Inject constructor(private val headlinesRepo: HeadlinesDataSource) :
    ViewModel() {

    private val _headlinesList = MutableLiveData<List<Article>?>()
    val headlinesList: LiveData<List<Article>?>
        get() = _headlinesList

    fun getHeadlines() {
        viewModelScope.launch {
            val response = headlinesRepo.getHeadlines()
            when (response) {
                is RequestStatus.Success -> {
                    val list = response.data
                    _headlinesList.value = list
                }

                is RequestStatus.Error -> {
                    if (response.exception !is CancellationException) {
                        _headlinesList.value = null
                    }
                }
            }
        }
    }
}