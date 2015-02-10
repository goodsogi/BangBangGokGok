package co.kr.app.bangbanggokgok.adapter;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import co.kr.app.bangbanggokgok.R;
import co.kr.app.bangbanggokgok.board.DishBoard;
import co.kr.app.bangbanggokgok.board.MyBoard;


public class DishAdapter extends BaseAdapter{

	private ArrayList<DishBoard> arrData;
	private Activity activity;
	private static LayoutInflater inflater;


	public DishAdapter(Context context,Activity a, ArrayList<DishBoard> m_board ) {
		activity = a;
		arrData = m_board;
		inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		//        imageLoader = new ImageLoader(activity.getApplicationContext());

	}

	public int getCount() {
		return arrData.size();
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		View vi=convertView;
		if (convertView == null) {
			vi = inflater.inflate(R.layout.activity_mydishview, null);
		}

		DishBoard board = arrData.get(position);
		TextView deposit = (TextView) vi.findViewById(R.id.deposit);
		TextView area = (TextView) vi.findViewById(R.id.area);
		TextView one_report = (TextView) vi.findViewById(R.id.one_report);

		ImageView main_img = (ImageView) vi.findViewById(R.id.main_img);
		ImageView option_01 = (ImageView) vi.findViewById(R.id.option_01);
		ImageView option_02 = (ImageView) vi.findViewById(R.id.option_02);
		ImageView option_03 = (ImageView) vi.findViewById(R.id.option_03);
		ImageView option_04 = (ImageView) vi.findViewById(R.id.option_04);
		ImageView option_05 = (ImageView) vi.findViewById(R.id.option_05);
		Log.d("CHECK", "이미지값-->" + board.getMain_img());

		deposit.setText(board.getDeposit());
		area.setText(board.getArea());
		one_report.setText(board.getOne_report());

		if (board.getMain_img().equals("1")) {
			main_img.setBackgroundResource(R.drawable.img_photo_01);
		}else if (board.getMain_img().equals("3")) {
			main_img.setBackgroundResource(R.drawable.img_photo_01);
		}else
			main_img.setBackgroundResource(R.drawable.img_photo_02);


		if (board.getOption_01().equals("1")) {
			option_01.setVisibility(View.VISIBLE);
		}else {
			option_01.setVisibility(View.GONE);
		}

		if (board.getOption_02().equals("1")) {
			option_02.setVisibility(View.VISIBLE);
		}else {
			option_02.setVisibility(View.GONE);
		}
		
		if (board.getOption_03().equals("1")) {
			option_03.setVisibility(View.VISIBLE);
		}else {
			option_03.setVisibility(View.GONE);
		}
		
		if (board.getOption_04().equals("1")) {
			option_04.setVisibility(View.VISIBLE);
		}else {
			option_04.setVisibility(View.GONE);
		}
		
		if (board.getOption_05().equals("1")) {
			option_05.setVisibility(View.VISIBLE);
		}else {
			option_05.setVisibility(View.GONE);
		}


		Log.e("리스트뷰화면뿌리기" , "LazyAdapter I >" +position );


		return vi;
	}


}