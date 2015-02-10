package co.kr.app.bangbanggokgok.common;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import co.kr.app.bangbanggokgok.MyApplication;

public class H5TextView extends TextView {

	public H5TextView(Context context) {

		super(context);
		init();

	}

	public H5TextView(Context context, AttributeSet attrs) {

		super(context, attrs);
		init();

	}

	public H5TextView(Context context, AttributeSet attrs, int defStyle) {

		super(context, attrs, defStyle);
		init();

	}

	public void init() {

		setTypeface(MyApplication.getAppFont());

	}

}
