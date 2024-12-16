package com.joelpigem.appprecafeteria

import android.view.Menu
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShareViewModel : ViewModel() {



    private val _primerPlat = MutableLiveData<MenuModel>()
    val primerPlat: LiveData<MenuModel> = _primerPlat

    private val _beguda = MutableLiveData<MenuModel>()
    val beguda: LiveData<MenuModel> = _beguda

    private val _preuTotalPrimerPlat = MutableLiveData<Int>()
    val preuTotalPrimerPlat: LiveData<Int>  = _preuTotalPrimerPlat

    private val _preuTotalBeguda = MutableLiveData<Int>()
    val preuTotalBeguda: LiveData<Int> = _preuTotalBeguda

    private val _preuTotal = MutableLiveData<Int>()
    val preuTotal: LiveData<Int> = _preuTotal


   /*private var _primerPlat = MenuModel(tipus = "primerPlat", nom = "", quantitat = 0, preuUnitari = 0)
    val primerPlat: MenuModel
        get() = _primerPlat

    private var _beguda = MenuModel(tipus = "beguda", nom = "", quantitat = 0, preuUnitari = 0)
    val beguda: MenuModel
        get() = _beguda

    private var _preuTotalPrimerPlat = 0
    val preuTotalPrimerPlat: Int
        get() = _preuTotalPrimerPlat

    private var _preuTotalBeguda = 0
    val preuTotalBeguda: Int
        get() = _preuTotalBeguda

    private var _preuTotal = 0
    val preuTotal: Int
        get() = _preuTotal*/

    fun afegirAlMenu(menuModel: MenuModel) {
        if (menuModel.tipus == "primerPlat") {
            _primerPlat.value = menuModel
            println(menuModel)
        } else {
            _beguda.value = menuModel
        }
    }

    fun calcularPreuTotal() {
        _preuTotalPrimerPlat.value = (_primerPlat.value?.preuUnitari ?: 0) * (_primerPlat.value?.quantitat ?: 0)
        _preuTotalBeguda.value = (beguda.value?.preuUnitari ?: 0) * (beguda.value?.quantitat ?: 0)

        _preuTotal.value = _preuTotalPrimerPlat.value!! + _preuTotalBeguda.value!!
    }
}