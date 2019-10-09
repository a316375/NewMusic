package Intentnet;

import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import Adatper.Util;

/**
 * Created by Administrator on 2017/3/26.
 */

public class VIP {
    private String name;
    private Integer code;
    private String address;

    public VIP(String name, Integer code, String address) {
        this.name = name;
        this.code = code;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "VIP{" +
                "name='" + name + '\'' +
                ", code=" + code +
                ", address='" + address + '\'' +
                '}';
    }

    /**
     * 创建jsonArrys数组
     * String build = VIP.build("abc>>xyx", 1, "http://pic.qiantucdn.com/58pic/15/67/57/79258PICKUQ_1024.jpg!/format/webp");
     * List<VIP> pare = VIP.pare(build);
     * System.out.println("----->>>"+build);;
     **/
    public static String build(String name, int i, String address) {
        ArrayList<VIP> list = new ArrayList<VIP>();
        VIP vip = new VIP(name, i, address);
        list.add(vip);
        return Util.gson.toJson(list);

    }


    /**
     * 解析本jsonArrays数组
     **/
    public static List<VIP> pare(String string) {
        List<VIP> list = Util.gson.fromJson(string, new TypeToken<List<VIP>>() {
        }.getType());
        return list;
    }


}
