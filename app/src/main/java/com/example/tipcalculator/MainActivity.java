package com.example.tipcalculator; //anything

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editCost;
    private TextView textOutput;
    private SeekBar seekBar;
    private TextView textBarLabel;
    private RadioGroup radioGroup;
    private RadioButton radioParty;
    private EditText editParty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textBarLabel = findViewById(R.id.textBarLabel);
        initSeekBar();
        initEditCost();
        initRadioGroup();
        initEditParty();

        textOutput = findViewById(R.id.textOutput);
    }

    private void initRadioGroup() {
        radioGroup = findViewById(R.id.radioGroup);
        radioParty = findViewById(R.id.radioParty);
        editParty = findViewById(R.id.editParty);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (radioParty.isChecked()) { // Party button selected
                        editParty.setEnabled(true);

                } else { // Single button selected
                    editParty.setEnabled(false);
                }

                calculate();
            }//edit text for party
        });
    }

    private void initEditCost() {
        editCost = findViewById(R.id.editCost);
        editCost.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_DONE) {
                    calculate();
                }
                return false;
            }
        });
    }

    private void initEditParty() {
        editParty = findViewById(R.id.editParty);
        editParty.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_DONE) {
                    calculate();
                }

                return false;
            }
        });
    }
    private void initSeekBar()  {
        seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textBarLabel.setText(i+"");
                calculate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calculate(){
        String input = editCost.getText().toString();
        String input2 = editParty.getText().toString();
        if (!input.equals("")) {
            double bill = Double.parseDouble(input);
            bill += bill * (seekBar.getProgress() / 100.0);
            if (radioParty.isChecked()) {
                if (!input2.equals("")) {
                    double party = Double.parseDouble(editParty.getText().toString());
                    bill /= party;

                }
                textOutput.setText("$" + String.format("%.2f", bill));

            }else {
                textOutput.setText("$" + String.format("%.2f", bill));
            }
    }

}

}