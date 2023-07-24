package uz.alphadroid.cn.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import uz.alphadroid.cn.data.remote.response.FraminghamResponse
import uz.alphadroid.cn.data.remote.response.Score2Response
import uz.alphadroid.cn.repository.impl.FraminghamRepositoryImpl
import uz.alphadroid.cn.repository.impl.Score2RepositoryImpl
import uz.alphadroid.cn.utils.hasConnection
import uz.alphadroid.cn.viewmodel.FraminghamViewModel

class FraminghamViewModelImpl  : FraminghamViewModel , ViewModel() {
    private val repository =  FraminghamRepositoryImpl()
    override val errorMessageSharedFlow: MutableSharedFlow<String> = MutableSharedFlow()
    override val notConnectionSharedFlow: MutableSharedFlow<Unit> = MutableSharedFlow()
    override val succesSharedFlow: MutableSharedFlow<FraminghamResponse> = MutableSharedFlow()
    override val progressSharedFlow: MutableSharedFlow<Boolean> = MutableSharedFlow()

    override fun sendData(
        gender: String,
        age: String,
        t_cholesterol: String,
        LVPV_cholesterol: String,
        blood_pressure: String,
        smoke: String,
        Treatment: String,
    ) {
        viewModelScope.launch {

            progressSharedFlow.emit(true)
            if (!hasConnection()) {
                progressSharedFlow.emit(false)
                return@launch
            }
            repository.sendData(
                gender,
                age,
                t_cholesterol,
                LVPV_cholesterol,
                blood_pressure,
                smoke,
                Treatment,
            ).flowOn(Dispatchers.Main).collect {
                it.onSuccess {
                    progressSharedFlow.emit(false)
                    succesSharedFlow.emit(it)
                }

                it.onFailure {
                    progressSharedFlow.emit(true)
                    errorMessageSharedFlow.emit("NO INTERNET")
                }
            }
        }
    }
}