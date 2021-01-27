package com.ibk.shopmanagement.inderdependentspinner

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ibk.shopmanagement.R
import com.ibk.shopmanagement.databinding.ActivityInterDependentSpinnerBinding


class InterDependentSpinnerActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityInterDependentSpinnerBinding
    private lateinit var selectedClass: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_inter_dependent_spinner)

        val adapter: ArrayAdapter<String> =
            ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item, resources.getStringArray(
                    R.array.items_class
                )
            )
        binding.spinner.adapter = adapter

        binding.spinner.onItemSelectedListener = this
        binding.spinner2.onItemSelectedListener = this

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        selectedClass = parent!!.getItemAtPosition(position).toString()

        val spinner = parent as Spinner

        if (spinner.id == R.id.spinner) {
            when (parent!!.getItemAtPosition(position).toString()) {
                "Class 1" ->
                    binding.spinner2.adapter = ArrayAdapter(
                        this,
                        android.R.layout.simple_spinner_dropdown_item,
                        resources.getStringArray(R.array.items_div_class_1)
                    )
                "Class 2" -> binding.spinner2.adapter = ArrayAdapter(
                    this,
                    android.R.layout.simple_spinner_dropdown_item,
                    resources.getStringArray(R.array.items_div_class_2)
                )
                "Class 3" -> binding.spinner2.adapter = ArrayAdapter(
                    this,
                    android.R.layout.simple_spinner_dropdown_item,
                    resources.getStringArray(R.array.items_div_class_3)
                )
                "Class 4" -> binding.spinner2.adapter = ArrayAdapter(
                    this,
                    android.R.layout.simple_spinner_dropdown_item,
                    resources.getStringArray(R.array.items_div_class_4)
                )
            }

            //set divSpinner Visibility to Visible
            binding.spinner2.visibility = View.VISIBLE

        } else if (spinner.id == R.id.spinner2) {
            var selectedDiv = parent.getItemAtPosition(position).toString()
            Toast.makeText(
                applicationContext, "Class: " + selectedClass +
                        "Div: " + selectedDiv, Toast.LENGTH_LONG
            ).show();
        }


    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}