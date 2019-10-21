package nabed.apps.nabedutilslibrary.ui.prescriptions

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.nabed_categories_fragment.*
import kotlinx.android.synthetic.main.no_health_center_screen.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import nabed.apps.nabedutilslibrary.R
import nabed.apps.nabedutilslibrary.data.db.entity.PrescriptionEntry
import nabed.apps.nabedutilslibrary.interfaces.OnChannelsDetailesInterface
import nabed.apps.nabedutilslibrary.ui.base.ScopedFragment
import nabed.apps.nabedutilslibrary.ui.prescriptions.utils.ChannelsListAdapter
import nabed.apps.nabedutilslibrary.ui.prescriptions.utils.PrescriptionsViewModelFactory
import nabed.apps.service.models.DoctorContent
import nabed.apps.service.models.Feed
import nabed.apps.service.models.Poc
import nabed.apps.service.models.ImageObject
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class NabedCategoriesView : ScopedFragment(), OnChannelsDetailesInterface , KodeinAware{

    private var channelsLisOfData: ArrayList<PrescriptionEntry> = ArrayList()
    private var channelsListAdapter: ChannelsListAdapter? = null
    private var mLayoutManager: LinearLayoutManager? = null
    private var doctorContent: DoctorContent = getDummyDoctorContent()
    override val kodein: Kodein by closestKodein()
    private val viewModelFactory :PrescriptionsViewModelFactory by instance()

    private fun getDummyDoctorContent(): DoctorContent {
        var imageObject = ImageObject()
        imageObject.id = "1"
        imageObject.title = "Doctor Ahmad"
        imageObject.url =
            "https://st2.depositphotos.com/1768926/10130/v/950/depositphotos_101305718-stock-illustration-love-health-medical-logo-with.jpg"
        val poc = Poc("1", "11/11/2011", "Rouch POC", ArrayList(), null, null, imageObject, null)

        return DoctorContent(poc, 1, 1, 1, 1, "12")
    }

    companion object {
        fun newInstance() =
            NabedCategoriesView()
    }

    private lateinit var viewModel: NabedCategoriesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.nabed_categories_fragment, container, false)
    }

    /*override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(NabedCategoriesViewModel::class.java)
        mLayoutManager =
            LinearLayoutManager(this@NabedCategoriesView.context, RecyclerView.VERTICAL, false)
        initObservers()
        fetchData()
    }*/

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(NabedCategoriesViewModel::class.java)
        viewModel.userId= "mm"
        bindUi()
        mLayoutManager =
            LinearLayoutManager(this@NabedCategoriesView.context, RecyclerView.VERTICAL, false)
        fetchData()
    }

    private  fun bindUi()  = launch(Dispatchers.Main) {
        val futureWeather = viewModel.userPresciption.await()

        futureWeather.observe(this@NabedCategoriesView, Observer { prescriptionDetails ->
            if (prescriptionDetails==null) return@Observer

            pb_progress?.visibility = View.GONE
            if (prescriptionDetails.isNotEmpty()) {
                println("DescribeForYouFragment.initPrescription : count grater than 0")
                no_data.visibility = View.GONE
                dataView.visibility = View.VISIBLE
                listOfFeedsRecyclerView.visibility = View.VISIBLE
                listOfFeedsRecyclerView.setHasFixedSize(true)
                channelsLisOfData = prescriptionDetails as ArrayList<PrescriptionEntry>
                Log.d("doctorModel", channelsLisOfData.size.toString() + " aaaa")
                initAdapter(listOfFeedsRecyclerView!!)
            } else {
                println("DescribeForYouFragment.initPrescription : count  = 0")
                println("DescribeForYouFragment.initPrescription : self_enrollment_count =  0")
                title.visibility = View.GONE
                channelsLisOfData = java.util.ArrayList()
                no_data.visibility = View.VISIBLE
                listOfFeedsRecyclerView.visibility = View.GONE
                dataView.visibility = View.GONE
            }
        })
    }

    private fun fetchData() {
//        viewModel.getUserPrescribedCategory("123453")
    }

/*
    private fun initObservers() {

        viewModel.userPrescribedCategories.observe(this, Observer {
            if (it != null) {
                listOfFeedsRecyclerView.visibility = View.VISIBLE
                pb_progress?.visibility = View.GONE


                if (it.result!!.content.size > 0) {
                    println("DescribeForYouFragment.initPrescription : count grater than 0")
                    no_data.visibility = View.GONE
                    dataView.visibility = View.VISIBLE
                    listOfFeedsRecyclerView.visibility = View.VISIBLE
                    listOfFeedsRecyclerView.setHasFixedSize(true)
                    channelsLisOfData = it.result!!.content
                    Log.d("doctorModel", channelsLisOfData.size.toString() + " aaaa")
                    initAdapter(listOfFeedsRecyclerView!!)
                } else {
                    println("DescribeForYouFragment.initPrescription : count  = 0")
                    println("DescribeForYouFragment.initPrescription : self_enrollment_count =  0")
                    title.visibility = View.GONE
                    no_data.visibility = View.VISIBLE
                    listOfFeedsRecyclerView.visibility = View.GONE
                    dataView.visibility = View.GONE
                }
            } else {

            }
        })
    }
*/


    private fun initAdapter(recyclerView: RecyclerView) {
        recyclerView.layoutManager = mLayoutManager!!
       /* var dataarray = ArrayList<Feed>()
        for (i in 0 until channelsLisOfData.size) {
            channelsLisOfData[i].topics.forEach {
                it.content_countCategory = channelsLisOfData[i].content_count
            }
            channelsLisOfData[i].topics.forEach {
                it.total_unread_count = channelsLisOfData[i].total_unread_count
            }
            channelsLisOfData[i].topics.forEach {
                it.categoryHealthCenter = channelsLisOfData[i].category
            }
            dataarray.addAll(channelsLisOfData[i].topics)
        }*/

        channelsListAdapter = ChannelsListAdapter(
            channelsLisOfData,
            this@NabedCategoriesView.context!!,
            this,
            doctorContent
        )
        recyclerView.adapter = channelsListAdapter
    }


    override fun onAction(channelsModel: Feed) {
        println("NabedCategoriesView.onAction")
    }

    override fun onSelfSelect() {
        println("NabedCategoriesView.onSelfSelect")
    }

}
