package guizion.workshop.ce.androidbasics

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class SelectModalAdapter: RecyclerView.Adapter<SelectModalAdapter.SelectModalHolder>() {
    lateinit var data: Array<out String>

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SelectModalAdapter.SelectModalHolder {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.cell_select_modal, parent, false)
        return SelectModalAdapter.SelectModalHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: SelectModalAdapter.SelectModalHolder, position: Int) {
        val current = data[position]
        holder.bind(current)
    }

    class SelectModalHolder(v: View) : RecyclerView.ViewHolder(v) {
        private val name = itemView.findViewById<TextView>(R.id.txt_modal_item_name)!!

        fun bind(name: String) {
            this.name.text = name
        }
    }
}