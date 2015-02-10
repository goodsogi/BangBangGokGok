package co.kr.app.bangbanggokgok.common;

import android.content.Context;
import android.widget.Toast;

public class H5Toast {

	private static H5Toast	instance;

	private Context			context;
	private Toast				toast;

	private H5Toast(Context context) {

		this.context = context;
	}

	public static H5Toast getInstance(Context context) {

		if (instance == null)
			instance = new H5Toast(context);
		return instance;
	}

	public void show() {

		this.show(new Throwable().getStackTrace()[1].getClassName() + "[Line = " + new Throwable().getStackTrace()[1].getLineNumber() + "]");
	}

	public void show(String content) {

		if (toast == null)
			toast = Toast.makeText(context, content, Toast.LENGTH_SHORT);
		else
			toast.setText(content);

		toast.show();
	}

	public void show(int resourceID) {

		try {
			if (toast == null)
				toast = Toast.makeText(context, context.getString(resourceID), Toast.LENGTH_SHORT);
			else
				toast.setText(context.getString(resourceID));
		} catch (Exception e) {
			// resource id error
		}

		toast.show();
	}

	public void cancel() {

		toast.cancel();
	}

}