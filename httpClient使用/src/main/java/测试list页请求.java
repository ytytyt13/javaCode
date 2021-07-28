/**
 * @author yang
 * 2021年06月18日 17:51:00
 */
public class 测试list页请求 {

    public static void main(String[] args) {

        //三亚
        String url = "http://l-vacation22.vc.dev.cn0.qunar.com:8092/api/routeList/adaptors/mobileTop?gid=C86F381D-2475-EB22-F8E6-9112DF37A79B&fl=is_ctrip_b%2CfreeTripCombineCard%2CfunctionDisplay%2CextendFunction%2Cdep%2CrouteType%2CtwoLeveltype%2CserviceType%2CguideGender%2Clanguage%2Csummary%2Ccountries%2Ctitle%2Cthumb%2CtaocanPrice%2Cprice%2CencodeId%2Cid%2CrouteId%2Cwrpparid%2CdisplayAdStyle%2CsortTag%2CsalesGrade%2CproductScore%2CsoldCount%2CsoldCount7%2CsoldThreshold%2CbookingTwoDayTimeDiff%2CfreeDay%2CflightSelect%2CcoreFlightCompanies%2CisTts%2ChotelSelect%2ChotelInfo%2CtagInfos%2Cis_vpas%2CmainTrafficDeparture%2CsecondaryTrafficType%2Carrive%2CboutiqueSmallGroup%2CpriceDate%2Creviews%2ChotelLevelText%2CtradingArea%2CtradingAreaDesc%2CbookableToday%2CbookableTomorrow%2CisBqHis%2CtuId%2Ccitys%2CbackDate%2Csourceurl%2CisPinTuan%2CadvanceBooking%2CmobFunction%2CmarketTag%2CcoreArriveTag%2Cbrightspots%2CtotalPrice%2CotherTagInfos%2CnoExtraPayment%2CnoShopping%2CextensionImg%2CsightspotsNormalPoint%2CticketPoiLevel%2CticketPoiBelongCounty%2CticketPoiFatherPrice%2CjumpInfo%2CticketPoiFatherName%2CdistancePoi%2CaccuratePrice%2CproductSource%2CproductFeatureTags%2CproductCarPackageCount%2CproductCarNumber%2CtopType%2ClongPlanId%2CsupplierId%2Cimgs%2ChasVideo%2CuserScenicSpotDistance%2CuserHotelDistance%2ChotelScenicSpotDistance%2CreasonsForInclusion%2CforSale%2CvideoPreviewUrl%2Creserved%2CrandomImgUrl%2CitineraryDayFlexible%2CtravelDays%2CvalidBatchIds%2Cwrpparid%2Csourceurl%2CserviceType%2Ctype%2CvisaTypeId%2Csummary%2CtwoLeveltype%2CpriceDate%2CteamTypeId%2CteamType%2Ctotraffic%2Cbacktraffic%2CflightType%2CitineraryDay%2Cdetails%2CsoldCount90%2CproductRate%2CdetailUrlOuterTag%2CdetailBaseUrl%2CticketOnedayProduct%2CproductTheme%2CthemeType%2CreasonsForInclusion%2CforSale%2CvideoPreviewUrl%2CunionCouponIds%2Creserved%2CrandomImgUrl%2CitineraryDayFlexible%2ChotSpringWeekendBookable&mbfTabConfig=true&aroundWeight=1&allowOneDay=false&displayStatus=dijie_flight+dijie_jijiajiu_flight+ctrip_group+dijie_jijiajiu_train+mobile&tuId=true&filterTagPlatform=mobile_app&type=all&branch=Ios_newa&dep=%E5%8C%97%E4%BA%AC&platform=Ios&ecp=-currency%3AUSD&limit=0%2C10&originalquery=%E4%B8%89%E4%BA%9A&model=iPhone+XS+Max&height=300&query=%E4%B8%89%E4%BA%9A&orderby=mobile-desc&qssrc=eyJhY3QiOiJzZWFyY2giLCJzcmMiOiJJb3Mvbm9ybWFsLzgwMDExMjQ4IiwidHMiOjE2MTUyNzM3MjI0NTJ9&modules=list%2CbookingInfo%2CactivityDetail&pts=f4f7c517-cc8f-40da-a7ed-6b25225ad687&quality=90&ecpm=true&width=480&debug=true";



        //华东
        String url2 = "http://l-vacation22.vc.dev.cn0.qunar.com:8092/api/routeList/adaptors/mobileTop?gid=C86F381D-2475-EB22-F8E6-9112DF37A79B&fl=is_ctrip_b%2CfreeTripCombineCard%2CfunctionDisplay%2CextendFunction%2Cdep%2CrouteType%2CtwoLeveltype%2CserviceType%2CguideGender%2Clanguage%2Csummary%2Ccountries%2Ctitle%2Cthumb%2CtaocanPrice%2Cprice%2CencodeId%2Cid%2CrouteId%2Cwrpparid%2CdisplayAdStyle%2CsortTag%2CsalesGrade%2CproductScore%2CsoldCount%2CsoldCount7%2CsoldThreshold%2CbookingTwoDayTimeDiff%2CfreeDay%2CflightSelect%2CcoreFlightCompanies%2CisTts%2ChotelSelect%2ChotelInfo%2CtagInfos%2Cis_vpas%2CmainTrafficDeparture%2CsecondaryTrafficType%2Carrive%2CboutiqueSmallGroup%2CpriceDate%2Creviews%2ChotelLevelText%2CtradingArea%2CtradingAreaDesc%2CbookableToday%2CbookableTomorrow%2CisBqHis%2CtuId%2Ccitys%2CbackDate%2Csourceurl%2CisPinTuan%2CadvanceBooking%2CmobFunction%2CmarketTag%2CcoreArriveTag%2Cbrightspots%2CtotalPrice%2CotherTagInfos%2CnoExtraPayment%2CnoShopping%2CextensionImg%2CsightspotsNormalPoint%2CticketPoiLevel%2CticketPoiBelongCounty%2CticketPoiFatherPrice%2CjumpInfo%2CticketPoiFatherName%2CdistancePoi%2CaccuratePrice%2CproductSource%2CproductFeatureTags%2CproductCarPackageCount%2CproductCarNumber%2CtopType%2ClongPlanId%2CsupplierId%2Cimgs%2ChasVideo%2CuserScenicSpotDistance%2CuserHotelDistance%2ChotelScenicSpotDistance%2CreasonsForInclusion%2CforSale%2CvideoPreviewUrl%2Creserved%2CrandomImgUrl%2CitineraryDayFlexible%2CtravelDays%2CvalidBatchIds%2Cwrpparid%2Csourceurl%2CserviceType%2Ctype%2CvisaTypeId%2Csummary%2CtwoLeveltype%2CpriceDate%2CteamTypeId%2CteamType%2Ctotraffic%2Cbacktraffic%2CflightType%2CitineraryDay%2Cdetails%2CsoldCount90%2CproductRate%2CdetailUrlOuterTag%2CdetailBaseUrl%2CticketOnedayProduct%2CproductTheme%2CthemeType%2CreasonsForInclusion%2CforSale%2CvideoPreviewUrl%2CunionCouponIds%2Creserved%2CrandomImgUrl%2CitineraryDayFlexible%2ChotSpringWeekendBookable&mbfTabConfig=true&aroundWeight=1&allowOneDay=false&displayStatus=dijie_flight+dijie_jijiajiu_flight+ctrip_group+dijie_jijiajiu_train+mobile&tuId=true&filterTagPlatform=mobile_app&type=all&branch=Ios_newa&dep=%E5%8C%97%E4%BA%AC&platform=Ios&ecp=-currency%3AUSD&limit=0%2C10&originalquery=%E5%8D%8E%E4%B8%9C&model=iPhone+XS+Max&height=300&query=%E5%8D%8E%E4%B8%9C&orderby=mobile-desc&qssrc=eyJhY3QiOiJzZWFyY2giLCJzcmMiOiJJb3Mvbm9ybWFsLzgwMDExMjQ4IiwidHMiOjE2MTUyNzM3MjI0NTJ9&modules=list%2CbookingInfo%2CactivityDetail&pts=f4f7c517-cc8f-40da-a7ed-6b25225ad687&quality=90&ecpm=true&width=480&debug=true";
        double sum = 0.0;
        int time = 10;
        for (int i = 0; i <time; i++) {
            long t1 = System.currentTimeMillis();
            String s = HttpClientUtil3.doGet(url2);
            long t2  = System.currentTimeMillis();

            sum+= (t2-t1);
            System.out.println("一次请求时间:"+ (t2 -t1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("平均请求时间:"+sum/time);
    }
}

// 675 230,236,219
// 789 385,410,389