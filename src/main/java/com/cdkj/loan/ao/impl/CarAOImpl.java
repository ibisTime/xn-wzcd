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
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.cdkj.loan.aliyun.util.HttpUtils;
import com.cdkj.loan.ao.ICarAO;
import com.cdkj.loan.bo.ICarBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.ISeriesBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Car;
import com.cdkj.loan.domain.Series;
import com.cdkj.loan.dto.req.XN630420Req;
import com.cdkj.loan.dto.req.XN630422Req;
import com.cdkj.loan.enums.EBrandStatus;
import com.cdkj.loan.exception.BizException;

@Service
public class CarAOImpl implements ICarAO {

    @Autowired
    private ICarBO carBO;

    @Autowired
    private ISeriesBO seriesBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Override
    @Transactional
    public void addCar(XN630420Req req) {
        Car car = new Car();

        car.setName(req.getName());
        car.setSeriesCode(req.getSeriesCode());
        car.setSeriesName(req.getSeriesName());
        car.setBrandCode(req.getBrandCode());
        car.setBrandName(req.getBrandName());

        car.setOriginalPrice(StringValidater.toLong(req.getOriginalPrice()));
        car.setSalePrice(StringValidater.toLong(req.getSalePrice()));
        car.setSfAmount(StringValidater.toLong(req.getSfAmount()));
        car.setSlogan(req.getSlogan());
        car.setAdvPic(req.getAdvPic());

        car.setPic(req.getPic());
        car.setDescription(req.getDescription());
        car.setStatus(EBrandStatus.TO_UP.getCode());
        car.setUpdater(req.getUpdater());
        car.setUpdateDatetime(new Date());

        car.setRemark(req.getRemark());
        carBO.saveCar(car);

        // ArrayList<JSONArray> json = generateCar();
        // for (JSONArray jsonArray : json) {
        // for (Object obj : jsonArray) {
        // JSONObject jo = (JSONObject) obj;
        // String name = jo.getString("name");
        // String parentid = jo.getString("parentid");
        // String price = jo.getString("price");
        // String logo = jo.getString("logo");
        //
        // Car car = new Car();
        // car.setName(name);
        // car.setSeriesCode(parentid);
        // if (StringUtils.isNotBlank(price)) {
        // String[] split = price.split("万");
        // car.setOriginalPrice(
        // (long) (Double.parseDouble(split[0]) * 10000));
        // }
        // car.setAdvPic(logo);
        // car.setStatus(EBrandStatus.TO_UP.getCode());
        // car.setUpdater("USYS201800000000001");
        // car.setUpdateDatetime(new Date());
        // carBO.saveCar(car);
        // }
        // }
    }

    private ArrayList<JSONArray> generateCar() {
        ArrayList<JSONArray> list = new ArrayList<JSONArray>();
        JSONArray json = null;
        String host = "https://jisucxdq.market.alicloudapi.com";
        String path = "/car/detail";
        String method = "GET";
        String appcode = "1bd9832a74284772a7549ff0cc51043e";
        Map<String, String> headers = new HashMap<String, String>();
        // 最后在header中的格式(中间是英文空格)为Authorization:APPCODE
        // 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        Series condition = new Series();
        List<Series> querySeries = seriesBO.querySeries(condition);
        for (Series series : querySeries) {
            querys.put("carid", series.getSlogan());
            try {
                HttpResponse response = HttpUtils.doGet(host, path, method,
                    headers, querys);
                HttpEntity entity = response.getEntity();
                String string = EntityUtils.toString(entity);// 获取response的body
                System.out.println("string------------->" + string + "||||||");
                String substring = string.substring(34, string.length() - 1);
                System.out
                    .println("substring----------->" + substring + "|||||");
                json = (JSONArray) JSONArray
                    .parse(substring.substring(34, substring.length() - 1));
                System.out.println("json------------->" + json + "||||||");
                list.add(json);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public void editCar(XN630422Req req) {
        Car car = carBO.getCar(req.getCode());
        if (EBrandStatus.UP.getCode().equals(car.getStatus())) {
            throw new BizException("xn0000", "品牌已上架，请在下架后修改");
        }
        car.setName(req.getName());
        car.setSeriesCode(req.getSeriesCode());
        car.setSeriesName(req.getSeriesName());
        car.setBrandCode(req.getBrandCode());
        car.setBrandName(req.getBrandName());
        car.setOriginalPrice(StringValidater.toLong(req.getOriginalPrice()));
        car.setSalePrice(StringValidater.toLong(req.getSalePrice()));
        car.setSfAmount(StringValidater.toLong(req.getSfAmount()));
        car.setSlogan(req.getSlogan());
        car.setAdvPic(req.getAdvPic());
        car.setPic(req.getPic());
        car.setDescription(req.getDescription());
        car.setUpdater(req.getUpdater());
        car.setUpdateDatetime(new Date());
        car.setRemark(req.getRemark());
        carBO.editCar(car);
    }

    @Override
    public void upCar(String code, String location, String orderNo,
            String updater, String remark) {
        Car car = carBO.getCar(code);
        car.setStatus(EBrandStatus.UP.getCode());
        car.setLocation(StringValidater.toInteger(location));
        car.setOrderNo(StringValidater.toInteger(orderNo));
        car.setUpdater(updater);
        car.setUpdateDatetime(new Date());
        car.setRemark(remark);
        carBO.editCar(car);
    }

    @Override
    public void downCar(String code, String updater, String remark) {
        Car car = carBO.getCar(code);
        car.setStatus(EBrandStatus.DOWN.getCode());
        car.setUpdater(updater);
        car.setUpdateDatetime(new Date());
        car.setRemark(remark);
        carBO.editCar(car);
    }

    @Override
    public Paginable<Car> queryCarPage(int start, int limit, Car condition) {
        Paginable<Car> paginable = carBO.getPaginable(start, limit, condition);
        for (Car car : paginable.getList()) {
            String realName = sysUserBO.getUser(car.getUpdater()).getRealName();
            car.setUpdaterName(realName);
        }
        return paginable;
    }

    @Override
    public Car getCar(String code) {
        Car car = carBO.getCar(code);
        String realName = sysUserBO.getUser(car.getUpdater()).getRealName();
        car.setUpdaterName(realName);
        return car;
    }

    @Override
    public List<Car> queryCarList(Car condition) {
        List<Car> queryCar = carBO.queryCar(condition);
        for (Car car : queryCar) {
            String realName = sysUserBO.getUser(car.getUpdater()).getRealName();
            car.setUpdaterName(realName);
        }
        return queryCar;
    }

}
