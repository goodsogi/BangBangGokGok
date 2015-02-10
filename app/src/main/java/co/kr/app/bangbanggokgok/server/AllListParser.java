package co.kr.app.bangbanggokgok.server;

import android.util.Log;

import com.pluslibrary.PlusConstants;
import com.pluslibrary.server.PlusXmlParser;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * 목적지 파서
 *
 * @author jeff
 */
public class AllListParser extends PlusXmlParser {

    public ArrayList<AllListModel> doIt(InputStream in) {

        ArrayList<AllListModel> datas = new ArrayList<AllListModel>();

        try {

            // XmlPullParser xml데이터를 저장
            mXpp.setInput(in, PlusConstants.SERVER_ENCODING_TYPE);

            // 이벤트 저장할 변수선언
            int eventType = mXpp.getEventType();

            boolean isItemTag = false; // <item> .영역에 인지 여부 체크
            String tagName = "";
            String idx = "";
            String gubun = "";
            String img01 = "";
            String img02 = "";
            String img03 = "";
            String img04 = "";
            String img05 = "";
            String img06 = "";
            String img07 = "";
            String img08 = "";
            String img09 = "";
            String img10 = "";
            String img11 = "";
            String img12 = "";
            String address = "";
            String subject = "";
            String content = "";
            String phone = "";
            String registerId = "";
            String registerDate = "";
            String roomType = "";
            String payType = "";
            String price01 = "";
            String price11 = "";
            String price02 = "";
            String price21 = "";
            String price03 = "";
            String price31 = "";
            String floor = "";
            String size = "";
            String options = "";
            String moveDate = "";
            String heatType = "";
            String managementPrice = "";
            String managementPriceOptions = "";
            String parking = "";
            String pet = "";
            String lat = "";
            String lng = "";
            String memo = "";
            String distance = "";


            // xml의 데이터의 끝까지 돌면서 원하는 데이터를 얻어옴
            while (eventType != XmlPullParser.END_DOCUMENT) {

                if (eventType == XmlPullParser.START_TAG) { // 시작 태그를 만났을때.
                    // 태그명을 저장
                    tagName = mXpp.getName();
                    if (tagName.equals("ROW"))
                        isItemTag = true;

                } else if (eventType == XmlPullParser.TEXT) { // 내용
                    if (isItemTag && tagName.equals("idx") && idx.equals(""))
                        idx = mXpp.getText();
                    if (isItemTag && tagName.equals("gubun")
                            && gubun.equals(""))
                        gubun = mXpp.getText();
                    if (isItemTag && tagName.equals("img1") && img01.equals(""))
                        img01 = mXpp.getText();
                    if (isItemTag && tagName.equals("img2") && img02.equals(""))
                        img02 = mXpp.getText();
                    if (isItemTag && tagName.equals("img3") && img03.equals(""))
                        img03 = mXpp.getText();
                    if (isItemTag && tagName.equals("img4") && img04.equals(""))
                        img04 = mXpp.getText();
                    if (isItemTag && tagName.equals("img5") && img05.equals(""))
                        img05 = mXpp.getText();
                    if (isItemTag && tagName.equals("img6") && img06.equals(""))
                        img06 = mXpp.getText();
                    if (isItemTag && tagName.equals("img7") && img07.equals(""))
                        img07 = mXpp.getText();
                    if (isItemTag && tagName.equals("img8") && img08.equals(""))
                        img08 = mXpp.getText();
                    if (isItemTag && tagName.equals("img9") && img09.equals(""))
                        img09 = mXpp.getText();
                    if (isItemTag && tagName.equals("img10") && img10.equals(""))
                        img10 = mXpp.getText();
                    if (isItemTag && tagName.equals("img11") && img11.equals(""))
                        img11 = mXpp.getText();
                    if (isItemTag && tagName.equals("img12") && img12.equals(""))
                        img12 = mXpp.getText();

                    if (isItemTag && tagName.equals("address") && address.equals(""))
                        address = mXpp.getText();
                    if (isItemTag && tagName.equals("subject") && subject.equals(""))
                        subject = mXpp.getText();
                    if (isItemTag && tagName.equals("content") && content.equals(""))
                        content = mXpp.getText();
                    if (isItemTag && tagName.equals("hphone") && phone.equals(""))
                        phone = mXpp.getText();
                    if (isItemTag && tagName.equals("memid") && registerId.equals(""))
                        registerId = mXpp.getText();
                    if (isItemTag && tagName.equals("wdate") && registerDate.equals(""))
                        registerDate = mXpp.getText();
                    if (isItemTag && tagName.equals("wr_kind") && roomType.equals(""))
                        roomType = mXpp.getText();
                    if (isItemTag && tagName.equals("wr_cate") && payType.equals(""))
                        payType = mXpp.getText();
                    if (isItemTag && tagName.equals("wr_price1") && price01.equals(""))
                        price01 = mXpp.getText();
                    if (isItemTag && tagName.equals("wr_price1_1") && price11.equals(""))
                        price11 = mXpp.getText();
                    if (isItemTag && tagName.equals("wr_price2") && price02.equals(""))
                        price02 = mXpp.getText();
                    if (isItemTag && tagName.equals("wr_price2_1") && price21.equals(""))
                        price21 = mXpp.getText();
                    if (isItemTag && tagName.equals("wr_price3") && price03.equals(""))
                        price03 = mXpp.getText();
                    if (isItemTag && tagName.equals("wr_price3_1") && price31.equals(""))
                        price31 = mXpp.getText();
                    if (isItemTag && tagName.equals("wr_floor") && floor.equals(""))
                        floor = mXpp.getText();

                    if (isItemTag && tagName.equals("wr_size") && size.equals(""))
                        size = mXpp.getText();
                    if (isItemTag && tagName.equals("wr_option") && options.equals(""))
                        options = mXpp.getText();
                    if (isItemTag && tagName.equals("wr_movedate") && moveDate.equals(""))
                        moveDate = mXpp.getText();
                    if (isItemTag && tagName.equals("wr_heat_kind") && heatType.equals(""))
                        heatType = mXpp.getText();
                    if (isItemTag && tagName.equals("wr_m_price") && managementPrice.equals(""))
                        managementPrice = mXpp.getText();
                    if (isItemTag && tagName.equals("wr_m_price_option") && managementPriceOptions.equals(""))
                        managementPriceOptions = mXpp.getText();
                    if (isItemTag && tagName.equals("wr_parking") && parking.equals(""))
                        parking = mXpp.getText();
                    if (isItemTag && tagName.equals("wr_ani") && pet.equals(""))
                        pet = mXpp.getText();
                    if (isItemTag && tagName.equals("wr_lng") && lng.equals(""))
                        lng = mXpp.getText();
                    if (isItemTag && tagName.equals("wr_lat") && lat.equals(""))
                        lat = mXpp.getText();
                    if (isItemTag && tagName.equals("wr_memo") && memo.equals(""))
                        memo = mXpp.getText();
                    if (isItemTag && tagName.equals("dist") && distance.equals(""))
                        distance = mXpp.getText();


                } else if (eventType == XmlPullParser.END_TAG) { // 닫는 태그를 만났을때
                    // 태그명을 저장
                    tagName = mXpp.getName();

                    if (tagName.equals("ROW")) {

                        AllListModel data = new AllListModel();

                        data.setIdx(idx);
                        data.setGubun(gubun);
                        data.setImg01(img01);
                        data.setImg02(img02);
                        data.setImg03(img03);
                        data.setImg04(img04);
                        data.setImg05(img05);
                        data.setImg06(img06);
                        data.setImg07(img07);
                        data.setImg08(img08);
                        data.setImg09(img09);
                        data.setImg10(img10);
                        data.setImg11(img11);
                        data.setImg12(img12);
                        data.setAddress(address);
                        data.setSubject(subject);
                        data.setContent(content);
                        data.setPhone(phone);
                        data.setRegisterId(registerId);
                        data.setRegisterDate(registerDate);
                        data.setRoomType(roomType);
                        data.setPrice01(price01);
                        data.setPrice02(price02);
                        data.setPrice03(price03);
                        data.setPrice11(price11);
                        data.setPrice21(price21);
                        data.setPrice31(price31);
                        data.setFloor(floor);
                        data.setSize(size);
                        data.setOptions(options);
                        data.setMoveDate(moveDate);
                        data.setHeatType(heatType);
                        data.setManagementPrice(managementPrice);
                        data.setManagementPriceOptions(managementPriceOptions);
                        data.setParking(parking);
                        data.setPet(pet);
                        data.setLng(lng);
                        data.setLat(lat);
                        data.setMemo(memo);
                        data.setDistance(distance);
                        datas.add(data);

                        isItemTag = false; // 초기화
                        tagName = "";
                        idx = "";
                        gubun = "";
                        img01 = "";
                        img02 = "";
                        img03 = "";
                        img04 = "";
                        img05 = "";
                        img06 = "";
                        img07 = "";
                        img08 = "";
                        img09 = "";
                        img10 = "";
                        img11 = "";
                        img12 = "";
                        address = "";
                        subject = "";
                        content = "";
                        phone = "";
                        registerId = "";
                        registerDate = "";
                        roomType = "";
                        payType = "";
                        price01 = "";
                        price11 = "";
                        price02 = "";
                        price21 = "";
                        price03 = "";
                        price31 = "";
                        floor = "";
                        size = "";
                        options = "";
                        moveDate = "";
                        heatType = "";
                        managementPrice = "";
                        managementPriceOptions = "";
                        parking = "";
                        pet = "";
                        lat = "";
                        lng = "";
                        memo = "";
                        distance = "";

                    }

                }

                eventType = mXpp.next(); // 다음 이벤트 타입
            }

        } catch (Exception e) {
            Log.d(PlusConstants.LOG_TAG, e.getMessage());
            datas = null;

        }

        return datas;
    }
}