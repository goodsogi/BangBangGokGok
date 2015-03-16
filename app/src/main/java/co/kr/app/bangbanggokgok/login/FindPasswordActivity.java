package co.kr.app.bangbanggokgok.login;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.pluslibrary.server.PlusHttpClient;
import com.pluslibrary.server.PlusInputStreamStringConverter;
import com.pluslibrary.server.PlusOnGetDataListener;
import com.pluslibrary.utils.PlusClickGuard;
import com.pluslibrary.utils.PlusToaster;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

import co.kr.app.bangbanggokgok.BBGGCommonActivity;
import co.kr.app.bangbanggokgok.BBGGConstants;
import co.kr.app.bangbanggokgok.R;
import co.kr.app.bangbanggokgok.server.BBGGApiConstants;

/**
 * Created by johnny on 15. 2. 23.
 */
public class FindPasswordActivity extends BBGGCommonActivity implements PlusOnGetDataListener {

    private static final int FIND_PASSWORD = 0;


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_password);


    }


    public void findPassword(View v) {

        PlusClickGuard.doIt(v);

        //  이메일주소
        EditText userEmailInput = (EditText) findViewById(R.id.userEmail);
        String userEmail = userEmailInput.getText().toString();

        if (userEmail.equals("")) {
            PlusToaster.doIt(this, "이메일주소를 입력해주세요");
            return;
        }


        //api 수정 필요!!
        new PlusHttpClient(this, this, false).execute(FIND_PASSWORD,
                BBGGApiConstants.FIND_PASSWORD + "?email=" + userEmail, new PlusInputStreamStringConverter());

    }



    @Override
    public void onSuccess(Integer from, Object datas) {
        switch (from) {
            case FIND_PASSWORD:


                break;

            default:
                break;
        }

    }

}
