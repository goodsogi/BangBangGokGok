package co.kr.app.bangbanggokgok.gcm;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.util.Log;


import com.google.android.gms.gcm.GoogleCloudMessaging;

import co.kr.app.bangbanggokgok.BBGGConstants;
import co.kr.app.bangbanggokgok.GcmBroadcastReceiver;
import co.kr.app.bangbanggokgok.R;

/**
 * 푸시 받은 메시지 처리
 * 
 * @author jeff
 * 
 */
public class GcmIntentService extends IntentService {

	private static final String TAG = GcmIntentService.class.getSimpleName();

	public static final String PROJECT_ID = "268246742383";// 이전 버전과 달리 project
															// id로 생성자를 만들 필요 없음

	private static final int NOTIFICATION_ID = 11;

	private boolean mSoundEnabled;

	private boolean mVibrationEnabled;

	private Vibrator mVibrator;

	private MediaPlayer mMediaPlayer;

	public GcmIntentService() {
		super(TAG);

	}

	@Override
	protected void onHandleIntent(Intent intent) {
		// 생성자에서는 getApplicationContext()가 null pointer 오류 발생
		SharedPreferences sharedPreference = getApplicationContext()
				.getSharedPreferences(BBGGConstants.PREF_NAME,
						Context.MODE_PRIVATE);
		// 푸시를 사용하지 않는다고 설정되어 있는 경우
		if (!sharedPreference.getBoolean(BBGGConstants.KEY_PUSH_ENABLE, true))
			return;
		mSoundEnabled = sharedPreference.getBoolean(
                BBGGConstants.KEY_GCM_SOUND_ENABLED, true);
		mVibrationEnabled = sharedPreference.getBoolean(
                BBGGConstants.KEY_GCM_VIBRATION_ENABLED, true);
		mVibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		mMediaPlayer = MediaPlayer.create(getApplicationContext(),
				R.raw.push_sound);

		Bundle extras = intent.getExtras();
		GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);

		// The getMessageType() intent parameter must be the intent you received
		// in your BroadcastReceiver.
		String messageType = gcm.getMessageType(intent);

		if (!extras.isEmpty()) {
			/*
			 * Filter messages based on message type. Since it is likely that
			 * GCM will be extended in the future with new message types, just
			 * ignore any message types you're not interested in, or that you
			 * don't recognize.
			 */
			if (GoogleCloudMessaging.MESSAGE_TYPE_SEND_ERROR
					.equals(messageType)) {
				Log.w(BBGGConstants.LOG_TAG,
						"Send error: " + extras.toString());
			} else if (GoogleCloudMessaging.MESSAGE_TYPE_DELETED
					.equals(messageType)) {
				Log.w(BBGGConstants.LOG_TAG, "Deleted messages on server: "
						+ extras.toString());
				// If it's a regular GCM message, do some work.
			} else if (GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE
					.equals(messageType)) {

				// 푸시로 받은 쿠폰 인덱스 처리
				String couponIdx = extras.get("couponIdx").toString();
				launchBeaconPopup(couponIdx);
				// showNotification(getApplicationContext(), encodedTitle);
			}
		}

		// Release the wake lock provided by the WakefulBroadcastReceiver.
		GcmBroadcastReceiver.completeWakefulIntent(intent);
	}

	/**
	 * 비콘 팝업 띄움
	 * 
	 * @param uuid
	 */
	private void launchBeaconPopup(String couponIdx) {
//		Intent intent = new Intent(getApplicationContext(),
//				BeaconDialogActivity.class);
//		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//		intent.putExtra(CommonConstants.KEY_COUPON_IDX, couponIdx);
//		getApplicationContext().startActivity(intent);

	}

	/**
	 * 폰 상단에 푸시 메시지 표시
	 * 
	 * @param context
	 * @param messageapp_icon
	 */
	private void showNotification(Context context, String message) {
//		// 인텐트 수정 필요!!
//		Intent notificationIntent = new Intent(context, MainActivity.class);
//		PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
//				notificationIntent, 0);
//
//		NotificationManager nm = (NotificationManager) context
//				.getSystemService(Context.NOTIFICATION_SERVICE);
//
//		NotificationCompat.Builder builder = new NotificationCompat.Builder(
//				this).setSmallIcon(R.drawable.ic_launcher)
//				.setContentTitle(context.getString(R.string.app_name))
//				.setContentText(message).setContentIntent(contentIntent);
//		Notification n = builder.build();
//
//		// 알림 소리와 진동 처리
//		playSoundVibration();
//
//		nm.notify(NOTIFICATION_ID, n);

	}

	/**
	 * 푸시 수신시 알림음이나 진동
	 */
	private void playSoundVibration() {
		// 진동
		if (mVibrationEnabled) {
			mVibrator.vibrate(new long[] { 200, 200, 200, 200 }, -1);
		}

		// 소리
		if (mSoundEnabled) {
			mMediaPlayer.start();
		}

	}

}
