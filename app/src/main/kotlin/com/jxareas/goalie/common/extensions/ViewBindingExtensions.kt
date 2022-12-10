package com.jxareas.goalie.common.extensions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

internal inline infix fun <reified VB : ViewBinding> ViewGroup.runOnInflater(
    crossinline bindingInflater: LayoutInflater.(parent: ViewGroup, attachToParent: Boolean) -> VB,
): VB = LayoutInflater.from(context).let { layoutInflater ->
    bindingInflater.invoke(layoutInflater, this, false)
}
