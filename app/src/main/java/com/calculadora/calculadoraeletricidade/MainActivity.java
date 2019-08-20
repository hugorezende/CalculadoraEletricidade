package com.calculadora.calculadoraeletricidade;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.calculadora.calculadoraeletricidade.adapter.DevicesAdapter;
import com.calculadora.calculadoraeletricidade.helper.MaskWatcher;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Device> arrayDevices = new ArrayList<>();
    private DevicesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculo_mensal);
        ListView listNotas = findViewById(R.id.device_list);
        adapter = new DevicesAdapter(this,arrayDevices);
        listNotas.setAdapter(adapter);

    }

    public void addDevice(View view){
        Device device = new Device("Geladeira", 30,20,5);
        arrayDevices.add(device);
        adapter.notifyDataSetChanged();
    }

    public void calculatePower(View v){
        TextView powerText = (TextView)findViewById(R.id.editText_power);
        TextView diasText = (TextView)findViewById(R.id.editText_dias);
        TextView horasText = (TextView)findViewById(R.id.editText_horas);

        TextView resultadoText = (TextView)findViewById(R.id.textView_resultado);

        Double power = Double.parseDouble(powerText.getText().toString());
        Double dias = Double.parseDouble(diasText.getText().toString());
        Double horas = Double.parseDouble(horasText.getText().toString());
        arrayDevices.get(0).setPower(power);
        arrayDevices.get(0).setDaysPerWeek(dias);
        arrayDevices.get(0).setHoursPerDay(horas);

        resultadoText.setText("Gasto de R$:" + String.format("%,.2f",arrayDevices.get(0).calculateSpent()) + " por mes");
    }
}
