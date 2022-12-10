package com.jxareas.goalie.features.worldcup.presentation

import com.jxareas.goalie.common.utils.WidgetProvider
import com.jxareas.goalie.common.utils.ApiToken
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WorldCupWidgetProvider @Inject constructor(private val apiToken: ApiToken) :
    WidgetProvider(apiToken) {

    override val iFrame: String
        get() = "<iframe src=\"https://www.scorebat.com/embed/league/fifa-world-cup/?token=${apiToken.token}\" frameborder=\"0\" width=\"600\" height=\"760\" allowfullscreen allow='autoplay; fullscreen' style=\"width:100%;height:760px;overflow:hidden;display:block;\" class=\"_scorebatEmbeddedPlayer_\"></iframe><script>(function(d, s, id) { var js, fjs = d.getElementsByTagName(s)[0]; if (d.getElementById(id)) return; js = d.createElement(s); js.id = id; js.src = 'https://www.scorebat.com/embed/embed.js?v=arrv'; fjs.parentNode.insertBefore(js, fjs); }(document, 'script', 'scorebat-jssdk'));</script>"

}
