package com.example.ejemplo_data_class.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class User (
    val name: String,
    val lastname: String,
    val age: Int
    ) : Parcelable