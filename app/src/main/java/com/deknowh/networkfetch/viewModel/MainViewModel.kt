package com.deknowh.networkfetch.viewModel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deknowh.networkfetch.data.ToDo
import com.deknowh.networkfetch.module.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.io.IOException


class MainViewModel: ViewModel() {
    private val apiService = RetrofitInstance.api
    val todo : MutableStateFlow<List<ToDo>> = MutableStateFlow<List<ToDo>>(emptyList())
     fun getToDoList() {
        viewModelScope.launch {
            try {
                val response = apiService.getTodo()
                if (response.isNotEmpty()) {
                    todo.value = response
                }
            } catch (e: Exception) {
                when(e) {
                    is IOException -> {
                        Log.e("IOError", "Unknown error occurred")
                    }
                }
            }
        }
    }
}