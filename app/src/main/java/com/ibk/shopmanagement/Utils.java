package com.ibk.shopmanagement;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class Utils {

    public static void prepareSpinner(Context context, Spinner spinner, ArrayList<String> data, String selectedItem) {

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, data);
        spinner.setAdapter(adapter);

        if (selectedItem != null && selectedItem.length() > 0) {
            int selectedPosition = adapter.getPosition(selectedItem);

            spinner.setSelection(selectedPosition);
        }
    }


}
