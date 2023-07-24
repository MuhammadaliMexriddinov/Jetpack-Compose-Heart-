package uz.alphadroid.cn.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import uz.alphadroid.cn.data.remote.response.Score2Response
import uz.alphadroid.cn.repository.impl.Score2RepositoryImpl
import uz.alphadroid.cn.utils.hasConnection
import uz.alphadroid.cn.viewmodel.Score2ViewModel

class Score2ViewModelImpl  :Score2ViewModel , ViewModel(){

    private val repository =  Score2RepositoryImpl()
    override val errorMessageSharedFlow: MutableSharedFlow<String> = MutableSharedFlow()
    override val notConnectionSharedFlow: MutableSharedFlow<Unit> = MutableSharedFlow()
    override val succesSharedFlow: MutableSharedFlow<Score2Response> = MutableSharedFlow()
    override val progressSharedFlow: MutableSharedFlow<Boolean> = MutableSharedFlow()

    override fun sendData(
        age_user: String,
        gender_user: String,
        smoke: String,
        total_cholesterol: String,
        Diabetes: String,
        S_Blood_P: String,
        HDL_cholesterol: String,
        T_hypertension: String,
        country_user: String,
    ) {
        viewModelScope.launch {

            progressSharedFlow.emit(true)
            if (!hasConnection()) {
                progressSharedFlow.emit(false)
                return@launch
            }
            repository.sendData(
                age_user,
                gender_user,
                smoke,
                total_cholesterol,
                Diabetes,
                S_Blood_P,
                HDL_cholesterol,
                T_hypertension,
                country_user,
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