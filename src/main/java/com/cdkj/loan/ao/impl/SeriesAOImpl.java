package com.cdkj.loan.ao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.cdkj.loan.aliyun.util.HttpUtils;
import com.cdkj.loan.ao.ISeriesAO;
import com.cdkj.loan.bo.IBrandBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.ISeriesBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Brand;
import com.cdkj.loan.domain.Series;
import com.cdkj.loan.dto.req.XN630410Req;
import com.cdkj.loan.dto.req.XN630412Req;
import com.cdkj.loan.enums.EBrandStatus;
import com.cdkj.loan.exception.BizException;

@Service
public class SeriesAOImpl implements ISeriesAO {

    @Autowired
    private ISeriesBO seriesBO;

    @Autowired
    private IBrandBO brandBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Override
    public void addSeries(XN630410Req req) {
        Series series = new Series();
        series.setBrandCode(req.getBrandCode());
        series.setName(req.getName());
        series.setSlogan(req.getSlogan());
        series.setAdvPic(req.getAdvPic());
        series.setPrice(StringValidater.toLong(req.getPrice()));
        series.setStatus(EBrandStatus.TO_UP.getCode());
        series.setUpdater(req.getUpdater());
        series.setUpdateDatetime(new Date());
        series.setRemark(req.getRemark());
        seriesBO.saveSeries(series);

        // 导入车系基础数据
        // ArrayList<JSONArray> json = generateSeries();
        // for (JSONArray jsonArray : json) {
        // for (Object obj : jsonArray) {
        // JSONObject jo = (JSONObject) obj;
        // String id = jo.getString("id");
        // String name = jo.getString("name");
        // // String initial = jo.getString("initial");
        // String parentid = jo.getString("parentid");
        // String logo = jo.getString("logo");
        // String price = jo.getString("price");
        //
        // Series series = new Series();
        // series.setName(name);
        // series.setBrandCode(parentid);
        // series.setPrice(StringValidater.toLong(price));
        // series.setAdvPic(logo);
        // series.setStatus(EBrandStatus.TO_UP.getCode());
        // series.setUpdater("USYS201800000000001");
        // series.setUpdateDatetime(new Date());
        // seriesBO.saveSeries(series);
        // }
        // }
    }

    private ArrayList<JSONArray> generateSeries() {
        ArrayList<JSONArray> list = new ArrayList<JSONArray>();
        JSONArray json = null;
        String host = "https://jisucxdq.market.alicloudapi.com";
        String path = "/car/carlist";
        String method = "GET";
        String appcode = "1bd9832a74284772a7549ff0cc51043e";
        Map<String, String> headers = new HashMap<String, String>();
        // 最后在header中的格式(中间是英文空格)为Authorization:APPCODE
        // 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        ArrayList<String> arrayList = new ArrayList<String>();
        Brand condition = new Brand();
        List<Brand> queryBrand = brandBO.queryBrand(condition);
        for (Brand brand : queryBrand) {
            arrayList.add(brand.getDescription());
        }
        for (String brandCode : arrayList) {
            querys.put("parentid", brandCode);
            try {
                HttpResponse response = HttpUtils.doGet(host, path, method,
                    headers, querys);
                HttpEntity entity = response.getEntity();
                String string = EntityUtils.toString(entity);// 获取response的body
                // System.out.println("1------------->" + string);
                json = (JSONArray) JSONArray
                    .parse(string.substring(34, string.length() - 1));
                // System.out.println("2------------->" + json);
                list.add(json);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public void editSeries(XN630412Req req) {
        Series series = seriesBO.getSeries(req.getCode());
        if (EBrandStatus.UP.getCode().equals(series.getStatus())) {
            throw new BizException("xn0000", "品牌已上架，请在下架后修改");
        }
        series.setBrandCode(req.getBrandCode());
        series.setName(req.getName());
        series.setSlogan(req.getSlogan());
        series.setAdvPic(req.getAdvPic());
        series.setPrice(StringValidater.toLong(req.getPrice()));
        series.setUpdater(req.getUpdater());
        series.setUpdateDatetime(new Date());
        series.setRemark(req.getRemark());
        seriesBO.editSeries(series);
    }

    @Override
    public void upSeries(String code, String location, String orderNo,
            String updater) {
        Series series = seriesBO.getSeries(code);
        series.setLocation(StringValidater.toInteger(location));
        series.setOrderNo(StringValidater.toInteger(orderNo));
        series.setStatus(EBrandStatus.UP.getCode());
        series.setUpdater(updater);
        series.setUpdateDatetime(new Date());
        seriesBO.upSeries(series);
    }

    @Override
    public void downSeries(String code, String updater) {
        Series series = seriesBO.getSeries(code);
        series.setStatus(EBrandStatus.DOWN.getCode());
        series.setUpdater(updater);
        series.setUpdateDatetime(new Date());
        seriesBO.downSeries(series);
    }

    @Override
    public Paginable<Series> querySeriesPage(int start, int limit,
            Series condition) {
        Paginable<Series> paginable = seriesBO.getPaginable(start, limit,
            condition);
        for (Series series : paginable.getList()) {
            String realName = sysUserBO.getUser(series.getUpdater())
                .getRealName();
            series.setUpdaterName(realName);
        }
        return paginable;
    }

    @Override
    public Series getSeries(String code) {
        Series series = seriesBO.getSeries(code);
        String realName = sysUserBO.getUser(series.getUpdater()).getRealName();
        series.setUpdaterName(realName);
        return series;
    }

    @Override
    public List<Series> querySeriesList(Series condition) {
        List<Series> querySeries = seriesBO.querySeries(condition);
        for (Series series : querySeries) {
            String realName = sysUserBO.getUser(series.getUpdater())
                .getRealName();
            series.setUpdaterName(realName);
        }
        return querySeries;
    }

}
