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
import co.kr.app.bangbanggokgok.R;
import co.kr.app.bangbanggokgok.board.SubwayBoard;
import co.kr.app.bangbanggokgok.common.H5TextView;


public class SubwayAdapter extends BaseAdapter{

	private ArrayList<SubwayBoard> arrData;
	private Activity activity;
	private static LayoutInflater inflater;


	public SubwayAdapter(Context context,Activity a, ArrayList<SubwayBoard> m_board ) {
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
			vi = inflater.inflate(R.layout.activity_subwaylistview, null);
		}

		SubwayBoard board = arrData.get(position);
		H5TextView name = (H5TextView) vi.findViewById(R.id.name);
		ImageView img = (ImageView) vi.findViewById(R.id.img);
		
		name.setText(board.getlocation());
		if (board.getstaion().equals("부산1호선")) {
			img.setBackgroundResource(R.drawable.icon_subway_01);
		}else if(board.getstaion().equals("부산2호선")){
			img.setBackgroundResource(R.drawable.icon_subway_02);
		}else if(board.getstaion().equals("2호선")){
			img.setBackgroundResource(R.drawable.icon_subway_03);
		}
		Log.e("리스트뷰화면뿌리기" , "LazyAdapter I >" +position );


		return vi;
	}


}