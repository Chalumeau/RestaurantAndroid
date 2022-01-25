package fr.isen.dussot.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainDishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_dish)

        val category = intent.getStringExtra("category_type")
        findViewById<TextView>(R.id.mainDishTitle).text = category
    }
}