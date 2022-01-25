package fr.isen.dussot.androiderestaurant

import CustomAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import fr.isen.dussot.androiderestaurant.databinding.ActivityHomeBinding
import fr.isen.dussot.androiderestaurant.databinding.ActivityMainDishBinding
import androidx.recyclerview.widget.RecyclerView

class MainDishActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainDishBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainDishBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainDishTitle.text = intent.getStringExtra("category_type")

        binding.maincourseRecycleView.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<ItemsViewModel>()

        for (i in 1..20) {
            data.add(ItemsViewModel("Item" + i))
        }
        data.add(ItemsViewModel("Escalope pané a la crême"))
        data.add(ItemsViewModel("Gnocchis"))
        data.add(ItemsViewModel("Pizza"))
        data.add(ItemsViewModel("Spaguetti a la carbonara"))
        data.add(ItemsViewModel("Raviolis"))

        val adapter = CustomAdapter(data)

        binding.maincourseRecycleView.adapter = adapter
    }
}