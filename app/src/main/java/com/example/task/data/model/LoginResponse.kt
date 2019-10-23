package com.dysisdemo.data.model

class LoginResponse {
    var message: String? = null
    var success: Boolean? = null
    var payload: Payload? = null
}

class Payload {
    var referenceNo: Int? = null
}