package com.matalex.appmanager

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.matalex.appmanager.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val appItemsList: MutableList<AppItem> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        populateList()
        setUpAdapter()
    }


    private fun setUpAdapter() {

        val adapter = AppItemAdapter(this, appItemsList) // чтоб память не текла?

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL    //разделительная линия между view-элементами
            )
        )
    }

    private fun populateList() {
        val packages = packageManager.getInstalledApplications(PackageManager.GET_META_DATA)
        for (packageInfo in packages) {
            Log.d(
                "MyLog",
                "Package name: ${packageInfo.packageName}  ${packageInfo.name}  ${
                    packageInfo.loadIcon(packageManager)
                }"
            )
            val appItem = AppItem(
                appIcon = packageInfo.loadIcon(packageManager),
                appName = packageInfo.name ?: ("no name"),
                appPackage = packageInfo.packageName,
                appDate = "10.10.2010"
            )
            appItemsList.add(appItem)
        }
    }

}