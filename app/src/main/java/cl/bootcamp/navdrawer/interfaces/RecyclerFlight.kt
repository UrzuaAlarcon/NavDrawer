package cl.bootcamp.navdrawer.interfaces

import cl.bootcamp.navdrawer.models.Flight
import java.text.FieldPosition

interface RecyclerFlight {


    fun onClick(flight:Flight, position: Int)
    fun onDelete(flight: Flight, position: Int)

}