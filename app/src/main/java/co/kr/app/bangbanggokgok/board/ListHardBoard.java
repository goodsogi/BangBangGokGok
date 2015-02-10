package co.kr.app.bangbanggokgok.board;

import android.os.Parcel;
import android.os.Parcelable;



public class ListHardBoard implements Parcelable{

	private String img , header_up , header_text , text;
	
	private String deposit , area , one_report , main_img, option_01, option_02, option_03, option_04, option_05;

	
	
	public ListHardBoard() {
    }
	public ListHardBoard(Parcel in) {
	       readFromParcel(in);
	    }
	public ListHardBoard(String img, String header_up, String header_text, String text,
			String deposit, String area, String one_report, String main_img,
			String option_01, String option_02, String option_03, String option_04,
			String option_05) {
		this.img = img;
		this.header_up = header_up;
		this.header_text = header_text;
		this.text = text;

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
	public String getimg() {
		return img;
	}
	public String getheader_up() {
		return header_up;
	}
	public String getheader_text() {
		return header_text;
	}
	public String gettext() {
		return text;
	}
	
	
	public String getDeposit() {
		return deposit;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getOne_report() {
		return one_report;
	}
	public void setOne_report(String one_report) {
		this.one_report = one_report;
	}
	public String getMain_img() {
		return main_img;
	}
	public void setMain_img(String main_img) {
		this.main_img = main_img;
	}
	public String getOption_01() {
		return option_01;
	}
	public void setOption_01(String option_01) {
		this.option_01 = option_01;
	}
	public String getOption_02() {
		return option_02;
	}
	public void setOption_02(String option_02) {
		this.option_02 = option_02;
	}
	public String getOption_03() {
		return option_03;
	}
	public void setOption_03(String option_03) {
		this.option_03 = option_03;
	}
	public String getOption_04() {
		return option_04;
	}
	public void setOption_04(String option_04) {
		this.option_04 = option_04;
	}
	public String getOption_05() {
		return option_05;
	}
	public void setOption_05(String option_05) {
		this.option_05 = option_05;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		
		dest.writeString(img);
		dest.writeString(header_up);
		dest.writeString(header_text);
		dest.writeString(text);
		

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
		img = in.readString();
		header_up = in.readString();
		header_text = in.readString();
		text = in.readString();
		
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
	public static final Parcelable.Creator<ListHardBoard> CREATOR = new Parcelable.Creator() {
		public Object createFromParcel(Parcel in) {
			return new ListHardBoard(in);
		}

		public Object[] newArray(int size) {
			return new ListHardBoard[size];
		}
	};

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
}