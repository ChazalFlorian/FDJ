package com.fchazal.fdj.league.data.model

import androidx.annotation.Keep

@Keep
data class LeagueResponse(
    val teams: List<TeamResponse>,
)

@Keep
data class TeamResponse(
    val idTeam: String,
    val idSoccerXML: String,
    val idAPIfootball: String,
    val intLoved: String,
    val strTeam: String,
    val strTeamShort: String,
    val strAlternative: String,
    val intFormedYear: String,
    val strSport: String,
    val strLeague: String,
    val idLeague: String,
    val strLeague2: String,
    val idLeague2: String,
    val strLeague3: String,
    val idLeague3: String,
    val strLeague4: String,
    val idLeague4: String,
    val strLeague5: String,
    val idLeague5: String,
    val strLeague6: String,
    val idLeague6: String,
    val strLeague7: String,
    val idLeague7: String,
    val strDivision: String,
    val strStadium: String,
    val strKeywords: String,
    val strRSS: String,
    val strStadiumThumb: String,
    val strStadiumDescription: String,
    val strStadiumLocation: String,
    val strStadiumCapacity: String,
    val strWebsite: String,
    val strFacebook: String,
    val strTwitter: String,
    val strDescriptionEN: String,
    val strDescriptionDE: String,
    val strDescriptionFR: String?,
    val strDescriptionCN: String,
    val strDescriptionIT: String,
    val strDescriptionJP: String,
    val strDescriptionRU: String,
    val strDescriptionES: String,
    val strDescriptionPT: String,
    val strDescriptionSE: String,
    val strDescriptionNL: String,
    val strDescriptionHU: String,
    val strDescriptionNO: String,
    val strDescriptionIL: String,
    val strDescriptionPL: String,
    val strKitColor1: String,
    val strKitColor2: String,
    val strKitColor3: String,
    val strGender: String,
    val strCountry: String,
    val strTeamBadge: String,
    val strTeamJersey: String,
    val strLogo: String?,
    val strTeamFanart1: String,
    val strTeamFanart2: String,
    val strTeamFanart3: String,
    val strTeamFanart4: String,
    val strTeamBanner: String,
    val strYoutube: String,
    val strLocked: String,
)