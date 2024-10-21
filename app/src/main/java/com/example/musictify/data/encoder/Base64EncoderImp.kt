package com.example.musictify.data.encoder

import android.util.Base64
import javax.inject.Inject

class Base64EncoderImp @Inject constructor(): Base64Encoder{
    override fun encoderToString(input: ByteArray): String = Base64.encodeToString(input, Base64.NO_WRAP)
}