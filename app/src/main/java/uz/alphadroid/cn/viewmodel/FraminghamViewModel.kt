package uz.alphadroid.cn.viewmodel

import kotlinx.coroutines.flow.MutableSharedFlow
import uz.alphadroid.cn.data.remote.response.FraminghamResponse
import uz.alphadroid.cn.data.remote.response.Score2Response

interface FraminghamViewModel {

    val errorMessageSharedFlow: MutableSharedFlow<String>
    val notConnectionSharedFlow: MutableSharedFlow<Unit>
    val succesSharedFlow: MutableSharedFlow<FraminghamResponse>
    val progressSharedFlow: MutableSharedFlow<Boolean>
    fun sendData(
        gender: String,
        age: String,
        t_cholesterol: String,
        LVPV_cholesterol: String,
        blood_pressure: String,
        smoke: String,
        Treatment: String,
    )

}