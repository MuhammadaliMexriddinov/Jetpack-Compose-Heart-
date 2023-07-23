package uz.alphadroid.cn.viewmodel

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.flow.MutableSharedFlow

interface YurakViewModel {
    val errorMessageSharedFlow: MutableSharedFlow<String>
    val notConnectionSharedFlow: MutableSharedFlow<Unit>
    val succesSharedFlow: MutableSharedFlow<String>
    val progressSharedFlow: MutableSharedFlow<Boolean>
    fun sendData(
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
    )
}