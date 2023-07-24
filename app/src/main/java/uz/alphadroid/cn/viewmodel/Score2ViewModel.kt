package uz.alphadroid.cn.viewmodel

import kotlinx.coroutines.flow.MutableSharedFlow
import uz.alphadroid.cn.data.remote.response.Score2Response

interface Score2ViewModel {

    val errorMessageSharedFlow: MutableSharedFlow<String>
    val notConnectionSharedFlow: MutableSharedFlow<Unit>
    val succesSharedFlow: MutableSharedFlow<Score2Response>
    val progressSharedFlow: MutableSharedFlow<Boolean>
    fun sendData(
        age_user: String,
        gender_user: String,
        smoke: String,
        total_cholesterol: String,
        Diabetes: String,
        S_Blood_P: String,
        HDL_cholesterol: String,
        T_hypertension: String,
        country_user: String,
    )

}