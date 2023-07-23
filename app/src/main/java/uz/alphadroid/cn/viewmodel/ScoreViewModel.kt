package uz.alphadroid.cn.viewmodel

import kotlinx.coroutines.flow.MutableSharedFlow
import uz.alphadroid.cn.data.remote.response.ScoreResponse

interface ScoreViewModel {
    val errorMessageSharedFlow: MutableSharedFlow<String>
    val notConnectionSharedFlow: MutableSharedFlow<Unit>
    val succesSharedFlow: MutableSharedFlow<ScoreResponse>
    val progressSharedFlow: MutableSharedFlow<Boolean>
    fun sendData(
        gender: String,
        age: String,
        cholesterol: String,
        blood_pressure: String,
        smoke: String,
    )
}