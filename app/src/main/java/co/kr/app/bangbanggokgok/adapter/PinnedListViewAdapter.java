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
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.pluslibrary.utils.PlusViewHolder;

import co.kr.app.bangbanggokgok.BBGGConstants;
import co.kr.app.bangbanggokgok.R;
import co.kr.app.bangbanggokgok.board.ListHardBoard;
import co.kr.app.bangbanggokgok.board.MyBoard;
import co.kr.app.bangbanggokgok.common.PinnedHeaderListView.PinnedHeaderInterface;
import co.kr.app.bangbanggokgok.server.AllListModel;


public class PinnedListViewAdapter extends BBGGCommonAdapter<AllListModel> implements SectionIndexer, PinnedHeaderInterface {
	// 섹션 처리부분
//	private String[] sections = {"0","1","2"};
//	private Integer[] positionForSections = {0,3,6};
//	private int[] sectionForPositions = {0,0,0,1,1,1,2,2,2};
	
	private String[] sections;
	private Integer[] positionForSections;
	private int[] sectionForPositions ;
	String subject [] = {"이 지역 추천 공인중개사","이 지역 최신 방(1-25)" ,"이 지역 최신 방(25-50)","이 지역 최신 방(1-25)","이 지역 최신 방(1-25)","이 지역 최신 방(1-25)","이 지역 최신 방(1-25)","이 지역 최신 방(1-25)"};
	private Context context = null;
	public PinnedListViewAdapter(Context context, ArrayList<AllListModel> datas) {
        super(context, R.layout.activity_alllistview, datas);
		this.context = context;

			setupSections();
	}




	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.list_item,
                    parent, false);
        }


        AllListModel data = mDatas.get(position);


        TextView deposit = PlusViewHolder.get(convertView, R.id.deposit);
        TextView area = PlusViewHolder.get(convertView, R.id.area);
        TextView one_report = PlusViewHolder.get(convertView, R.id.one_report);

        ImageView main_img = PlusViewHolder.get(convertView, R.id.main_img);


        deposit.setText(data.getPrice01());
        area.setText(data.getAddress() + ", " + data.getFloor());
        one_report.setText(data.getSubject());

        mImageLoader.displayImage(
                BBGGConstants.IMG_URL_HEAD + mDatas.get(position).getImg01(), main_img,
                mOption);

        treatOptionView(getOptions(data.getOptions()), convertView);


        Log.e("리스트뷰화면뿌리기" , "LazyAdapter I >" +position );


        return convertView;


//		Log.e("CHECK" , "holder  POSITION  -->" + position);
//		Log.e("CHECK" , "arr.getheader_up()  POSITION  -->" + arr.getheader_up());

//		if (arr.getheader_up().equals("1")) {
//			holder.textViewHeader.setText(arr.getheader_text());
//			holder.textViewHeader.setVisibility(View.VISIBLE);
//			holder.textViewHeader.setBackgroundColor(Color.GREEN);
//
//		}else{
//			holder.textViewHeader.setVisibility(View.GONE);
//		}
//		if (arr.getimg().equals("1")) {
//			holder.img.setVisibility(View.VISIBLE);
//		}
//		if (!arr.gettext().equals("0")) {
//
//		}



	}

    private java.util.List<String> getOptions(String options) {
        String [] tokens = options.trim().split(",");

        return Arrays.asList(tokens);
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


	// pinnedHeader 처리부분
	@Override
	public int getPinnedHeaderState(int position) {
        return PinnedHeaderInterface.PINNED_HEADER_PUSHED_UP;

//		if (isSectionHeaderView(position+1)) {
//			return PinnedHeaderInterface.PINNED_HEADER_PUSHED_UP;
//		}
//		return PinnedHeaderInterface.PINNED_HEADER_VISIBLE;
	}
	private TextView headerView;
	@Override
	public View getPinnedHeaderView(int position) {
		if (headerView == null) {
			View v = LayoutInflater.from(context).inflate(R.layout.list_item, null);
			headerView = (TextView) v.findViewById(R.id.TextView_header);
			//			headerView.setBackgroundResource(R.drawable.bg_main_01_top_title);
			headerView.setBackgroundColor(Color.GREEN);

			//			headerView.setBackgroundColor(Color.argb(0, 0, 0, 0));
		}
		Log.d("CHECK" , "HEADER  POSITION  -->" + position);

		headerView.setText(subject[position]);
		return headerView;
	}





	private void setupSections() {

		List<Object> sectionList = new ArrayList<Object>();
		List<Integer> sectionPositionList = new ArrayList<Integer>();
		
		sectionForPositions = new int[mDatas.size()];
		
		String prevIndexName = null;
		int pos = 0;
		for (int i = 0; i < mDatas.size(); i++) {
			
			String indexName = mDatas.get(i).getSubject();
			if (prevIndexName == null ) {
				sectionList.add(indexName);
				sectionPositionList.add(pos);
			}
			prevIndexName = indexName;
			sectionForPositions[pos] = sectionList.size()-1;
			pos++;
		}
		sections = new String[sectionList.size()];
		positionForSections = new Integer[sectionPositionList.size()];
		
		sections = sectionList.toArray(sections);
		positionForSections = sectionPositionList.toArray(positionForSections);
		
	
	}
	private boolean isSectionHeaderView(int position) {
		for (int pos:positionForSections) {
			if (pos==position)
				return true;
		}
		return false;
	}



    @Override
	public Object[] getSections() {
		return sections;
	}
	@Override
	public int getPositionForSection(int section) {


Log.d("header", " section: " + section + " position: " + positionForSections[section]);
        return positionForSections[section];
	}
	@Override
	public int getSectionForPosition(int position) {



        return sectionForPositions[position];
	}

}
