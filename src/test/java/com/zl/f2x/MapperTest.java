package com.zl.f2x;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.zl.dm.json.bean.Bean;
import com.zl.dm.json.bean.Book;
import com.zl.dm.json.bean.Status;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

public class MapperTest {

    @Test
    public void f1() throws Exception{
        Book book = new Book();
        //book.setName("jvm");
        //book.setBook(book);
        book.setPubTime(new Date());
        book.setCreateAt(new java.sql.Date(System.currentTimeMillis()));
        book.setUpdateAt(new Timestamp(System.currentTimeMillis()));
        book.setStartTime(new Time(System.currentTimeMillis()));
        Map<Date,String> stats = new LinkedHashMap<>();
        stats.put(new Date(),"fist");
        book.setSetmants(stats);
        char[] chars= {'a','b','c'};
        book.setChars(chars);
        book.setStatus(Status.START);
        book.setKws(Arrays.asList("apple"));
        Map<Integer,String> maps = new LinkedHashMap<>();
        maps.put(6,"a");
        maps.put(10,"b");
        maps.put(2,"c");
        book.setMaps(maps);
        ObjectMapper mapper = new ObjectMapper();
        //在最外层追加类名
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE,true);
        //格式化输出,输出的结果带有缩进,方便用户辨识
        mapper.configure(SerializationFeature.INDENT_OUTPUT,true);
        //序列化的对象如果没有getter方法,则抛出异常
        //jackson默认是通过反射getter方法,获取类(推测)的成员变量并序列化对象成员变量;
        //即使类中没有变量但是有同名变量的getter,也会序列化出该变量,其值为方法的返回值
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,true);
        //在待序列化的对象中,如果存在自引用的对象,若true则抛出json的异常,否则false则抛出StackOverflowError异常
        mapper.configure(SerializationFeature.FAIL_ON_SELF_REFERENCES,false);
        //序列化期间,如果产生异常 true:会根据捕获的异常加jackson提供的附加信息,返沪错误的包装异常; false:返回原始异常
        mapper.configure(SerializationFeature.WRAP_EXCEPTIONS,true);
        //FAIL_ON_SELF_REFERENCES=false时生效,当为true时,则将自引用对象设置为null; false时,正常抛出异常
        mapper.configure(SerializationFeature.WRITE_SELF_REFERENCES_AS_NULL,true);
        //待序列化对象的变量类型是 java.util.Date,java.sql.Timestamp 即Date类及其子类时
        //true: 返回时间戳
        //false: 默认按照ISO-8601 进行序列化 格式如:2021-09-05T06:39:01.585+00:00
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,true);
        mapper.configure(SerializationFeature.WRITE_DATES_WITH_ZONE_ID,false);

        //作用于char[]类型的变量  例如chars[]chars= {'a','b','c'};
        //true:以char数组形式输出 输出: [ "a", "b", "c" ]
        //false:以字符串输出      输出: "abc"
        mapper.configure(SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS,true);

        mapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING,true);
        mapper.configure(SerializationFeature.WRITE_ENUMS_USING_INDEX,false);

        mapper.configure(SerializationFeature.WRITE_ENUM_KEYS_USING_INDEX,true);

        //当变量是集合(List)时,且元素个数只有一个时, 当true只输出一个元素并且不是数组类型 ; false输出数组元素
        mapper.configure(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED,false);

        mapper.configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS,false);

        mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS,true);

        String bkJson = mapper.writeValueAsString(book);
        System.out.println(bkJson);
    }

    @Test
    public void f2() throws Exception{
        Bean bean = new Bean();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT,true);
        String json = mapper.writeValueAsString(bean);
        System.out.println(json);
    }

    @Test
    public void f3() throws Exception{
        Bean bean = new Bean();
        bean.setPrice(BigDecimal.valueOf(12334535345456700.12345634534534578901));

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT,true);
        mapper.configure(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN,true);
        mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN,false);
        String json = mapper.writeValueAsString(bean);
        System.out.println(json);

    }

    @Test
    public void f5() throws Exception{
        Bean bean = new Bean();
        bean.setId(10);
        bean.setBeanName("java bean Pojo");
        bean.setTime(new Date());
        bean.setTsp(new Timestamp(System.currentTimeMillis()));

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT,true);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,true);
        //mapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        //mapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);
        //mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        //mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //mapper.setSerializationInclusion(JsonInclude.Include.USE_DEFAULTS);
        //mapper.setSerializationInclusion(JsonInclude.Include.NON_ABSENT);
        //mapper.setSerializationInclusion(JsonInclude.Include.CUSTOM);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        mapper.setDateFormat(sdf);
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        //mapper.setPropertyNamingStrategy(PropertyNamingStrategies.KEBAB_CASE);
        //mapper.setPropertyNamingStrategy(PropertyNamingStrategies.UPPER_CAMEL_CASE);


        String json = mapper.writeValueAsString(bean);
        System.out.println(json);

    }

}
