package co.kr.app.bangbanggokgok.board;

import android.os.Parcel;
import android.os.Parcelable;



public class SubwayBoard implements Parcelable{

	private String location , staion;
	public SubwayBoard() {
    }
	public SubwayBoard(Parcel in) {
	       readFromParcel(in);
	    }
	public SubwayBoard(String location, String staion) {
		this.location = location;
		this.staion = staion;

	}
	public String getlocation() {
		return location;
	}
	public String getstaion() {
		return staion;
	}
	
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		
		dest.writeString(location);
		dest.writeString(staion);

	}
	private void readFromParcel(Parcel in){
		location = in.readString();
		staion = in.readString();

	}

	@SuppressWarnings("rawtypes")
	public static final Parcelable.Creator<SubwayBoard> CREATOR = new Parcelable.Creator() {
		public Object createFromParcel(Parcel in) {
			return new SubwayBoard(in);
		}

		public Object[] newArray(int size) {
			return new SubwayBoard[size];
		}
	};

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
}