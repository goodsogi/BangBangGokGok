package co.kr.app.bangbanggokgok.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.pluslibrary.utils.PlusViewHolder;

import co.kr.app.bangbanggokgok.BBGGConstants;
import co.kr.app.bangbanggokgok.R;
import co.kr.app.bangbanggokgok.adapter.MyAdapter;
import co.kr.app.bangbanggokgok.board.MyBoard;
import co.kr.app.bangbanggokgok.server.AllListModel;


public class AllListDetailActivity extends Activity {
    // 이미지 다운로드
    protected ImageLoader mImageLoader;
    protected DisplayImageOptions mOption;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alllistdetail);
        initImgLoader();

        makeLayout();

	}

    private void initImgLoader() {

        mImageLoader = ImageLoader.getInstance();

        mOption = new DisplayImageOptions.Builder()
                .showImageForEmptyUri(com.pluslibrary.R.drawable.empty_photo)
                .showImageOnFail(com.pluslibrary.R.drawable.empty_photo).cacheInMemory(true)
                .cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565).build();
    }

    private void makeLayout() {
        Intent i = getIntent();
        AllListModel data = (AllListModel) i.getSerializableExtra("data");


        ImageView mainImg = (ImageView) findViewById(R.id.main_img);
        mImageLoader.displayImage(
                BBGGConstants.IMG_URL_HEAD + data.getImg01(), mainImg,
                mOption);




        TextView titleView = (TextView) findViewById(R.id.title_txt);
        titleView.setText(data.getSubject());

        TextView contentView = (TextView) findViewById(R.id.name_txt);
        contentView.setText(data.getContent());

        TextView addressView = (TextView) findViewById(R.id.area_txt);
        addressView.setText(data.getAddress());

        TextView priceView = (TextView) findViewById(R.id.body_depositsum);
        priceView.setText(data.getPrice01());

        TextView roomTypeView = (TextView) findViewById(R.id.body_room);
        roomTypeView.setText(data.getRoomType());

        TextView roomSizeView = (TextView) findViewById(R.id.body_roomsize);
        roomSizeView.setText(data.getSize());

        TextView floorView = (TextView) findViewById(R.id.body_floor);
        floorView.setText(data.getFloor());

        TextView managementFeeView = (TextView) findViewById(R.id.body_cost);
        managementFeeView.setText(data.getManagementPrice());

        TextView moveDateView = (TextView) findViewById(R.id.body_day);
        moveDateView.setText(data.getMoveDate());

        TextView parkView = (TextView) findViewById(R.id.body_park);
        parkView.setText(data.getParking());

        TextView petView = (TextView) findViewById(R.id.body_pet);
        petView.setText(data.getPet());

        TextView heatTypeView = (TextView) findViewById(R.id.body_heat);
        heatTypeView.setText(data.getHeatType());

        TextView detailView = (TextView) findViewById(R.id.body_add);
        detailView.setText(data.getMemo());

        TextView addressView2 = (TextView) findViewById(R.id.body_body);
        addressView2.setText(data.getAddress());











    }

}