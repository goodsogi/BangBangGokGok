package co.kr.app.bangbanggokgok.activity;

import android.app.Activity;
import android.os.Bundle;

import co.kr.app.bangbanggokgok.R;


public class DirectinputActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directinput);

        SoftMenuActivity softmenu = (SoftMenuActivity) findViewById(R.id.softmenu_menu_list);
        softmenu.setSofeMenuEvent(3, this);
    }
}