package com.zl.conf;

import com.zl.dm.json.conf.MapperFeature;
import org.junit.Assert;
import org.junit.Test;

public class ConfTest {

    @Test
    public void f1(){

        System.out.println(MapperFeature.ONE.getMask());
        System.out.println(MapperFeature.TWO.getMask());
        System.out.println(MapperFeature.THREE.getMask());
        System.out.println(MapperFeature.FOUR.getMask());
        System.out.println(MapperFeature.SIX.getMask());
        System.out.println(MapperFeature.ZERO.enabledByDefault());
        Assert.assertEquals(1,MapperFeature.ZERO.getMask());

    }

    @Test
    public void f2(){
        for(int i=0;i<100;i++){
            System.out.println(MapperFeature.ONE.enabled(i));
        }
    }

    @Test
    public void f3(){
        for(int i=0;i<=10;i++){
            System.out.println(i|2);
        }

    }

}
