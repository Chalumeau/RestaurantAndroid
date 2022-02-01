package fr.isen.dussot.androiderestaurant

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Detail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var item: String? = ""

        var quantity : Int = 1

        val itemDish= intent.getSerializableExtra("itemDish") as DishModel

        val detail_title = findViewById<TextView>(R.id.detailtitle)
        val back =findViewById<Button>(R.id.detailback)
        var buttonmoins =findViewById<FloatingActionButton>(R.id.moins)
        var viewPager = findViewById<ViewPager>(R.id.viewPager)
        val detail_text = findViewById<TextView>(R.id.detailtext)
        var quantitydisplay =findViewById<TextView>(R.id.quantity)
        val pricedisplay = findViewById<TextView>(R.id.detailprice)
        var buttonplus =findViewById<FloatingActionButton>(R.id.plus)

        //Carroussel
        var imgs: List<String> = itemDish.images
        var adapter = ViewPagerAdapter(this, imgs)
        viewPager.adapter = adapter


        detail_title.setText(itemDish.name_fr)

        //ingredients
        for(i in itemDish.ingredients) detail_text.append(i.name_fr + " ")

        pricedisplay.text = "Total  "+itemDish.prices[0].price + "€"

        quantitydisplay.text = "$quantity"

        buttonmoins.setOnClickListener(){
            if (quantity>1) quantity --
            else quantity = 1
            val totalprice = (itemDish.prices[0].price.toFloat())*quantity
            pricedisplay.text = "Total  " + "$totalprice" + "€"
            quantitydisplay.text ="$quantity"
        }

        buttonplus.setOnClickListener(){
            quantity++
            val totalprice = (itemDish.prices[0].price.toFloat())*quantity
            quantitydisplay.text = "$quantity"
        }

        quantitydisplay.setOnClickListener(){

        }

        back.setOnClickListener {
            finish()
        }
    }
}