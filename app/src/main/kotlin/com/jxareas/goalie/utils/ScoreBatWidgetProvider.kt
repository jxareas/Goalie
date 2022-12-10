package com.jxareas.goalie.utils

abstract class ScoreBatWidgetProvider(private val token: ScoreBatToken) {

    companion object {
        private const val VIEWPORT_CONFIG =
            "<html><meta name=\"viewport\" content='width=device-width, height=device-height, initial-scale=1.0,text/html,charset=utf-8'>"

    }

    abstract val iFrame: String

    private val iFrameWithRelativePosition: String
        get() = iFrame.replace("position:relative;padding-bottom:56.250%;", "")

    val websiteData: String
        get() = "$VIEWPORT_CONFIG<body style=\"padding: 0; margin: 0;\"><center>$iFrameWithRelativePosition</center></body></html>"

}
