package com.jxareas.goalie.features.videos.presentation.ui.webviewer

import com.jxareas.goalie.common.utils.WidgetProvider

class VideoViewer(val embeddedFrameUrl: String) : WidgetProvider() {
    override val iFrame: String
        get() = embeddedFrameUrl
}
