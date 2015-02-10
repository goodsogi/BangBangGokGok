package co.kr.app.bangbanggokgok.server;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by johnny on 15. 2. 5.
 */
public class AllListModel implements Serializable {
    private String idx;
    private String gubun;
    private String img01;
    private String img02;
    private String img03;
    private String img04;
    private String img05;
    private String img06;
    private String img07;
    private String img08;
    private String img09;
    private String img10;
    private String img11;
    private String img12;
    private String address;
    private String subject;
    private String content;
    private String phone;
    private String registerId;
    private String registerDate;
    private String roomType;
    private String payType;
    private String price01;
    private String price11;
    private String price02;
    private String price21;
    private String price03;
    private String price31;
    private String floor;
    private String size;
    private String options;
    private String moveDate;
    private String heatType;
    private String managementPrice;
    private String managementPriceOptions;
    private String parking;
    private String pet;
    private String lat;
    private String lng;
    private String memo;
    private String distance;
    private int mData;


    public void setAddress(String address) {
        this.address = address;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public void setGubun(String gubun) {
        this.gubun = gubun;
    }

    public void setHeatType(String heatType) {
        this.heatType = heatType;
    }

    public void setIdx(String idx) {
        this.idx = idx;
    }

    public void setImg01(String img01) {
        this.img01 = img01;
    }

    public void setImg02(String img02) {
        this.img02 = img02;
    }

    public void setImg03(String img03) {
        this.img03 = img03;
    }

    public void setImg04(String img04) {
        this.img04 = img04;
    }

    public void setImg05(String img05) {
        this.img05 = img05;
    }

    public void setImg06(String img06) {
        this.img06 = img06;
    }

    public void setImg07(String img07) {
        this.img07 = img07;
    }

    public void setImg08(String img08) {
        this.img08 = img08;
    }

    public void setImg09(String img09) {
        this.img09 = img09;
    }

    public void setImg10(String img10) {
        this.img10 = img10;
    }

    public void setImg11(String img11) {
        this.img11 = img11;
    }

    public void setImg12(String img12) {
        this.img12 = img12;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public void setManagementPrice(String managementPrice) {
        this.managementPrice = managementPrice;
    }

    public void setManagementPriceOptions(String managementPriceOptions) {
        this.managementPriceOptions = managementPriceOptions;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public void setMoveDate(String moveDate) {
        this.moveDate = moveDate;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPrice01(String price01) {
        this.price01 = price01;
    }

    public void setPrice02(String price02) {
        this.price02 = price02;
    }

    public void setPrice03(String price03) {
        this.price03 = price03;
    }

    public void setPrice11(String price11) {
        this.price11 = price11;
    }

    public void setPrice21(String price21) {
        this.price21 = price21;
    }

    public void setPrice31(String price31) {
        this.price31 = price31;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public String getIdx() {
        return idx;
    }

    public String getGubun() {
        return gubun;
    }

    public String getImg01() {
        return img01;
    }

    public String getImg02() {
        return img02;
    }

    public String getImg03() {
        return img03;
    }

    public String getImg04() {
        return img04;
    }

    public String getImg05() {
        return img05;
    }

    public String getImg06() {
        return img06;
    }

    public String getImg07() {
        return img07;
    }

    public String getImg08() {
        return img08;
    }

    public String getImg09() {
        return img09;
    }

    public String getImg10() {
        return img10;
    }

    public String getImg11() {
        return img11;
    }

    public String getImg12() {
        return img12;
    }

    public String getAddress() {
        return address;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public String getPhone() {
        return phone;
    }

    public String getDistance() {
        return distance;
    }

    public String getFloor() {
        return floor;
    }

    public String getHeatType() {
        return heatType;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    public String getManagementPrice() {
        return managementPrice;
    }

    public String getManagementPriceOptions() {
        return managementPriceOptions;
    }

    public String getMemo() {
        return memo;
    }

    public String getMoveDate() {
        return moveDate;
    }

    public String getOptions() {
        return options;
    }

    public String getParking() {
        return parking;
    }

    public String getPayType() {
        return payType;
    }

    public String getPet() {
        return pet;
    }

    public String getPrice01() {
        return price01;
    }

    public String getPrice02() {
        return price02;
    }

    public String getPrice03() {
        return price03;
    }

    public String getPrice11() {
        return price11;
    }

    public String getPrice21() {
        return price21;
    }

    public String getPrice31() {
        return price31;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public String getRegisterId() {
        return registerId;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getSize() {
        return size;
    }


//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel out, int flags) {
//        out.writeInt(mData);
//    }
//    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
//    public static final Parcelable.Creator<AllListModel> CREATOR = new Parcelable.Creator<AllListModel>() {
//        public AllListModel createFromParcel(Parcel in) {
//            return new AllListModel(in);
//        }
//
//        public AllListModel[] newArray(int size) {
//            return new AllListModel[size];
//        }
//    };
//
//    // example constructor that takes a Parcel and gives you an object populated with it's values
//    private AllListModel(Parcel in) {
//        mData = in.readInt();
//    }
//
//    public AllListModel() {};

}
