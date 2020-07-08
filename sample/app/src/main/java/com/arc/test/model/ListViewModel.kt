package com.arc.test.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arc.test.endpoint.DaggerApiComponent
import com.arc.test.endpoint.ImagesService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ListViewModel : ViewModel() {
    @Inject
    lateinit var usersService: ImagesService
    init {
        DaggerApiComponent.create().inject(this)
    }
    private val disposable = CompositeDisposable()
    val images = MutableLiveData<List<ImageItem>>()
    val imageLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()
    fun refresh() {
        fetchImages()
    }
    private fun fetchImages() {
        loading.value = true
        disposable.add(
            usersService.getUsers()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<Data>() {
                    override fun onSuccess(data: Data) {
                        Log.d("error ", "" + data)
                        images.value = data.images
                        imageLoadError.value = false
                        loading.value = false
                    }
                    override fun onError(e: Throwable) {
                        imageLoadError.value = true
                        loading.value = false
                        Log.d("error ", "" + e.printStackTrace())
                    }
                })
        )
    }
    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}