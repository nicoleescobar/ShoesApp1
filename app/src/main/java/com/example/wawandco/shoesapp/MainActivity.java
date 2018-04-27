package com.example.wawandco.shoesapp;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText cantidad;
    private Spinner  generos, tipos, marcas;
    private TextView total;
    private Resources resources;
    double precio;
    private String sexos[], tiposList[], marcasList[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resources = this.getResources();
        cantidad = findViewById(R.id.cantidadTxt);
        total = findViewById(R.id.resultado);

        generos = findViewById(R.id.GeneroSpinner);
        tipos = findViewById(R.id.TipoSpinner);
        marcas = findViewById(R.id.MarcaSpinner);

        sexos = resources.getStringArray(R.array.sexo);
        tiposList= resources.getStringArray(R.array.tipos);
        marcasList = resources.getStringArray(R.array.marcas);

        ArrayAdapter<String> gAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, sexos);
        generos.setAdapter(gAdapter);

        ArrayAdapter<String> tAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, tiposList);
        tipos.setAdapter(tAdapter);

        ArrayAdapter<String> mAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, marcasList);
        marcas.setAdapter(mAdapter);

    }


    public void showTotal(View v) {
        int marcaVal;
        int sexoVal;
        int tipoVal;


        total.setText(" ");
        cantidad.setError(null);
        int cant = TextUtils.isEmpty(cantidad.getText())  ? 1 : Integer.parseInt(cantidad.getText().toString());
        precio = 0;

        if (validate(cant)){

            marcaVal = marcas.getSelectedItemPosition();
            sexoVal = generos.getSelectedItemPosition();
            tipoVal = tipos.getSelectedItemPosition();

            precio = Metodos.total(cant, marcaVal, sexoVal, tipoVal);
            total.setText(resources.getString(R.string.totalLabel) + ": $" + precio);
        } else {
            cantidad.setError(resources.getString(R.string.cantidadError));
        }
    }

    public boolean validate(int cant){
        return cant > 0;
    }


    public void clear(View v) {
        total.setText("");
        cantidad.setText("");
        cantidad.setError(null);
        cantidad.requestFocus();
        marcas.setSelection(0);
        generos.setSelection(0);
        tipos.setSelection(0);
    }
}
