package co.kr.app.bangbanggokgok.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.Button;
import co.kr.app.bangbanggokgok.MyApplication;

public class H5Button extends Button {

	public H5Button(Context context) {

		super(context);
		init();

	}

	public H5Button(Context context, AttributeSet attrs) {

		super(context, attrs);
		init();

	}

	public H5Button(Context context, AttributeSet attrs, int defStyle) {

		super(context, attrs, defStyle);
		init();

	}

	public void init() {
		this.setGravity(Gravity.CENTER);
		setTypeface(MyApplication.getAppFont());
	}

}
