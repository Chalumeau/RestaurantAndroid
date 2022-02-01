package fr.isen.dussot.androiderestaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class CustomAdapter(private val mList: List<DishModel>, private val cellClickListener : CellClickListener) : RecyclerView.Adapter<CustomAdapter.ViewHolder>(){
    
    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val dish = mList[position]
        if(dish.images[0]!=""){
            Picasso.get()
                .load(dish.images[0])
                .error((R.drawable.burger_maison)) //burger maison
                .into(holder.itemImage)
        }
        else{
            holder.itemImage.setImageResource(R.drawable.saumon_gravlax) //saumon gravlax
        }


        //holder.itemImage.setImageResource(DishModel.)
        holder.itemText.text = dish.name_fr
        //holder.itemDetail.text = ItemsViewModel.detail
        holder.itemprice.text = dish.prices[0].price + "€"

        val data = mList[position]
        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListener(data)
        }

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val itemImage: ImageView = itemView.findViewById(R.id.itemimage)
        val itemText: TextView = itemView.findViewById(R.id.itemtext)
        val itemprice: TextView = itemView.findViewById(R.id.price)
    }
}