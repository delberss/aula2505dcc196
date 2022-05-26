package br.ufjf.dcc196.delberss.calculapreco;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.util.ValueIterator;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView precoFinal;
    EditText editTextPreco;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoFinal = findViewById(R.id.precoFinal);
        editTextPreco = findViewById(R.id.editTextPreco);

    }
    public void calcularPreco(View view){
        Double preco = Double.parseDouble(editTextPreco.getText().toString());
        precoFinal.setText(preco.toString());
    }


}