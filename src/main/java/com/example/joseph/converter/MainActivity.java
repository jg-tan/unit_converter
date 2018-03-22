package com.example.joseph.converter;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.media.Image;
import android.nfc.cardemulation.CardEmulation;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    /** Declarations */
    EditText etInput1,etInput2;
    ImageButton btnLength, btnWeight, btnCurrency;
    Spinner spinnerUnit1, spinnerUnit2;
    ArrayAdapter<CharSequence> adapterLen,adapterWt,adapterCur;
    DecimalFormat decimal = new DecimalFormat("#.##");

    int mEditTextId;
    int mConvTypeId;
    double mInput = 0;
    double mOutput = 0;

    String mConvType;
    String mUnit1;
    String mUnit2;

    //Saved Instance Declarations
    static final String STATE_INPUT_1 = "INPUT_1";
    static final String STATE_INPUT_2 = "INPUT_2";
    static final String STATE_EDIT_TEXT_ID = "EDIT_TEXT_ID";
    static final String STATE_CONV_TYPE = "CONVERSION_TYPE";
    static final String STATE_SPIN_POS_1 = "SPINNER1";
    static final String STATE_SPIN_POS_2 = "SPINNER2";
    static final String STATE_CONV_TYPE_ID = "CONVERSION_TYPE_ID";
    static double sInput1 = 0;
    static double sInput2 = 0;
    static int sSaveSpin1 = 0;
    static int sSaveSpin2 = 0;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /** Determine orientation */
        switch(getResources().getConfiguration().orientation){
            case Configuration.ORIENTATION_PORTRAIT:
                setContentView(R.layout.activity_main);
                break;
            case Configuration.ORIENTATION_LANDSCAPE:
                setContentView(R.layout.activity_main_landscape);
                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
                break;
        }

        /** Declarations */

        final Converter[] mConvUnit = new Converter[3];
        mConvUnit[0] = new ConvertLength();
        mConvUnit[1] = new ConvertWeight();
        mConvUnit[2] = new ConvertCurrency();

        mUnit1 = getResources().getStringArray(R.array.length_list)[0];
        mUnit2 = getResources().getStringArray(R.array.length_list)[0];

        mConvType = getString(R.string.length);

        mEditTextId = R.id.input1;

        //Widgets
        etInput1 = (EditText) findViewById(R.id.input1);
        etInput2 = (EditText) findViewById(R.id.input2);

        btnLength = (ImageButton) findViewById(R.id.lengthButton);
        btnWeight = (ImageButton) findViewById(R.id.weightButton);
        btnCurrency = (ImageButton) findViewById(R.id.currencyButton);

        spinnerUnit1 = (Spinner) findViewById(R.id.input1_list);
        spinnerUnit2 = (Spinner) findViewById(R.id.input2_list);

        adapterLen = ArrayAdapter.createFromResource(this, R.array.length_list,android.R.layout.simple_spinner_item);
        adapterLen.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterWt = ArrayAdapter.createFromResource(this, R.array.weight_list,android.R.layout.simple_spinner_item);
        adapterWt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterCur = ArrayAdapter.createFromResource(this, R.array.currency_list,android.R.layout.simple_spinner_item);
        adapterCur.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerUnit1.setAdapter(adapterLen);
        spinnerUnit2.setAdapter(adapterLen);

        /** Sets activity for pressing Length Button */
        btnLength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                mConvTypeId = 0;
                spinnerUnit1.setAdapter(adapterLen);
                spinnerUnit2.setAdapter(adapterLen);
                compOutput(mConvUnit, mConvTypeId);
                displayOutput();
                mConvType = getString(R.string.length);
            }

        });

        /** Sets activity for pressing Weight Button */
        btnWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                mConvTypeId = 1;
                spinnerUnit1.setAdapter(adapterWt);
                spinnerUnit2.setAdapter(adapterWt);
                compOutput(mConvUnit, mConvTypeId);
                displayOutput();
                mConvType = getString(R.string.weight);
            }

        });

        /** Sets activity for pressing Currency Button */
        btnCurrency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                mConvTypeId = 2;
                spinnerUnit1.setAdapter(adapterCur);
                spinnerUnit2.setAdapter(adapterCur);
                compOutput(mConvUnit, mConvTypeId);
                displayOutput();
                mConvType = getString(R.string.currency);
            }

        });

        /** Sets activity for pressing selecting item in Spinner 1 */
        spinnerUnit1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                mUnit1 = adapterView.getItemAtPosition(position).toString();
                compOutput(mConvUnit, mConvTypeId);
                displayOutput();
                sSaveSpin1 = adapterView.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        /** Sets activity for pressing selecting item in Spinner 2 */
        spinnerUnit2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                mUnit2 = adapterView.getItemAtPosition(position).toString();
                compOutput(mConvUnit, mConvTypeId);
                displayOutput();
                sSaveSpin2 = adapterView.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        /** Contains text mWatcher for changing input in both text fields */
        final TextWatcher mWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().isEmpty()){
                    try{
                        mInput = Double.parseDouble(charSequence.toString());
                    } catch (NumberFormatException nfe){
                        mInput = Double.parseDouble("0.");
                    }
                } else {
                    /** Uses 0 as input if blank field to display 0 on result */
                    mInput = 0;
                }
                compOutput(mConvUnit, mConvTypeId);
                displayOutput();
                saveInput();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                /** Removes leading 0s */
                char[] editChar = editable.toString().toCharArray();
                int charLength = editable.toString().length();
                for(int i = 0; i < charLength-1; i++){
                    if(editChar[i] != '0') break;
                    if(editChar[i] == '0' && editChar[i+1] != '0' && editChar[i+1] != '.'){
                        if (mEditTextId == R.id.input1) {
                            etInput1.removeTextChangedListener(this);
                            etInput1.setText(String.valueOf(decimal.format(mInput)));
                            etInput1.setSelection(etInput1.getText().length());
                            etInput1.addTextChangedListener(this);
                        } else if (mEditTextId == R.id.input2) {
                            etInput2.removeTextChangedListener(this);
                            etInput2.setText(String.valueOf(decimal.format(mInput)));
                            etInput2.setSelection(etInput2.getText().length());
                            etInput2.addTextChangedListener(this);
                        }
                        break;
                    }
                }
            }
        };

        /** Adds or removes text mWatcher to the active text field */
        etInput1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, final boolean inputFocus) {
                if(inputFocus){
                    etInput1.addTextChangedListener(mWatcher);
                    mEditTextId = R.id.input1;
                } else {
                    etInput1.removeTextChangedListener(mWatcher);
                }
            }
        });

        etInput2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean inputFocus) {
                if(inputFocus){
                    etInput2.addTextChangedListener(mWatcher);
                    mEditTextId = R.id.input2;
                } else {
                    etInput2.removeTextChangedListener(mWatcher);
                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putDouble(STATE_INPUT_1, sInput1);
        outState.putDouble(STATE_INPUT_2, sInput2);
        outState.putString(STATE_CONV_TYPE, mConvType);
        outState.putInt(STATE_EDIT_TEXT_ID, mEditTextId);
        outState.putInt(STATE_SPIN_POS_1, sSaveSpin1);
        outState.putInt(STATE_SPIN_POS_2, sSaveSpin2);
        outState.putInt(STATE_CONV_TYPE_ID, mConvTypeId);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mConvType = savedInstanceState.getString(STATE_CONV_TYPE);
        mConvTypeId = savedInstanceState.getInt(STATE_CONV_TYPE_ID);
        mEditTextId = savedInstanceState.getInt(STATE_EDIT_TEXT_ID);
        setSpinnerAdapter();
        spinnerUnit1.setSelection(savedInstanceState.getInt(STATE_SPIN_POS_1));
        spinnerUnit2.setSelection(savedInstanceState.getInt(STATE_SPIN_POS_2));
        etInput1.setText(String.valueOf(decimal.format(savedInstanceState.getDouble(STATE_INPUT_1))));
        etInput2.setText(String.valueOf(decimal.format(savedInstanceState.getDouble(STATE_INPUT_2))));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        switch(newConfig.orientation){
            case Configuration.ORIENTATION_PORTRAIT:
                setContentView(R.layout.activity_main);
                break;
            case Configuration.ORIENTATION_LANDSCAPE:
                setContentView(R.layout.activity_main_landscape);
                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
                break;
        }
    }

    /** Computes and determines what text field is being converted */
    private void compOutput(Converter[] mConvUnit, int convId) {
        if(mEditTextId == R.id.input1) {
            mOutput = mConvUnit[convId].convert(mUnit1, mUnit2, mInput);
        } else if(mEditTextId == R.id.input2){
            mOutput = mConvUnit[convId].convert(mUnit2, mUnit1, mInput);
        }
    }

    /** Restores spinner adapter settings after orientation change */
    private void setSpinnerAdapter(){
        mConvType = mConvType.toLowerCase();
        switch(mConvType){
            case "length":
                spinnerUnit1.setAdapter(adapterLen);
                spinnerUnit2.setAdapter(adapterLen);
                break;
            case "weight":
                spinnerUnit1.setAdapter(adapterWt);
                spinnerUnit2.setAdapter(adapterWt);
                break;
            case "currency":
                spinnerUnit1.setAdapter(adapterCur);
                spinnerUnit2.setAdapter(adapterCur);
                break;
        }
    }

    /** Displays output */
    private void displayOutput(){
        if(mEditTextId == R.id.input1){
            etInput2.setText(String.valueOf(mOutput));
        } else if(mEditTextId == R.id.input2){
            etInput1.setText(String.valueOf(mOutput));
        }
    }

    /** Saves input on savedInstanceBundle */
    private void saveInput(){
        try{
            sInput1 = Double.parseDouble(etInput1.getText().toString());
            sInput2 = Double.parseDouble(etInput2.getText().toString());
        } catch (NumberFormatException nfe){
            sInput1 = 0;
            sInput2 = 0;
        }
    }
}
