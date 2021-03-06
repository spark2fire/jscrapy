package cn.spark2fire.jscrapy.example;

import cn.spark2fire.jscrapy.Page;
import cn.spark2fire.jscrapy.Site;
import cn.spark2fire.jscrapy.annotation.Order;
import cn.spark2fire.jscrapy.annotation.SUrl;
import cn.spark2fire.jscrapy.processor.PageProcessor;

@Order(1)
@SUrl("www.baidu.com")
public class ExampleProcessor implements PageProcessor {
    private Site site = Site.me()
            .setRetryTimes(3)
            .setSleepTime(2000)
            .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3")
            .addHeader("Accept-Encoding", "gzip, deflate, br")
            .addHeader("Accept-Language", "en,zh-CN;q=0.9,zh;q=0.8")
            .addHeader("Connection", "keep-alive")
            .addHeader("Content-Length", "23")
            .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
            .addHeader("Cookie", "__jda=122270672.1560760502211997681825.1560760502.1560760502.1560760502.1; __jdc=122270672; __jdv=122270672|direct|-|none|-|1560760502212; __jdu=1560760502211997681825; PCSYCityID=country_2429; shshshfpa=d781d1da-aad0-0e0b-4e54-75105f303993-1560760519; shshshfpb=vbZf2qmqgwtN58kI1VoYLXQ%3D%3D; 3AB9D23F7A4B3C9B=I4OD2UMOLJRTEIDWHVUCF2XOLMTHYB4MSDGPRDPGPBYZSKJAUI6KRSN4MB4FI6H7IPWQUQICLIAUR3CQ4ZIFGCEP6Q; shshshfp=c45df2c29831fbc0c33bec2aaaae7941; user-key=4fbcc265-5d0b-4cb2-b09d-93c3f9644a51; cn=0; ipLoc-djd=1-72-4137-0; areaId=1; _gcl_au=1.1.590614289.1560760853; o2-webp=true; __jdb=122270672.24.1560760502211997681825|1.1560760502")
            .addHeader("cache-control", "no-cache")
            .addHeader("pragma", "no-cache")
            .addHeader("Referer", "https://www.jd.com/")
            .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:67.0) Gecko/20100101 Firefox/67.0");

    @Override
    public void process(Page page) {
    }

    @Override
    public Site getSite() {
        return site;
    }
}
