package uz.alphadroid.cn.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import uz.alphadroid.cn.repository.impl.YurakRepositoryImpl
import uz.alphadroid.cn.utils.hasConnection
import uz.alphadroid.cn.viewmodel.YurakViewModel

class YurakViewModelImpl:YurakViewModel , ViewModel(){

    private val repository =  YurakRepositoryImpl()
    override val errorMessageSharedFlow: MutableSharedFlow<String> = MutableSharedFlow()
    override val notConnectionSharedFlow: MutableSharedFlow<Unit> = MutableSharedFlow()
    override val succesSharedFlow: MutableSharedFlow<String> = MutableSharedFlow()
    override val progressSharedFlow: MutableSharedFlow<Boolean> = MutableSharedFlow()

    override fun sendData(
        age: String,
        sex: String,
        cp: String,
        trestbps: String,
        chol: String,
        fbs: String,
        restcg: String,
        thalach: String,
        exang: String,
        oldpeak: String,
        slope: String,
        ca: String,
        tha: String,
    ) {



        viewModelScope.launch {

            progressSharedFlow.emit(true)
            if (!hasConnection()) {
                progressSharedFlow.emit(false)
                return@launch
            }

            repository.sendData(
                age,
                sex,
                cp,
                trestbps,
                chol,
                fbs,
                restcg,
                thalach,
                exang,
                oldpeak,
                slope,
                ca,
                tha
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