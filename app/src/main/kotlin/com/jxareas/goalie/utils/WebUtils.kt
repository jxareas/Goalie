package com.jxareas.goalie.utils

object WebUtils {
    private const val iFrame =
        "<iframe src=\"https://www.scorebat.com/embed/league/fifa-world-cup/?token=MjExMDVfMTY2Nzc5MjA3OV82N2IxNTE5Njg1MTI4MTRiZjRhYzNlOGIwMDBkOGVjODBmZWNhZDRj\" frameborder=\"0\" width=\"600\" height=\"760\" allowfullscreen allow='autoplay; fullscreen' style=\"width:100%;height:760px;overflow:hidden;display:block;\" class=\"_scorebatEmbeddedPlayer_\"></iframe><script>(function(d, s, id) { var js, fjs = d.getElementsByTagName(s)[0]; if (d.getElementById(id)) return; js = d.createElement(s); js.id = id; js.src = 'https://www.scorebat.com/embed/embed.js?v=arrv'; fjs.parentNode.insertBefore(js, fjs); }(document, 'script', 'scorebat-jssdk'));</script>"

    private val iFrameWithNoPadding =
        iFrame.replace("position:relative;padding-bottom:56.250%;", "")
    private const val VIEWPORT_CONFIG =
        "<html><meta name=\"viewport\" content='width=device-width, height=device-height, initial-scale=1.0,text/html,charset=utf-8'>"

    val websiteData =
        "$VIEWPORT_CONFIG<body style=\"padding: 0; margin: 0;\"><center>$iFrameWithNoPadding</center></body></html>"

}
