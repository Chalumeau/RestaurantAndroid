package fr.isen.dussot.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.util.Log
import fr.isen.dussot.androiderestaurant.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.starters.setOnClickListener {
            changeActivity(getString(R.string.home_starters))
        }

        binding.dish.setOnClickListener {
            changeActivity(getString(R.string.home_dish))
        }

        binding.desserts.setOnClickListener {
            changeActivity(getString(R.string.home_dessert))
        }
    }

    private fun changeActivity(category: String) {
        val intent = Intent(this,MainDishActivity::class.java)
        intent.putExtra("category_type", category)
        startActivity(intent)
    }
}

