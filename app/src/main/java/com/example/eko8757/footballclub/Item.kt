package com.example.eko8757.footballclub

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Item (val name: String?, val desc: String?, val image: Int?) : Parcelable {
}