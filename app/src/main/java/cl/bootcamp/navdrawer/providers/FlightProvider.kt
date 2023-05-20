package cl.bootcamp.navdrawer.providers

import cl.bootcamp.navdrawer.models.Flight

class FlightProvider {

    companion object {


        val listCitiesForFlight = mutableListOf<Flight>(
            Flight(
                1,
                "Santiago",
                "https://i.postimg.cc/zXKM8GYV/santiago.jpg"
            ),
            Flight(
                2,
                "Los Angeles",
                "https://i.postimg.cc/44w7MJjT/los_angeles.jpg"
            ),
            Flight(
                3,
                "New York",
                "https://i.postimg.cc/mrD8zbJ3/new_york.jpg"
            ),
            Flight(
                4,
                "Stavanger",
                "https://i.postimg.cc/K4Sn0b0W/stavanger.jpg"
            ),
            Flight(
                5,
                "Madrid",
                "https://i.postimg.cc/Xq2ry89v/madrid.jpg"
            ),
            Flight(
                6,
                "Buenos Aires",
                "https://i.postimg.cc/xCWyh9XQ/buenos_aires.jpg"
            ),
            Flight(
                7,
                "Bogota",
                "https://i.postimg.cc/CKr4CGYz/bogota.jpg"
            ),
            Flight(
                8,
                "Barcelona",
                "https://i.postimg.cc/jdRJZVnn/Barcelona-ciudad.jpg"
            ),
            Flight(
                9,
                "Milan",
                "https://i.postimg.cc/9M0tMJ4L/milan.jpg"
            ),
            Flight(
                10,
                "Londres",
                "https://i.postimg.cc/sx0222RQ/londres.jpg"
            ),
            Flight(
                11,
                "Johannesbugo",
                "https://i.postimg.cc/8kyc4Zrp/johannesburgo.jpg"
            )

        )

    }
}
