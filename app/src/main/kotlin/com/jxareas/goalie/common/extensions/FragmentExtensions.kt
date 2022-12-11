package com.jxareas.goalie.common.extensions

import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment

fun Fragment.postponeAndStartTransitionOnPreDraw() =
    postponeEnterTransition().also {
        view?.doOnPreDraw { startPostponedEnterTransition() }
    }
