package com.ibk.shopmanagement.features.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ibk.shopmanagement.R
import com.ibk.shopmanagement.Utils
import com.ibk.shopmanagement.Values
import com.ibk.shopmanagement.Values.productType.OTHERS
import com.ibk.shopmanagement.databinding.ActivityMainBinding
import com.ibk.shopmanagement.inderdependentspinner.InterDependentSpinnerActivity
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var productName: String;
    private lateinit var productType: String;
    private lateinit var otherProductType: String;
    private lateinit var productDescription: String;
    private lateinit var productVendor: String;
    private lateinit var productVendorAddress: String;
    private lateinit var productVendorPhone: String;
    private lateinit var productQuantityInStock: String;
    private var productBuyPrice by Delegates.notNull<Long>();
    private var productMSRP by Delegates.notNull<Long>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        init()


    }

    private fun init() {
        binding.txtProductName.setOnClickListener {
            val intent = Intent(this, InterDependentSpinnerActivity::class.java)
            startActivity(intent)
        }
        Utils.prepareSpinner(
            this,
            binding.spProductType,
            Values.getProductTypeData(),
            Values.getProductTypeData()[0]
        )

        binding.spProductType.onItemSelectedListener = this

        binding.btnSave.setOnClickListener {
            productType = if (OTHERS.name == binding.spProductType.selectedItem.toString()) {
                if (binding.etOtherProductType.text.toString().isNotEmpty())
                    binding.etOtherProductType.text.toString()
                else
                    "product type empty"

            } else
                binding.spProductType.selectedItem.toString()

            Toast.makeText(applicationContext, productType, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if (OTHERS.name == binding.spProductType.selectedItem.toString()) {
            binding.etOtherProductType.visibility = View.VISIBLE
        } else {
            binding.etOtherProductType.visibility = View.GONE
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }


}