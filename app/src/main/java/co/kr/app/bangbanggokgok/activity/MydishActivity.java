package co.kr.app.bangbanggokgok.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.pluslibrary.server.PlusHttpClient;
import com.pluslibrary.server.PlusOnGetDataListener;

import java.io.Serializable;
import java.util.ArrayList;

import co.kr.app.bangbanggokgok.BBGGCommonActivity;
import co.kr.app.bangbanggokgok.R;
import co.kr.app.bangbanggokgok.adapter.AllListAdapter;
import co.kr.app.bangbanggokgok.server.AllListModel;
import co.kr.app.bangbanggokgok.server.AllListParser;
import co.kr.app.bangbanggokgok.server.BBGGApiConstants;


public class MydishActivity extends BBGGCommonActivity implements PlusOnGetDataListener {

    ListView listview;
    AllListAdapter adapter;
    private final int GET_MY_BOOKMARK = 3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydish);
        getDataFromServer();


    }

    public void getDataFromServer() {
        //!!Api 주소 입력
        new PlusHttpClient(this, this, false).execute(GET_MY_BOOKMARK,
                BBGGApiConstants.GET_MY_BOOKMARK + "&id=" + getUserId(),
                new AllListParser());

    }

    private void makeList(ArrayList<AllListModel> datas) {

        listview = (ListView) findViewById(R.id.mylist);
        adapter = new AllListAdapter(getApplicationContext(), datas);
        listview.setOnItemClickListener(mItemClickListener);
        listview.setAdapter(adapter);
    }

    AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {
        @SuppressWarnings("unchecked")
        public void onItemClick(AdapterView parent, View view, int position,
                                long id) {

            Intent board = new Intent(MydishActivity.this, AllListDetailActivity.class);
            board.putExtra("data", (Serializable) parent.getItemAtPosition(position));
            startActivity(board);
        }
    };

    @Override
    public void onSuccess(Integer from, Object datas) {
        switch (from) {
            case GET_MY_BOOKMARK:

                makeList((ArrayList<AllListModel>) datas);

                break;


        }

    }

}