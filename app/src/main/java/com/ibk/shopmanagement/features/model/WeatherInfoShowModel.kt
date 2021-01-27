package com.ibk.shopmanagement.features.model

import com.ibk.shopmanagement.common.RequestCompleteListener
import com.ibk.shopmanagement.features.model.data_class.City
import com.ibk.shopmanagement.features.model.data_class.WeatherInfoResponse


interface WeatherInfoShowModel {
    fun getCityList(callback: RequestCompleteListener<MutableList<City>>)
    fun getWeatherInfo(cityId: Int, callback: RequestCompleteListener<WeatherInfoResponse>)
}