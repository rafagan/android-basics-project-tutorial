package guizion.workshop.ce.androidbasics

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.TextView


class HistoryAdapter: RecyclerView.Adapter<HistoryAdapter.HistoryHolder>() {
    private val items = listOf(
            hashMapOf("name" to "Margherita", "size" to "Grande", "border" to "Catupiri"),
            hashMapOf("name" to "Romeu e Julieta", "size" to "Brotinho", "border" to "Chocolate"),
            hashMapOf("name" to "Milho", "size" to "Gigante", "border" to "Sem borda"))

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HistoryHolder {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.cell_history, parent, false)
        return HistoryHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: HistoryHolder, position: Int) {
        val current = items[position]
        holder.bind(current)
    }

    class HistoryHolder(v: View) : RecyclerView.ViewHolder(v) {
        private val name = itemView.findViewById<TextView>(R.id.txt_pizza_name)!!
        private val size = itemView.findViewById<TextView>(R.id.txt_pizza_size)!!
        private val border = itemView.findViewById<TextView>(R.id.txt_pizza_border)!!

        fun bind(current: HashMap<String, String>) {
            name.text = current["name"] ?: ""
            size.text = current["size"] ?: ""
            border.text = current["border"] ?: ""
        }

    }
}