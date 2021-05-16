package com.sdwtech.warnetflix.utils

import com.sdwtech.warnetflix.data.source.local.entity.Entity

object DataDummy {

    fun generateDummyMovie(): List<Entity> {

        val movie = ArrayList<Entity>()

        movie.add(Entity(
                101,
                "The Shawshank Redemption",
                "https://m.media-amazon.com/images/I/51KjbtEkoeL._AC_.jpg",
                "https://specials-images.forbesimg.com/imageserve/5d7149125b52ce0008827026/960x0.jpg?fit=scale",
                "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
                "14 October 1994",
                9.3/10
        ))
        movie.add(Entity(
                102,
                "The Godfather",
                "https://kenoshasportsextra.com/wp-content/uploads/godfather.jpg",
                "https://i.guim.co.uk/img/media/344406ae576b47ce2d97d310babe8262b8bff127/0_255_3504_2103/master/3504.jpg?width=445&quality=45&auto=format&fit=max&dpr=2&s=bdcf1fafa59e1bc96b2befc6af38140d",
                "An organized crime dynasty's aging patriarch transfers control of his clandestine empire to his reluctant son.",
                "24 March 1972",
                9.2/10
        ))
        movie.add(Entity(
                103,
                "The Dark Knight",
                "https://img.pngio.com/amazoncom-the-dark-knight-single-disc-widescreen-edition-batman-png-widescreen-315_445.jpg",
                "https://asset.kompas.com/crops/mr0Q3Y3XwwbN1FpVnGK23fi3yZs=/59x0:1162x735/750x500/data/photo/2021/01/08/5ff833619700c.jpg",
                "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.",
                "18 July 2008",
                9.0/10
        ))
        movie.add(Entity(
                104,
                "The Matrix",
                "https://dyn1.heritagestatic.com/lf?set=path%5B2%2F1%2F7%2F1%2F6%2F21716740%5D%2Csizedata%5B850x600%5D&call=url%5Bfile%3Aproduct.chain%5D",
                "https://images.indianexpress.com/2019/05/matrix-movie-759.jpeg",
                "When a beautiful stranger leads computer hacker Neo to a forbidding underworld, he discovers the shocking truth--the life he knows is the elaborate deception of an evil cyber-intelligence.",
                " 31 March 1999",
                8.7/10
        ))
        movie.add(Entity(
                105,
                "Inception",
                "https://cps-static.rovicorp.com/2/Open/Warner%20Home%20Video/Inception/_derived_jpg_q90_500x500_m0/Inception%20one%20sheet.jpg",
                "https://cdn.images.express.co.uk/img/dynamic/36/750x445/1237613.jpg",
                "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.",
                " 16 July 2010",
                8.8/10
        ))
        movie.add(Entity(
                106,
                "Interstellar",
                "https://images-na.ssl-images-amazon.com/images/I/A1JVqNMI7UL._AC_SY879_.jpg",
                "https://media.tabloidbintang.com/files/thumb/9cb4fb978031a41159489638c6c96780.jpg/745",
                "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
                "7 November 2014",
                8.6/10
        ))
        movie.add(Entity(
                107,
                "Parasite",
                "https://i.redd.it/ecpny46kq2l61.jpg",
                "https://img.okezone.com/content/2020/02/01/206/2161823/penjelasan-sutradara-soal-akhir-kisah-menyedihkan-parasite-LiQXF1yr8n.jpg",
                "Greed and class discrimination threaten the newly formed symbiotic relationship between the wealthy Park family and the destitute Kim clan.",
                "8 November 2019",
                8.6/10
        ))
        movie.add(Entity(
                108,
                "The Lion King",
                "https://xl.movieposterdb.com/05_06/1994/0110357/xl_20044_0110357_a53ef500.jpg",
                "https://cdn.i-scmp.com/sites/default/files/styles/1200x800/public/d8/images/methode/2019/05/09/f8a77814-7135-11e9-b91a-87f62b76a5ee_image_hires_173130.jpg?itok=vGPqoOfW&v=1557394295",
                "Lion prince Simba and his father are targeted by his bitter uncle, who wants to ascend the throne himself.",
                "24 June 1994",
                8.5/10
        ))
        movie.add(Entity(
                109,
                "Joker",
                "https://images-na.ssl-images-amazon.com/images/I/51E%2Bo6036kL._AC_.jpg",
                "https://img.okezone.com/content/2019/10/07/320/2113946/joker-lagi-hits-berapa-kekayaan-pemerannya-Y3JFqq2llO.jpg",
                "In Gotham City, mentally troubled comedian Arthur Fleck is disregarded and mistreated by society. He then embarks on a downward spiral of revolution and bloody crime. This path brings him face-to-face with his alter-ego: the Joker.",
                " 4 October 2019",
                8.4/10
        ))
        movie.add(Entity(
                110,
                "Avengers: Endgame",
                "https://m.media-amazon.com/images/M/MV5BMTc5MDE2ODcwNV5BMl5BanBnXkFtZTgwMzI2NzQ2NzM@._V1_UY1200_CR90,0,630,1200_AL_.jpg",
                "https://cdn1-production-images-kly.akamaized.net/IdtRT1EPJOXg7KSRvXprsF_8OxM=/0x0:970x546/640x360/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/2125967/original/040670800_1524822390-fb22d0da-f64c-4d98-9aa0-8d7033375a96.jpg",
                "After the devastating events of Avengers: Infinity War (2018), the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos' actions and restore balance to the universe.",
                "26 April 2019",
                8.4/10
        ))
        return movie
    }

    fun generateDummyTvShow(): List<Entity> {

        val tvShow = ArrayList<Entity>()

        tvShow.add(Entity(
                201,
                "Planet Earth II",
                "https://images-na.ssl-images-amazon.com/images/I/817WNwCZHvL._SY500_.jpg",
                "https://www.tubefilter.com/wp-content/uploads/2017/02/planet-earth-ii.jpg",
                "Wildlife documentary series with David Attenborough, beginning with a look at the remote islands which offer sanctuary to some of the planet's rarest creatures, to the beauty of cities, which are home to humans, and animals.",
                "2016",
                9.5/10
        ))
        tvShow.add(Entity(
                202,
                "Band of Brothers",
                "https://m.media-amazon.com/images/M/MV5BMTI3ODc2ODc0M15BMl5BanBnXkFtZTYwMjgzNjc3._V1_.jpg",
                "https://variety.com/wp-content/uploads/2019/10/bandofbrothers.jpg?w=681&h=383&crop=1",
                "The story of Easy Company of the U.S. Army 101st Airborne Division, and their mission in World War II Europe, from Operation Overlord, through V-J Day.",
                "2001",
                9.4/10
        ))
        tvShow.add(Entity(
                203,
                "Chernobyl",
                "https://p4.wallpaperbetter.com/wallpaper/587/697/259/chernobyl-hbo-tv-series-disaster-poster-hd-wallpaper-preview.jpg",
                "https://i.pinimg.com/originals/4f/8f/0a/4f8f0a8b9857204f5a959e92ae0dcecb.jpg",
                "In April 1986, an explosion at the Chernobyl nuclear power plant in the Union of Soviet Socialist Republics becomes one of the world's worst man-made catastrophes.",
                "2019",
                9.4/10
        ))
        tvShow.add(Entity(
                204,
                "Blue Planet II",
                "https://m.media-amazon.com/images/M/MV5BYjg2ODk0MjUtNmMzZS00MjY0LWI1YWMtN2JhMjRmZGUwY2I3XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg",
                "https://asset-manager.bbcchannels.com/i/2f2dg0sa0fz1000",
                "David Attenborough returns to the world's oceans in this sequel to the acclaimed documentary filming rare and unusual creatures of the deep, as well as documenting the problems our oceans face.",
                "2017",
                9.3/10
        ))
        tvShow.add(Entity(
                205,
                "The Wire",
                "https://gzhls.at/i/19/01/801901-n0.jpg",
                "https://variety.com/wp-content/uploads/2017/06/the-wire.jpg?w=1000",
                "The Baltimore drug scene, as seen through the eyes of drug dealers and law enforcement.",
                "2002-2008",
                9.3/10
        ))
        tvShow.add(Entity(
                206,
                "Our Planet",
                "https://pbs.twimg.com/media/EUcaYudXYAAL-Bs.jpg",
                "https://occ-0-1068-1722.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABUZGIKbEP2XZd4dj1zdfsfeNrIljXBDRonGeyDOqM_MqBmHIdMlrh00Y6nFyjLBD8zRYy5UZWC3tNvmY8iV8Tpm787tw.jpg?r=864",
                "Documentary series focusing on the breadth of the diversity of habitats around the world, from the remote Arctic wilderness and mysterious deep oceans to the vast landscapes of Africa and diverse jungles of South America.",
                "2019",
                9.3/10
        ))
        tvShow.add(Entity(
                207,
                "Cosmos: A Spacetime Odyssey",
                "https://lh3.googleusercontent.com/proxy/k79zJYEZxYoLVkgX4yuDjitQaxomBCX8K87uO4rv6Az7XM2mbpAbgMn-HaWQgXyu-uDrfBJwEWbjd8k4riSKx6izg7fqgETH9j5HjhpVGW0MNaG1fdALQ3rr",
                "https://vistapointe.net/images/cosmos-a-spacetime-odyssey-2.jpg",
                "An exploration of our discovery of the laws of nature and coordinates in space and time.",
                "2014",
                9.3/10
        ))
        tvShow.add(Entity(
                208,
                "Avatar: The Last Airbender",
                "https://static.tvtropes.org/pmwiki/pub/images/avatar_poster_4.png",
                "https://cdn.vox-cdn.com/thumbor/RU8MZ6zUB7rlLXL56v52wX_pJUM=/0x0:1200x923/1200x800/filters:focal(504x366:696x558)/cdn.vox-cdn.com/uploads/chorus_image/image/68878445/1399063.0.jpg",
                "In a war-torn world of elemental magic, a young boy reawakens to undertake a dangerous mystic quest to fulfill his destiny as the Avatar, and bring peace to the world.",
                "2005-2008",
                9.2/10
        ))
        tvShow.add(Entity(
                209,
                "Game of Thrones",
                "https://m.media-amazon.com/images/M/MV5BYTRiNDQwYzAtMzVlZS00NTI5LWJjYjUtMzkwNTUzMWMxZTllXkEyXkFqcGdeQXVyNDIzMzcwNjc@._V1_UY1200_CR126,0,630,1200_AL_.jpg",
                "https://asset.kompas.com/crops/Tgqzz_OTmyLrhwkRDrjDPuOkMYU=/0x8:768x392/750x500/data/photo/2019/04/05/985928854.jpg",
                "Nine noble families fight for control over the lands of Westeros, while an ancient enemy returns after being dormant for millennia.",
                "2011-2019",
                9.3/10
        ))
        tvShow.add(Entity(
                210,
                "The Last Dance",
                "https://d32qys9a6wm9no.cloudfront.net/images/tvs/poster/4d/e4b9b6eeb9591c2d74bd040d10329296_300x442.jpg?t=1589752426&w=640",
                "https://jambiekspres.co.id/foto_berita/2020/04/22/2634c807d252fd46708c272f4ebda986ba.jpeg",
                "Charting the rise of the 1990's Chicago Bulls, led by Michael Jordan, one of the most notable dynasties in sports history.",
                "2020",
                9.1/10
        ))
        return tvShow
    }
}