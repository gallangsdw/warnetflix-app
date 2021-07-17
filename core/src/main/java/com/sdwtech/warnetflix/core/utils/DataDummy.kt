package com.sdwtech.warnetflix.core.utils

import com.sdwtech.warnetflix.core.data.source.local.entity.MovieEntity
import com.sdwtech.warnetflix.core.data.source.local.entity.TvShowEntity
import com.sdwtech.warnetflix.core.data.source.remote.response.movie.DetailMovieResponse
import com.sdwtech.warnetflix.core.data.source.remote.response.movie.MovieResponse
import com.sdwtech.warnetflix.core.data.source.remote.response.movie.Movies
import com.sdwtech.warnetflix.core.data.source.remote.response.tvShow.DetailTvShowResponse
import com.sdwtech.warnetflix.core.data.source.remote.response.tvShow.TvResponse
import com.sdwtech.warnetflix.core.data.source.remote.response.tvShow.TvShows

object DataDummy {

    fun generateDummyMovie(): List<com.sdwtech.warnetflix.core.data.source.local.entity.MovieEntity> {

        val movie = ArrayList<com.sdwtech.warnetflix.core.data.source.local.entity.MovieEntity>()

        movie.add(
            com.sdwtech.warnetflix.core.data.source.local.entity.MovieEntity(
                337404,
                "/6MKr3KgOLmzOP6MSuZERO41Lpkt.jpg",
                "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. ",
                "Cruella",
                "2021-05-26",
                "8.6",
                "Cruella",
                "/rTh4K5uw9HypmpGslcKd4QfHl93.jpg",
                false
            )
        )
        movie.add(
            com.sdwtech.warnetflix.core.data.source.local.entity.MovieEntity(
                423108,
                "/qi6Edc1OPcyENecGtz8TF0DUr9e.jpg",
                "Paranormal investigators Ed and Lorraine Warren encounter what would become one of the most sensational cases from their files. The fight for the soul of a young boy takes them beyond anything they'd ever seen before, to mark the first time in U.S. history that a murder suspect would claim demonic possession as a defense.",
                "The Conjuring: The Devil Made Me Do It",
                "2021-05-25",
                "8.2",
                "The Conjuring: The Devil Made Me Do It",
                "/xbSuFiJbbBWCkyCCKIMfuDCA4yV.jpg",
                false
            )
        )
        movie.add(
            com.sdwtech.warnetflix.core.data.source.local.entity.MovieEntity(
                567189,
                "/fPGeS6jgdLovQAKunNHX8l0avCy.jpg",
                "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                "Tom Clancy's Without Remorse",
                "2021-04-29",
                "7.3",
                "Tom Clancy's Without Remorse",
                "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                false
            )
        )
        movie.add(
            com.sdwtech.warnetflix.core.data.source.local.entity.MovieEntity(
                469465,
                "/6ELCZlTA5lGUops70hKdB83WJxH.jpg",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "Mortal Kombat",
                "2021-04-07",
                "7.6",
                "Mortal Kombat",
                "/nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg",
                false
            )
        )
        movie.add(
            com.sdwtech.warnetflix.core.data.source.local.entity.MovieEntity(
                615457,
                "/6zbKgwgaaCyyBXE4Sun4oWQfQmi.jpg",
                "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \\\"nobody.\\\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.",
                "Nobody",
                "2021-03-26",
                "8.4",
                "Nobody",
                "/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg",
                false
            )
        )
        return movie
    }

    fun generateDetailMovie() : com.sdwtech.warnetflix.core.data.source.local.entity.MovieEntity {
        return com.sdwtech.warnetflix.core.data.source.local.entity.MovieEntity(
            337404,
            "/6MKr3KgOLmzOP6MSuZERO41Lpkt.jpg",
            "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. ",
            "Cruella",
            "2021-05-26",
            "8.6",
            "Cruella",
            "/rTh4K5uw9HypmpGslcKd4QfHl93.jpg",
            false
        )
    }

    fun generateDummyTvShow(): List<com.sdwtech.warnetflix.core.data.source.local.entity.TvShowEntity> {

        val tvShow = ArrayList<com.sdwtech.warnetflix.core.data.source.local.entity.TvShowEntity>()

        tvShow.add(
            com.sdwtech.warnetflix.core.data.source.local.entity.TvShowEntity(
                84958,
                "/Afp8OhiO0Ajb3NPoCBvfu2pqaeO.jpg",
                "2021-06-09",
                "After stealing the Tesseract during the events of “Avengers: Endgame,” an alternate version of Loki is brought to the mysterious Time Variance Authority, a bureaucratic organization that exists outside of time and space and monitors the timeline.",
                "Loki",
                "8.1",
                "Loki",
                "/kEl2t3OhXc3Zb9FBh1AuYzRTgZp.jpg",
                false
            )
        )
        tvShow.add(
            com.sdwtech.warnetflix.core.data.source.local.entity.TvShowEntity(
                60735,
                "/9Jmd1OumCjaXDkpllbSGi2EpJvl.jpg",
                "2014-10-07",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel.",
                "The Flash",
                " 7.7",
                "The Flash",
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                false
            )
        )
        tvShow.add(
            com.sdwtech.warnetflix.core.data.source.local.entity.TvShowEntity(
                88396,
                "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
                "2021-03-19",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "The Falcon and the Winter Soldier",
                "7.9",
                "The Falcon and the Winter Soldier",
                "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                false
            )
        )
        tvShow.add(
            com.sdwtech.warnetflix.core.data.source.local.entity.TvShowEntity(
                71712,
                "/mZjZgY6ObiKtVuKVDrnS9VnuNlE.jpg",
                "2017-09-25",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "The Good Doctor",
                "8.6",
                "The Good Doctor",
                "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                false
            )
        )
        tvShow.add(
            com.sdwtech.warnetflix.core.data.source.local.entity.TvShowEntity(
                95557,
                "/6UH52Fmau8RPsMAbQbjwN3wJSCj.jpg",
                "2021-03-26",
                "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
                "Invincible",
                "8.9",
                "Invincible",
                "/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
                false
            )
        )
        return tvShow
    }

    fun generateDetailTvShow(): com.sdwtech.warnetflix.core.data.source.local.entity.TvShowEntity {
        return com.sdwtech.warnetflix.core.data.source.local.entity.TvShowEntity(
            84958,
            "/Afp8OhiO0Ajb3NPoCBvfu2pqaeO.jpg",
            "2021-06-09",
            "After stealing the Tesseract during the events of “Avengers: Endgame,” an alternate version of Loki is brought to the mysterious Time Variance Authority, a bureaucratic organization that exists outside of time and space and monitors the timeline.",
            "Loki",
            "8.1",
            "Loki",
            "/kEl2t3OhXc3Zb9FBh1AuYzRTgZp.jpg",
            false
        )
    }

    fun generateRemoteMovie(): Movies {
        val movie = ArrayList<MovieResponse>()

        movie.add(
            MovieResponse(
                "/6MKr3KgOLmzOP6MSuZERO41Lpkt.jpg",
                "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. ",
                "Cruella",
                "2021-05-26",
                8.6,
                337404,
                "Cruella",
                "/rTh4K5uw9HypmpGslcKd4QfHl93.jpg"
        )
        )
        movie.add(
            MovieResponse(
                "/qi6Edc1OPcyENecGtz8TF0DUr9e.jpg",
                "Paranormal investigators Ed and Lorraine Warren encounter what would become one of the most sensational cases from their files. The fight for the soul of a young boy takes them beyond anything they'd ever seen before, to mark the first time in U.S. history that a murder suspect would claim demonic possession as a defense.",
                "The Conjuring: The Devil Made Me Do It",
                "2021-05-25",
                8.2,
                423108,
                "The Conjuring: The Devil Made Me Do It",
                "/xbSuFiJbbBWCkyCCKIMfuDCA4yV.jpg"
        )
        )
        movie.add(
            MovieResponse(
                "/fPGeS6jgdLovQAKunNHX8l0avCy.jpg",
                "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                "Tom Clancy's Without Remorse",
                "2021-04-29",
                7.3,
                567189,
                "Tom Clancy's Without Remorse",
                "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg"
        )
        )
        movie.add(
            MovieResponse(
                "/6ELCZlTA5lGUops70hKdB83WJxH.jpg",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "Mortal Kombat",
                "2021-04-07",
                7.6,
                460465,
                "Mortal Kombat",
                "/nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg"
        )
        )
        movie.add(
            MovieResponse(
                "/6zbKgwgaaCyyBXE4Sun4oWQfQmi.jpg",
                "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \\\"nobody.\\\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.",
                "Nobody",
                "2021-03-26",
                8.4,
                615457,
                "Nobody",
                "/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg"
        )
        )
        return Movies(movie)
    }

    fun generateRemoteDetailMovie(): DetailMovieResponse {
        return DetailMovieResponse(
                "/6MKr3KgOLmzOP6MSuZERO41Lpkt.jpg",
                "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. ",
                "Cruella",
                "2021-05-26",
                8.6,
                337404,
                "Cruella",
                "/rTh4K5uw9HypmpGslcKd4QfHl93.jpg"
        )
    }

    fun generateRemoteTvShow() : TvShows {
        val tvShow = ArrayList<TvResponse>()
        tvShow.add(
            TvResponse(
                "/Afp8OhiO0Ajb3NPoCBvfu2pqaeO.jpg",
                "2021-06-09",
                "After stealing the Tesseract during the events of “Avengers: Endgame,” an alternate version of Loki is brought to the mysterious Time Variance Authority, a bureaucratic organization that exists outside of time and space and monitors the timeline.",
                "Loki",
                8.1,
                "Loki",
                84958,
                "/kEl2t3OhXc3Zb9FBh1AuYzRTgZp.jpg"
        )
        )
        tvShow.add(
            TvResponse(
                "/9Jmd1OumCjaXDkpllbSGi2EpJvl.jpg",
                "2014-10-07",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel.",
                "The Flash",
                7.7,
                "The Flash",
                60735,
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg"
        )
        )
        tvShow.add(
            TvResponse(
                "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
                "2021-03-19",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "The Falcon and the Winter Soldier",
                7.9,
                "The Falcon and the Winter Soldier",
                88396,
                "/6kbAMLteGO8yyewYau6bJ683sw7.jpg"
        )
        )
        tvShow.add(
            TvResponse(
                "/mZjZgY6ObiKtVuKVDrnS9VnuNlE.jpg",
                "2017-09-25",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "The Good Doctor",
                8.6,
                "The Good Doctor",
                71712,
                "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg"
        )
        )
        tvShow.add(
            TvResponse(
                "/6UH52Fmau8RPsMAbQbjwN3wJSCj.jpg",
                "2021-03-26",
                "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
                "Invincible",
                8.9,
                "Invincible",
                95557,
                "/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg"
        )
        )
        return TvShows(tvShow)
    }

    fun generateRemoteDetailTvShow(): DetailTvShowResponse {
        return DetailTvShowResponse(
                "/Afp8OhiO0Ajb3NPoCBvfu2pqaeO.jpg",
                "2021-06-09",
                "After stealing the Tesseract during the events of “Avengers: Endgame,” an alternate version of Loki is brought to the mysterious Time Variance Authority, a bureaucratic organization that exists outside of time and space and monitors the timeline.",
                "Loki",
                8.1,
                "Loki",
                84958,
                "/kEl2t3OhXc3Zb9FBh1AuYzRTgZp.jpg"
        )
    }
}