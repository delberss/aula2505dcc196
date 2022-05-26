package br.ufjf.dcc196.delberss.calculapreco;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.util.ValueIterator;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView textPrecoFinal;
    private EditText editTextPreco;
    private CheckBox checkBoxParaPresente;
    private CheckBox checkBoxExpresso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textPrecoFinal = findViewById(R.id.precoFinal);
        editTextPreco = findViewById(R.id.editTextPreco);
        checkBoxParaPresente = findViewById(R.id.checkBoxPresente);
        checkBoxExpresso = findViewById(R.id.checkBoxExpresso);

    }
    public void calcularPreco(View view){

        Double preco = Double.parseDouble(editTextPreco.getText().toString());
        Double precoFinal = preco;
        if (checkBoxParaPresente.isChecked()){
            precoFinal += 5.00;
        }

        if (checkBoxExpresso.isChecked()){
            precoFinal += 12.00;
        }

        Locale locale = new Locale("pt", "BR");
        textPrecoFinal.setText(NumberFormat.getCurrencyInstance(locale).format(precoFinal));
    }


}