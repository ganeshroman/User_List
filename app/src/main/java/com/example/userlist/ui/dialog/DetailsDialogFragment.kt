package com.example.userlist.ui.dialog


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.compose.ui.text.capitalize
import androidx.fragment.app.DialogFragment
import com.example.userlist.databinding.FragmentSimpleDialogBinding


class DetailsDialogFragment : DialogFragment() {

    private var _binding: FragmentSimpleDialogBinding? =null

    companion object {

        const val TAG = "SimpleDialog"

        private const val KEY_TITLE = "KEY_TITLE"
        private const val KEY_SUBTITLE = "KEY_SUBTITLE"
        private const val KEY_SUBTITLE1 = "KEY_SUBTITLE1"
        private const val KEY_SUBTITLE2 = "KEY_SUBTITLE2"

        fun newInstance(title: String, subTitle: String,subTitle1: String,subTitle2: String): DetailsDialogFragment {
            val args = Bundle()
            args.putString(KEY_TITLE, title)
            args.putString(KEY_SUBTITLE, subTitle)
            args.putString(KEY_SUBTITLE1, subTitle1)
            args.putString(KEY_SUBTITLE2, subTitle2)

            val fragment = DetailsDialogFragment()
            fragment.arguments = args
            return fragment
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSimpleDialogBinding.inflate(LayoutInflater.from(context))

        return _binding!!.root
        //return inflater.inflate(R.layout.fragment_simple_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView(view)
        setupClickListeners(view)
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    private fun setupView(view: View) {
        _binding?.tvTitle?.text = arguments?.getString(KEY_TITLE)
        _binding?.tvSubTitle?.text = "Email : "+arguments?.getString(KEY_SUBTITLE)
        _binding?.tvSubTitle1?.text = "Gender : "+arguments?.getString(KEY_SUBTITLE1)?.capitalize()
        _binding?.tvSubTitle2?.text = "Status : "+arguments?.getString(KEY_SUBTITLE2)?.capitalize()
    }

    private fun setupClickListeners(view: View) {
        _binding?.btnPositive?.setOnClickListener {
            // TODO: Do some task here
            dismiss()
        }
        _binding?.btnNegative?.setOnClickListener {
            // TODO: Do some task here
            dismiss()
        }
    }

}