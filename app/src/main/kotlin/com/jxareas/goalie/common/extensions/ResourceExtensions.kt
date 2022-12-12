package com.jxareas.goalie.common.extensions

import android.content.res.Resources
import androidx.annotation.IntegerRes

fun Resources.getLong(@IntegerRes integerRes: Int): Long =
    getInteger(integerRes).toLong()
