package co.kr.app.bangbanggokgok;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;

/**
 * Created by johnny on 15. 2. 23.
 */
public class BBGGCommonActivity extends Activity {

    public void goBack(View v) {
       finish();
    }

    public String getUserId() {
        SharedPreferences sharedPreference = getSharedPreferences(
                BBGGConstants.PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreference.getString(BBGGConstants.KEY_USER_ID,"");
    }
}
