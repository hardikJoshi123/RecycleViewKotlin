package com.arc.test.endpoint

import com.arc.test.model.ListViewModel
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {
    fun inject(service: ImagesService)
    fun inject(viewModel: ListViewModel)
}