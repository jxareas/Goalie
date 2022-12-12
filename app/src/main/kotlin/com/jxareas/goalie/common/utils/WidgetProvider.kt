package com.jxareas.goalie.common.utils

abstract class WidgetProvider {

    companion object {
        private const val VIEWPORT_CONFIG =
            "<html><meta name=\"viewport\" content='width=device-width, height=device-height, initial-scale=1.0,text/html,charset=utf-8'>"

    }

    abstract val iFrame: String

    private val customFrame: String
        get() = iFrame.replace("position:relative;padding-bottom:56.250%;", "")

    val websiteData: String
        get() = "$VIEWPORT_CONFIG<body style=\"padding: 0; margin: 0;\"><center>$customFrame</center></body></html>"

}
