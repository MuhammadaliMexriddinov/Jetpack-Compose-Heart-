package uz.alphadroid.cn.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import uz.alphadroid.cn.data.remote.response.ScoreResponse
import uz.alphadroid.cn.repository.impl.ScoreRepositoryImpl
import uz.alphadroid.cn.repository.impl.YurakRepositoryImpl
import uz.alphadroid.cn.utils.hasConnection
import uz.alphadroid.cn.viewmodel.ScoreViewModel

class ScoreViewModelImpl :ScoreViewModel , ViewModel() {
    private val repository =  ScoreRepositoryImpl()
    override val errorMessageSharedFlow: MutableSharedFlow<String> = MutableSharedFlow()
    override val notConnectionSharedFlow: MutableSharedFlow<Unit> = MutableSharedFlow()
    override val succesSharedFlow: MutableSharedFlow<ScoreResponse> = MutableSharedFlow()
    override val progressSharedFlow: MutableSharedFlow<Boolean> = MutableSharedFlow()

    override fun sendData(
        gender: String,
        age: String,
        cholesterol: String,
        blood_pressure: String,
        smoke: String,
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
                cholesterol,
                blood_pressure,
                smoke
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