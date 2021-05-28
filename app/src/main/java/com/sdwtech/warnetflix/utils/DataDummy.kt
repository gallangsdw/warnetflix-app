package com.sdwtech.warnetflix.utils

import com.sdwtech.warnetflix.data.source.remote.response.*

object DataDummy {

    fun generateDummyMovie(): Movies {

        val movie = ArrayList<MovieResponse>()

        movie.add(MovieResponse(
                "/fPGeS6jgdLovQAKunNHX8l0avCy.jpg",
                "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                "Tom Clancy's Without Remorse",
                "2021-04-29",
                7.3,
                567189,
                "Tom Clancy's Without Remorse",
                "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg"
        ))
        movie.add(MovieResponse(
                "/6ELCZlTA5lGUops70hKdB83WJxH.jpg",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "Mortal Kombat",
                "2021-04-07",
                7.6,
                460465,
                "Mortal Kombat",
                "/nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg"
        ))
        movie.add(MovieResponse(
                "/6zbKgwgaaCyyBXE4Sun4oWQfQmi.jpg",
                "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \\\"nobody.\\\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.",
                "Nobody",
                "2021-03-26",
                8.4,
                615457,
                "Nobody",
                "/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg"
        ))
        return Movies(movie)
    }

    fun generateDummyTvShow(): TvShows {

        val tvShow = ArrayList<TvResponse>()

        tvShow.add(TvResponse(
                "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
                "2021-03-19",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "The Falcon and the Winter Soldier",
                7.9,
                "The Falcon and the Winter Soldier",
                88396,
                "/6kbAMLteGO8yyewYau6bJ683sw7.jpg"
        ))
        tvShow.add(TvResponse(
                "/mZjZgY6ObiKtVuKVDrnS9VnuNlE.jpg",
                "2017-09-25",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "The Good Doctor",
                8.6,
                "The Good Doctor",
                71712,
                "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg"
        ))
        tvShow.add(TvResponse(
                "/6UH52Fmau8RPsMAbQbjwN3wJSCj.jpg",
                "2021-03-26",
                "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
                "Invincible",
                8.9,
                "Invincible",
                95557,
                "/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg"
        ))
        return TvShows(tvShow)
    }

    fun generateRemoteMovie(): Movies {
        val movie = ArrayList<MovieResponse>()

        movie.add(MovieResponse(
                "/fPGeS6jgdLovQAKunNHX8l0avCy.jpg",
                "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                "Tom Clancy's Without Remorse",
                "2021-04-29",
                7.3,
                567189,
                "Tom Clancy's Without Remorse",
                "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg"
        ))
        movie.add(MovieResponse(
                "/6ELCZlTA5lGUops70hKdB83WJxH.jpg",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "Mortal Kombat",
                "2021-04-07",
                7.6,
                460465,
                "Mortal Kombat",
                "/nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg"
        ))
        movie.add(MovieResponse(
                "/6zbKgwgaaCyyBXE4Sun4oWQfQmi.jpg",
                "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \\\"nobody.\\\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.",
                "Nobody",
                "2021-03-26",
                8.4,
                615457,
                "Nobody",
                "/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg"
        ))
        return Movies(movie)
    }

    fun generateRemoteDetailMovie() : DetailMovieResponse {
        return DetailMovieResponse(
                "/fPGeS6jgdLovQAKunNHX8l0avCy.jpg",
                "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                "Tom Clancy's Without Remorse",
                "2021-04-29",
                7.3,
                567189,
                "Tom Clancy's Without Remorse",
                "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg")
    }

    fun generateRemoteTvShow() : TvShows {
        val tvShow = ArrayList<TvResponse>()
        tvShow.add(TvResponse(
                "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
                "2021-03-19",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "The Falcon and the Winter Soldier",
                7.9,
                "The Falcon and the Winter Soldier",
                88396,
                "/6kbAMLteGO8yyewYau6bJ683sw7.jpg"
        ))
        tvShow.add(TvResponse(
                "/mZjZgY6ObiKtVuKVDrnS9VnuNlE.jpg",
                "2017-09-25",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "The Good Doctor",
                8.6,
                "The Good Doctor",
                71712,
                "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg"
        ))
        tvShow.add(TvResponse(
                "/6UH52Fmau8RPsMAbQbjwN3wJSCj.jpg",
                "2021-03-26",
                "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
                "Invincible",
                8.9,
                "Invincible",
                95557,
                "/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg"
        ))
        return TvShows(tvShow)
    }

    fun generateRemoteDetailTvShow(): DetailTvShowResponse {
        return DetailTvShowResponse(
                "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
                "2021-03-19",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "The Falcon and the Winter Soldier",
                7.9,
                "The Falcon and the Winter Soldier",
                88396,
                "/6kbAMLteGO8yyewYau6bJ683sw7.jpg"
        )
    }
}