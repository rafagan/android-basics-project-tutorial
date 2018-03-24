package guizion.workshop.ce.androidbasics

import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.support.design.widget.BottomSheetDialogFragment
import android.view.View


class SelectModalFragment : BottomSheetDialogFragment() {
    lateinit var list: Array<out String>

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        list = resources.getStringArray(arguments.getInt("type"))
        return inflater!!.inflate(R.layout.modal_select, container, false)
    }
}