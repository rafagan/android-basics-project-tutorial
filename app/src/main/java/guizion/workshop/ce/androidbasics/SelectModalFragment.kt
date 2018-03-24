package guizion.workshop.ce.androidbasics

import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.support.design.widget.BottomSheetDialogFragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View


class SelectModalFragment : BottomSheetDialogFragment() {
    lateinit var list: Array<out String>

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.modal_select, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list = resources.getStringArray(arguments.getInt("type"))

        val layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        val recView = view!!.findViewById<RecyclerView>(R.id.select_modal_list)!!
        recView.layoutManager = layoutManager

        val adapter = SelectModalAdapter()
        adapter.data = list
        recView.adapter = adapter
    }
}