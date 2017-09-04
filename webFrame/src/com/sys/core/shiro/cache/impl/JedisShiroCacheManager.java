package com.sys.core.shiro.cache.impl;

import org.apache.shiro.cache.Cache;

import com.sys.core.shiro.cache.JedisManager;
import com.sys.core.shiro.cache.JedisShiroCache;
import com.sys.core.shiro.cache.ShiroCacheManager;

/**
 * 
 * 开发公司：sys在线工具 <p>
 * 版权所有：© www.sys.com<p>
 * 博客地址：http://www.sys.com/blog/  <p>
 * <p>
 * 
 * JRedis管理
 * 
 * <p>
 * 
 * 区分　责任人　日期　　　　说明<br/>
 * 创建　周柏成　2016年6月2日 　<br/>
 *
 * @author zhou-baicheng
 * @email  so@sys.com
 * @version 1.0,2016年6月2日 <br/>
 * 
 */
public class JedisShiroCacheManager implements ShiroCacheManager {

    private JedisManager jedisManager;

    @Override
    public <K, V> Cache<K, V> getCache(String name) {
        return new JedisShiroCache<K, V>(name, getJedisManager());
    }

    @Override
    public void destroy() {
    	//如果和其他系统，或者应用在一起就不能关闭
    	//getJedisManager().getJedis().shutdown();
    }

    public JedisManager getJedisManager() {
        return jedisManager;
    }

    public void setJedisManager(JedisManager jedisManager) {
        this.jedisManager = jedisManager;
    }
}
