package uz.alphadroid.cn.data.remote.response

data class Score2Response(
    var Lifetime_Risk: Int,
    var Lifetime_norm: Int,
    var N_ten_CVD_risk: Float,
    var Number1: Int,
    var predict_HR_M: Float,
    var risk_name: String,
    var ten_CVD_risk: Float
)
