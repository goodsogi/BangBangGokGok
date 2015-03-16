package co.kr.app.bangbanggokgok.adapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pluslibrary.utils.PlusViewHolder;

import co.kr.app.bangbanggokgok.BBGGConstants;
import co.kr.app.bangbanggokgok.R;
import co.kr.app.bangbanggokgok.server.AllListModel;


public class AllListAdapter extends BBGGCommonAdapter<AllListModel> {


	public AllListAdapter(Context context, ArrayList<AllListModel> datas) {
        super(context, R.layout.activity_alllistview, datas);

	}


	public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.activity_alllistview,
                    parent, false);
        }

        AllListModel data = mDatas.get(position);
		TextView deposit = PlusViewHolder.get(convertView, R.id.deposit);
		TextView area = PlusViewHolder.get(convertView, R.id.area);
		TextView one_report = PlusViewHolder.get(convertView, R.id.one_report);

		ImageView main_img = PlusViewHolder.get(convertView, R.id.main_img);

        String priceText =  !data.getPrice11().trim().equals("")? data.getPrice11() + "/" +data.getPrice01():data.getPrice01();
		deposit.setText(priceText);
        //deposit.setTextColor(data.getGubun().equals("1") ? Color.RED: Color.BLUE);
        deposit.setTextColor(Color.parseColor("#73c507"));
		area.setText(data.getAddress() + ", " + data.getFloor());
		one_report.setText(data.getSubject());

        mImageLoader.displayImage(
                BBGGConstants.IMG_URL_HEAD + mDatas.get(position).getImg01(), main_img,
                mOption);

        treatOptionView(getOptions(data.getOptions()), convertView);


		Log.e("리스트뷰화면뿌리기" , "LazyAdapter I >" +position );


		return convertView;
	}

    private void treatOptionView(List<String> options, View convertView) {

        ImageView option_01 = PlusViewHolder.get(convertView, R.id.option_01);
        ImageView option_02 = PlusViewHolder.get(convertView, R.id.option_02);
        ImageView option_03 = PlusViewHolder.get(convertView, R.id.option_03);
        ImageView option_04 = PlusViewHolder.get(convertView, R.id.option_04);
        ImageView option_05 = PlusViewHolder.get(convertView, R.id.option_05);


        if (options.contains("1")) {
            option_01.setVisibility(View.VISIBLE);
        }else {
            option_01.setVisibility(View.GONE);
        }

        if (options.contains("2")) {
            option_02.setVisibility(View.VISIBLE);
        }else {
            option_02.setVisibility(View.GONE);
        }

        if (options.contains("3")) {
            option_03.setVisibility(View.VISIBLE);
        }else {
            option_03.setVisibility(View.GONE);
        }

        if (options.contains("4")) {
            option_04.setVisibility(View.VISIBLE);
        }else {
            option_04.setVisibility(View.GONE);
        }

        if (options.contains("5")) {
            option_05.setVisibility(View.VISIBLE);
        }else {
            option_05.setVisibility(View.GONE);
        }



    }

    private java.util.List<String> getOptions(String options) {
        String [] tokens = options.trim().split(",");

        return Arrays.asList(tokens);
    }


}