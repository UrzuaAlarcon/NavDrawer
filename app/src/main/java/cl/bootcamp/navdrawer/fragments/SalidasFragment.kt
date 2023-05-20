package cl.bootcamp.navdrawer.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import cl.bootcamp.navdrawer.R
import cl.bootcamp.navdrawer.adapters.RecyclerFlightAdapter
import cl.bootcamp.navdrawer.databinding.FragmentSalidasBinding
import cl.bootcamp.navdrawer.interfaces.RecyclerFlight
import cl.bootcamp.navdrawer.models.Flight
import cl.bootcamp.navdrawer.providers.FlightProvider

class SalidasFragment : Fragment() {

    private lateinit var binding:FragmentSalidasBinding
    private lateinit var recyclerFlight: RecyclerView
    private val layoutManager by lazy { LinearLayoutManager(context)}
    private val listofCitys by lazy {getFlightsFromProvider()}
    private lateinit var adapterFlight: RecyclerFlightAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        activity?.title = "Salida de Vuelos" //supuestamente deberia cambiar el titulo
        binding = FragmentSalidasBinding.inflate(inflater,container,false)


        recyclerFlight = binding.recycleSalidas

        setRecyclerView()


        return binding.root
    }

    private fun setRecyclerView(){

        recyclerFlight.setHasFixedSize(true)
        recyclerFlight.itemAnimator = DefaultItemAnimator()
        recyclerFlight.layoutManager = layoutManager
        adapterFlight = (RecyclerFlightAdapter(listofCitys, object : RecyclerFlight{
            override fun onClick(flight: Flight, position: Int) {
                Toast.makeText(activity, "nos vamos a ${flight.ciudad}", Toast.LENGTH_SHORT).show()
            }

            override fun onDelete(flight: Flight, position: Int) {
                listofCitys.removeAt(position)
                adapterFlight.notifyItemChanged(position)
            }

        }))


        adapterFlight.notifyDataSetChanged()
        recyclerFlight.adapter = adapterFlight


    }


    private fun getFlightsFromProvider():MutableList<Flight>{

        var listFlights = FlightProvider.listCitiesForFlight

        return listFlights

    }


}