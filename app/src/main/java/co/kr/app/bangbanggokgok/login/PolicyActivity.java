package co.kr.app.bangbanggokgok.login;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.pluslibrary.server.PlusOnGetDataListener;

import co.kr.app.bangbanggokgok.BBGGCommonActivity;
import co.kr.app.bangbanggokgok.BBGGConstants;
import co.kr.app.bangbanggokgok.R;

/**
 * Created by johnny on 15. 2. 23.
 */
public class PolicyActivity extends BBGGCommonActivity implements PlusOnGetDataListener {

    private static final int LOG_IN = 0;

    private String mID;
    private SharedPreferences mSharedPreference;
    private String mPassword;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy);
        //!!서버연동

        addListenerToCheckbox();

    }

    private void addListenerToCheckbox() {
        final CheckBox serviceCheckbox = (CheckBox) findViewById(R.id.checkbox_policy_service);
        final CheckBox privacyCheckbox = (CheckBox) findViewById(R.id.checkbox_policy_privacy);
        final CheckBox locationCheckbox = (CheckBox) findViewById(R.id.checkbox_policy_location);

        serviceCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked && privacyCheckbox.isChecked() && locationCheckbox.isChecked())
                    goToActivity();
            }
        });

        privacyCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked && serviceCheckbox.isChecked() && locationCheckbox.isChecked())
                    goToActivity();
            }
        });


        locationCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked && serviceCheckbox.isChecked() && privacyCheckbox.isChecked())
                    goToActivity();
            }
        });


    }

    private void goToActivity() {
        Intent intent = new Intent(PolicyActivity.this, getIntent().getIntExtra(BBGGConstants.KEY_SIGNUP_TYPE, 0) == 0 ? SignUpActivity.class : SignUpBrokerActivity.class);
        startActivity(intent);
        finish();


    }


    @Override
    public void onSuccess(Integer from, Object datas) {
        switch (from) {
            case LOG_IN:


                break;

            default:
                break;
        }

    }

}
