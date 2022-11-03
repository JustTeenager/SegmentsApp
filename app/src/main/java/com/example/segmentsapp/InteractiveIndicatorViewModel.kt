package com.example.segmentsapp

import android.util.Log
import androidx.lifecycle.ViewModel

class InteractiveIndicatorViewModel : ViewModel() {
    private val indicatorManager = IndicatorManager()

    fun updateSegment(segmentNum: Int, isSelected: Boolean) {
        indicatorManager.updateIndicatorState(segmentNum = segmentNum, isSelected = isSelected)
        Log.d("tut_current","state ${indicatorManager.currentIndicatorState.joinToString("")}")
        Log.d("tut_num", "${getNumber()}")
    }

    fun getNumberText() = getNumber().number ?: getNumber().code

    fun resetIndicator() {
        indicatorManager.resetIndicator()
    }

    private fun getNumber() = indicatorManager.getNumber()
}