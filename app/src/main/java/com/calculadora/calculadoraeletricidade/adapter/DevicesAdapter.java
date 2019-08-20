package com.calculadora.calculadoraeletricidade.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.calculadora.calculadoraeletricidade.Device;
import com.calculadora.calculadoraeletricidade.R;

import java.util.ArrayList;

public class DevicesAdapter extends ArrayAdapter<Device> {
    public DevicesAdapter(Context context, ArrayList<Device> device) {
        super(context, 0, device);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Device device = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_devices, parent, false);
        }

        TextView tvDevice = (TextView) convertView.findViewById(R.id.textDevice);
        TextView tvPotencia = (TextView) convertView.findViewById(R.id.textPotencia);

        tvDevice.setText(device.getName());
        tvPotencia.setText(String.valueOf(device.getPower()) + " watts");


        return convertView;
    }

}
