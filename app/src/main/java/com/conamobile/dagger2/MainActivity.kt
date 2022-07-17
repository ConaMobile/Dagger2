package com.conamobile.dagger2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.conamobile.dagger2.databinding.ActivityMainBinding
import com.conamobile.dagger2.utils.UserResource
import com.conamobile.dagger2.viewmodels.UserViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {

    @Inject
    lateinit var userViewModel: UserViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        launch {
            userViewModel.getStateFlow().collect {
                when (it) {
                    is UserResource.Loading -> {}
                    is UserResource.Error -> {}
                    is UserResource.Success -> {
                        Log.d("@@@", it.list.toString())
                    }
                }
            }
        }
    }

    override val coroutineContext: CoroutineContext
        get() = Job()
}