package com.skywxp.mysite.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用返回结果类，服务端响应的数据都会封装为此对象。
 * @param <T>
 */
@Data
public class R<T> {

    private Integer code; //编码：1成功，0和其它数字为失败

    private String msg; //错误信息

    private T data; //数据

    private Map map = new HashMap(); //动态数据

    public static <T> R<T> success(T object) {//巧妙运用java对象转化为json数据，通过静态方法模拟构造方法的效果，这样每一次都可以返回一个新的对象，这个对象用于存储每次操作的结果，包含成功失败代码，以及相应操作的信息。
        R<T> r = new R<T>();
        r.data = object;//方法传入的对象啊，字符串啊直接装进来，T类型自动推断。
        r.code = 1;
        return r;
    }

    public static <T> R<T> error(String msg) {
        R r = new R();
        r.msg = msg;
        r.code = 0;
        return r;
    }

    public R<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }

}
