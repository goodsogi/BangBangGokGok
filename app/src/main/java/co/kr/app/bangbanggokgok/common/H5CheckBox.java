package co.kr.app.bangbanggokgok.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import co.kr.app.bangbanggokgok.R;

/**
 * @author hello5
 * @Desc : 체크박스 버튼
 */
public class H5CheckBox extends ImageView implements OnClickListener {

	public H5CheckBox(Context context, AttributeSet attrs) {
		super(context, attrs);
		initViews();

	}

	public void initViews() {

		setBackgroundResource(R.drawable.cb_bg);
		setImageResource(R.drawable.btn_checkbox);
		setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		setSelected(!isSelected());
	}

}
