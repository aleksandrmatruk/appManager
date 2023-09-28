package com.matalex.appmanager

import android.content.pm.ApplicationInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.matalex.appmanager.databinding.ActivityMainBinding
import java.text.SimpleDateFormat


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
//        binding.recyclerView.addItemDecoration(
//           DividerItemDecoration(this, DividerItemDecoration.VERTICAL)   //разделительная линия между view-элементами
//        )
    }

    private fun populateList() {
        val packages = packageManager.getInstalledPackages(0)
        for (packageInfo in packages) {
            if (packageInfo.applicationInfo.flags and ApplicationInfo.FLAG_SYSTEM == 0) {

                val formatter = SimpleDateFormat("dd MMMM yyyy   HH:mm ")

                val appItem = AppItem(
                    appIcon = packageInfo.applicationInfo.loadIcon(packageManager),
                    appName = packageInfo.applicationInfo.loadLabel(packageManager).toString(),
                    appPackage = packageInfo.packageName,
                    appDate = formatter.format(packageInfo.firstInstallTime)
                )
                appItemsList.add(appItem)

            }
            appItemsList.sortBy {
                it.appDate
            }

        }
    }
}