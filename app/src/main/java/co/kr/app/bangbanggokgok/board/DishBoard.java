package co.kr.app.bangbanggokgok.board;

import android.os.Parcel;
import android.os.Parcelable;



public class DishBoard implements Parcelable{

	private String deposit , area , one_report , main_img, option_01, option_02, option_03, option_04, option_05;
	public DishBoard() {
    }
	public DishBoard(Parcel in) {
	       readFromParcel(in);
	    }
	public DishBoard(String deposit, String area, String one_report , String main_img , String option_01 ,
			String option_02 , String option_03 , String option_04 , String option_05  ) {
		this.deposit = deposit;
		this.area = area;
		this.one_report = one_report;
		this.main_img = main_img;
		this.option_01 = option_01;
		this.option_02 = option_02;
		this.option_03 = option_03;
		this.option_04 = option_04;
		this.option_05 = option_05;

	}
	public String getDeposit() {
		return deposit;
	}
	public String getArea() {
		return area;
	}
	public String getOne_report() {
		return one_report;
	}
	public String getMain_img() {
		return main_img;
	}
	public String getOption_01() {
		return option_01;
	}
	public String getOption_02() {
		return option_02;
	}
	public String getOption_03() {
		return option_03;
	}
	public String getOption_04() {
		return option_04;
	}
	public String getOption_05() {
		return option_05;
	}
	
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		
		dest.writeString(deposit);
		dest.writeString(area);
		dest.writeString(one_report);
		dest.writeString(main_img);
		dest.writeString(option_01);
		dest.writeString(option_02);
		dest.writeString(option_03);
		dest.writeString(option_04);
		dest.writeString(option_05);

	}
	private void readFromParcel(Parcel in){
		deposit = in.readString();
		area = in.readString();
		one_report = in.readString();
		main_img = in.readString();
		option_01 = in.readString();
		option_02 = in.readString();
		option_03 = in.readString();
		option_04 = in.readString();
		option_05 = in.readString();

	}

	@SuppressWarnings("rawtypes")
	public static final Parcelable.Creator<MyBoard> CREATOR = new Parcelable.Creator() {
		public Object createFromParcel(Parcel in) {
			return new MyBoard(in);
		}

		public Object[] newArray(int size) {
			return new MyBoard[size];
		}
	};

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
}