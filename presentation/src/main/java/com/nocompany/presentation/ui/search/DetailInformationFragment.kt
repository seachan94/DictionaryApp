package com.nocompany.presentation.ui.search

import android.app.Activity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.nocompany.presentation.R
import com.nocompany.presentation.databinding.BottomfragmentDetailBinding

class DetailInformationFragment : BottomSheetDialogFragment() {

    lateinit var binding : BottomfragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setStyle(STYLE_NORMAL, R.style.Theme_AppCompat_DayNight_DialogWhenLarge)
        binding = BottomfragmentDetailBinding.inflate(
            inflater,container,false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.detailBottomSheet.layoutParams.height = getWindowHeight()
    }
    private fun getWindowHeight(): Int {
        // Calculate window height for fullscreen use
        val displayMetrics = DisplayMetrics()
        (context as Activity?)!!.windowManager.defaultDisplay.getMetrics(displayMetrics)
        return displayMetrics.heightPixels
    }
    companion object{
        const val TAG = "DetailInformationFragment"
        fun newInstance() = DetailInformationFragment()
    }
}