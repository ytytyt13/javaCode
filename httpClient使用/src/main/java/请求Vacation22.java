import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author yang
 * 2021年04月14日 10:59:00
 */
public class 请求Vacation22 {
    public static void main(String[] args) throws IOException, ParseException {

        HashMap<String,Integer> map = new HashMap<>();
        map.put("http://192.168.242.110:9091/qsearch/vac_engine",0);
        map.put("http://192.168.242.109:9091/qsearch/vac_engine",0);
        map.put("http://10.90.7.231:9091/qsearch/vac_engine",0);
        map.put("http://192.168.242.114:9091/qsearch/vac_engine",0);
        map.put("http://192.168.242.111:9091/qsearch/vac_engine",0);
        map.put("http://10.90.5.163:9091/qsearch/vac_engine",0);
        map.put("http://10.90.7.101:9091/qsearch/vac_engine",0);

        map.put("http://192.168.232.53:8083/qsearch/vac_engine",0);



        String[] dep = {"北京","上海","成都","武汉"};
        String[] query = {"深圳","长沙","三亚","云南"};
        //String url ="http://l-vacation22.vc.dev.cn0:8092/api/routeList/adaptors/mobileTop?gid=C86F381D-2475-EB22-F8E6-9112DF37A79B&fl=freeTripCombineCard%2CfunctionDisplay%2CextendFunction%2Cdep%2CrouteType%2CtwoLeveltype%2CserviceType%2CguideGender%2Clanguage%2Csummary%2Ccountries%2Ctitle%2Cthumb%2CtaocanPrice%2Cprice%2CencodeId%2Cid%2CrouteId%2Cwrpparid%2CdisplayAdStyle%2CsortTag%2CsalesGrade%2CproductScore%2CsoldCount%2CsoldCount7%2CsoldThreshold%2CbookingTwoDayTimeDiff%2CfreeDay%2CflightSelect%2CcoreFlightCompanies%2CisTts%2ChotelSelect%2ChotelInfo%2CtagInfos%2Cis_vpas%2CmainTrafficDeparture%2CsecondaryTrafficType%2Carrive%2CboutiqueSmallGroup%2CpriceDate%2Creviews%2ChotelLevelText%2CtradingArea%2CtradingAreaDesc%2CbookableToday%2CbookableTomorrow%2CisBqHis%2CtuId%2Ccitys%2CbackDate%2Csourceurl%2CisPinTuan%2CadvanceBooking%2CmobFunction%2CmarketTag%2CcoreArriveTag%2Cbrightspots%2CtotalPrice%2CotherTagInfos%2CnoExtraPayment%2CnoShopping%2CextensionImg%2CsightspotsNormalPoint%2CticketPoiLevel%2CticketPoiBelongCounty%2CticketPoiFatherPrice%2CjumpInfo%2CticketPoiFatherName%2CdistancePoi%2CaccuratePrice%2CproductSource%2CproductFeatureTags%2CproductCarPackageCount%2CproductCarNumber%2CtopType%2ClongPlanId%2CsupplierId%2Cimgs%2ChasVideo%2CuserScenicSpotDistance%2CuserHotelDistance%2ChotelScenicSpotDistance%2CreasonsForInclusion%2CforSale%2CvideoPreviewUrl%2Creserved%2CrandomImgUrl%2CitineraryDayFlexible%2CtravelDays%2CvalidBatchIds%2Cwrpparid%2Csourceurl%2CserviceType%2Ctype%2CvisaTypeId%2Csummary%2CtwoLeveltype%2CpriceDate%2CteamTypeId%2CteamType%2Ctotraffic%2Cbacktraffic%2CflightType%2CitineraryDay%2Cdetails%2CsoldCount90%2CproductRate%2CdetailUrlOuterTag%2CdetailBaseUrl%2CticketOnedayProduct%2CproductTheme%2CthemeType%2CreasonsForInclusion%2CforSale%2CvideoPreviewUrl%2CunionCouponIds%2Creserved%2CrandomImgUrl%2CitineraryDayFlexible%2ChotSpringWeekendBookable&mbfTabConfig=true&aroundWeight=1&allowOneDay=false&displayStatus=dijie_flight+dijie_jijiajiu_flight+ctrip_group+dijie_train_local_package+mobile&tuId=true&filterTagPlatform=mobile_app&type=all&branch=Ios_newa&platform=Ios&ecp=-currency%3AUSD&height=300&orderby=mobile-desc&userName=aifcyyp8627&qssrc=eyJhY3QiOiJzZWFyY2giLCJzcmMiOiJJb3Mvbm9ybWFsLzgwMDExMjQ4IiwidHMiOjE2MTgzODAwNTg3MjZ9&userId=324365304&modules=list%2CbookingInfo%2CactivityDetail&pts=4ad81b22-04f9-49cd-a10a-cb539bc0f0ae&quality=90&userCashBatch=ytcs2%2Cytcs1%2Csxtestlong&bqType=local-increase&ecpm=true&width=480&debug=true";
        String url ="http://l-dujia.qunar.com/golfz/routeList/adaptors/mobileTop?gid=C86F381D-2475-EB22-F8E6-9112DF37A79B&fl=freeTripCombineCard%2CfunctionDisplay%2CextendFunction%2Cdep%2CrouteType%2CtwoLeveltype%2CserviceType%2CguideGender%2Clanguage%2Csummary%2Ccountries%2Ctitle%2Cthumb%2CtaocanPrice%2Cprice%2CencodeId%2Cid%2CrouteId%2Cwrpparid%2CdisplayAdStyle%2CsortTag%2CsalesGrade%2CproductScore%2CsoldCount%2CsoldCount7%2CsoldThreshold%2CbookingTwoDayTimeDiff%2CfreeDay%2CflightSelect%2CcoreFlightCompanies%2CisTts%2ChotelSelect%2ChotelInfo%2CtagInfos%2Cis_vpas%2CmainTrafficDeparture%2CsecondaryTrafficType%2Carrive%2CboutiqueSmallGroup%2CpriceDate%2Creviews%2ChotelLevelText%2CtradingArea%2CtradingAreaDesc%2CbookableToday%2CbookableTomorrow%2CisBqHis%2CtuId%2Ccitys%2CbackDate%2Csourceurl%2CisPinTuan%2CadvanceBooking%2CmobFunction%2CmarketTag%2CcoreArriveTag%2Cbrightspots%2CtotalPrice%2CotherTagInfos%2CnoExtraPayment%2CnoShopping%2CextensionImg%2CsightspotsNormalPoint%2CticketPoiLevel%2CticketPoiBelongCounty%2CticketPoiFatherPrice%2CjumpInfo%2CticketPoiFatherName%2CdistancePoi%2CaccuratePrice%2CproductSource%2CproductFeatureTags%2CproductCarPackageCount%2CproductCarNumber%2CtopType%2ClongPlanId%2CsupplierId%2Cimgs%2ChasVideo%2CuserScenicSpotDistance%2CuserHotelDistance%2ChotelScenicSpotDistance%2CreasonsForInclusion%2CforSale%2CvideoPreviewUrl%2Creserved%2CrandomImgUrl%2CitineraryDayFlexible%2CtravelDays%2CvalidBatchIds%2Cwrpparid%2Csourceurl%2CserviceType%2Ctype%2CvisaTypeId%2Csummary%2CtwoLeveltype%2CpriceDate%2CteamTypeId%2CteamType%2Ctotraffic%2Cbacktraffic%2CflightType%2CitineraryDay%2Cdetails%2CsoldCount90%2CproductRate%2CdetailUrlOuterTag%2CdetailBaseUrl%2CticketOnedayProduct%2CproductTheme%2CthemeType%2CreasonsForInclusion%2CforSale%2CvideoPreviewUrl%2CunionCouponIds%2Creserved%2CrandomImgUrl%2CitineraryDayFlexible%2ChotSpringWeekendBookable&mbfTabConfig=true&aroundWeight=1&allowOneDay=false&displayStatus=dijie_flight+dijie_jijiajiu_flight+ctrip_group+dijie_train_local_package+mobile&tuId=true&filterTagPlatform=mobile_app&type=all&branch=Ios_newa&platform=Ios&ecp=-currency%3AUSD&height=300&orderby=mobile-desc&userName=aifcyyp8627&qssrc=eyJhY3QiOiJzZWFyY2giLCJzcmMiOiJJb3Mvbm9ybWFsLzgwMDExMjQ4IiwidHMiOjE2MTgzODAwNTg3MjZ9&userId=324365304&modules=list%2CbookingInfo%2CactivityDetail&pts=4ad81b22-04f9-49cd-a10a-cb539bc0f0ae&quality=90&userCashBatch=ytcs2%2Cytcs1%2Csxtestlong&bqType=local-increase&ecpm=true&width=480&debug=true";

        //String depurl = "http://touch.dujia.qunar.com/list?modules=list%2CbookingInfo%2CactivityDetail&dappDealTrace=true&mbfTabConfig=true&ecpm=true&dep=%E6%AD%A6%E6%B1%89&query=%E6%B7%B1%E5%9C%B3&qsact=search&width=480&height=300&quality=90&needNoResult=true&originalquery=%E6%B7%B1%E5%9C%B3&ddf=true&type=all&v345=false&it=rn_index_search&userId=324365304&userName=aifcyyp8627&model=iPhone+XS+Max&abt_fht=A&includeAD=true&vpaschannel=dujiasearch&limit=0%2C10&allowOneDay=false&filterTagPlatform=mobile_app";

        for (int n = 0; n < 100; n++) {
            //1.随机获取dep与query
            String depCity = dep[new Random().nextInt(4)];
            String queryCity = query[new Random().nextInt(4)];
            String depurl = url + "&dep="+depCity+"&query="+queryCity+"&originalquery="+queryCity;
            HttpClientUtil httpClientUtil = new HttpClientUtil(depurl);

            //2.获取随即IP地址
            String randomIP = getRandomIP();
            System.out.println("用户IP地址为:"+randomIP);
            httpClientUtil.addParameter("IpAddress",randomIP);


            //httpClientUtil.addParameter("dep",URLEncoder.encode(depCity, "UTF-8"));
            //httpClientUtil.addParameter("query",URLEncoder.encode(queryCity, "UTF-8"));
            //httpClientUtil.addParameter("originalquery",URLEncoder.encode(queryCity, "UTF-8"));


            List<String> ips = new ArrayList<>();
            HashSet<String> engines = new HashSet<>();
            //请求5页,每页10个数据
            for (int i = 0; i < 5; i++) {
                httpClientUtil.addParameter("limit",i*10+",10");
                System.out.println(depurl);
                httpClientUtil.post();
                System.out.println(httpClientUtil.getStatusCode());
                if (200 == httpClientUtil.getStatusCode()) {
                    String content = httpClientUtil.getContent();
                    System.out.println(content);
                    ObjectMapper mapper = new ObjectMapper();
                    JsonNode data = mapper.readTree(content);

                    //得到id
                    JsonNode results = data.get("data").get("list").get("results");
                    for (JsonNode result : results) {
                        System.out.println("产品id为:"+result.get("id"));
                        ips.add(result.get("id").asText());
                    }
                    //得到请求引擎地址
                    JsonNode jsonNode = data.get("data").get("qdata").get("engineAddress");
                    if (jsonNode != null) {
                        String eng = data.get("data").get("qdata").get("engineAddress").get(0).asText();
                        System.out.println("请求引擎地址:" + eng);
                        engines.add(eng);
                    }
                } else {
                    System.out.println("请求异常");
                }
                try {
                    Thread.sleep(500+(int)Math.random()*100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }


            if (cheakIsRepeat(ips)){
                System.out.println("产品没有重复");
            }else {
                System.out.println("产品有重复");
                break;
            }

            if (engines.size() == 1) {
                System.out.println("请求同一台机器");
            } else {
                System.out.println("请求多台机器");
            }

            //每台机器的请求量
            for (String eng : engines) {
                System.out.println(eng);
                map.put(eng,map.get(eng)+1);
            }
            //查看每台机器请求量
            map.keySet().forEach(m-> System.out.println("引擎:"+m+"----请求量:"+map.get(m)));

            try {
                Thread.sleep(2000+(int)Math.random()*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public static String getRandomIP(){
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            arr.add(new Random().nextInt(256));
        }

        return StringUtils.join(arr.toArray(),".");
    }

    public static boolean cheakIsRepeat(List<String> array) {
        HashSet<String> hashSet = new HashSet<String>();
        for (int i = 0; i < array.size(); i++) {
            hashSet.add(array.get(i));
        }
        if (hashSet.size() == array.size()) {
            return true;
        } else {
            return false;
        }
    }
}
