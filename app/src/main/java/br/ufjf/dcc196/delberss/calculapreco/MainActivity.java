package br.ufjf.dcc196.delberss.calculapreco;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.util.ValueIterator;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView textPrecoFinal;
    private EditText editTextPreco;
    private CheckBox checkBoxParaPresente;
    private CheckBox checkBoxExpresso;
    private RadioGroup radioGroupPagamento;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textPrecoFinal = findViewById(R.id.precoFinal);
        editTextPreco = findViewById(R.id.editTextPreco);
        checkBoxParaPresente = findViewById(R.id.checkBoxPresente);
        checkBoxExpresso = findViewById(R.id.checkBoxExpresso);
        radioGroupPagamento = findViewById(R.id.radioGroupPagamento);

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

        switch (radioGroupPagamento.getCheckedRadioButtonId()){
            case R.id.emDinheiro:
                precoFinal -= 0.05*preco;
                break;
            case R.id.umaVezCartao:
                precoFinal += 0.03*preco;
                break;
            case R.id.tresVezesCartao:
                precoFinal += 0.06*preco;
                break;
            case R.id.cincoVezesCartao:
                precoFinal += 0.09*preco;
                break;
        }

        Locale locale = new Locale("pt", "BR");
        textPrecoFinal.setText(NumberFormat.getCurrencyInstance(locale).format(precoFinal));
    }


}