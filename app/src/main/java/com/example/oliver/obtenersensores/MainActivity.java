package com.example.oliver.obtenersensores;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SensorManager sensorManager;
    ListView List;
    ArrayList<Lista_entrada> datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List = (ListView) findViewById(R.id.lv_sensor);
        datos = new ArrayList<Lista_entrada>();
        sensorManager = (SensorManager)this.getSystemService(SENSOR_SERVICE);
        List<Sensor> lista = sensorManager.getSensorList(Sensor.TYPE_ALL);

        for(int i=0; i<lista.size(); i++){
            datos.add(new Lista_entrada(
                    "Nombre : "+lista.get(i).getName(),
                    "Fabricante : "+lista.get(i).getVendor(),
                    "Versión : "+lista.get(i).getVersion()));
        }
        List.setAdapter(new Lista_adaptador(this,R.layout.entrada,datos) {
            @Override
            public void onEntrada(Object entrada, View view) {
                if (entrada!=null){

                    TextView texto_superior_entrada = (TextView) view.findViewById(R.id.tv_nombre);
                    if (texto_superior_entrada != null)
                        texto_superior_entrada.setText(((Lista_entrada) entrada).getNombre());

                    TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.tv_fabricante);
                    if (texto_inferior_entrada != null)
                        texto_inferior_entrada.setText(((Lista_entrada) entrada).getFabricante());

                    TextView texto_inferior_entrada1 = (TextView) view.findViewById(R.id.tv_version);
                    if (texto_inferior_entrada1 != null)
                        texto_inferior_entrada1.setText(((Lista_entrada) entrada).getVersion());

                }
            }
        });
    }
}
