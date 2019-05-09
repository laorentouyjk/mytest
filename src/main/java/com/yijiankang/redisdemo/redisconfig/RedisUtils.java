package com.yijiankang.redisdemo.redisconfig;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service("redisUtils")
public class RedisUtils {

	@Autowired
    private RedisTemplate redisTemplate;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	private static Logger logger = LoggerFactory.getLogger(RedisUtils.class);  
	
	 /**
     * 写入缓存
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public List<String> getAll(){
    	List<String> ll=new ArrayList<String>();
    	 ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
    	 RedisSerializer rs=redisTemplate.getKeySerializer();
    	 Set s=redisTemplate.keys("*");
    	 Iterator it= s.iterator();
    	 while(it.hasNext()){
    		String str= (String) it.next();
    		ll.add(str);
    	 }
    	 return ll;
    }
    
    /**
     * redis 模糊查询
     * @param key
     * @return
     */
    public List<String> getLikeKey(final String key) {
    	List<String> ll=new ArrayList<String>();
   	 ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
   	 RedisSerializer rs=redisTemplate.getKeySerializer();
   	Set<String> keys = redisTemplate.keys(key+"*");
   	 Iterator it= keys.iterator();
   	 while(it.hasNext()){
   		String str= (String) it.next();
   		ll.add(str);
   	 }
   	 return ll;
    }
    
    /**
     * 写入缓存设置时效时间
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value, Long expireTime ,TimeUnit timeUnit) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, timeUnit);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 批量删除对应的value
     * @param keys
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 批量删除key
     * @param pattern
     */
    public void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0){
            redisTemplate.delete(keys);
        }
    }
    /**
     * 删除对应的value
     * @param key
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }
    /**
     * 判断缓存中是否有对应的value
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }
    /**
     * 读取缓存
     * @param key
     * @return
     */
    public Object get(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }
    


    /**
     * 哈希 添加
     * @param key
     * @param hashKey
     * @param value
     */
    public void hmSet(String key, Object hashKey, Object value){
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        hash.put(key,hashKey,value);
    }

    /**
     * 哈希获取数据
     * @param key
     * @param hashKey
     * @return
     */
    public Object hmGet(String key, Object hashKey){
        HashOperations<String, Object, Object>  hash = redisTemplate.opsForHash();
        return hash.get(key,hashKey);
    }

    /**
     * 列表添加
     * @param k
     * @param v
     */
    public void lPush(String k,Object v){
        ListOperations<String, Object> list = redisTemplate.opsForList();
        list.rightPush(k,v);
    }

    /**
     * 列表获取
     * @param k
     * @param l
     * @param l1
     * @return
     */
    public List<Object> lRange(String k, long l, long l1){
        ListOperations<String, Object> list = redisTemplate.opsForList();
        return list.range(k,l,l1);
    }
    
/*    @SuppressWarnings({"unchecked" })
	public boolean addList(final List<Message> map){
    	
    	List<String> result = (List<String>) redisTemplate.execute(new RedisCallback<List<String>>() {  
            public List<String> doInRedis(RedisConnection connection)  
                    throws DataAccessException {  
                Jackson2JsonRedisSerializer serializer=new Jackson2JsonRedisSerializer(String.class);
                
                Gson gson = new Gson();
                List<String> ll=new ArrayList<String>();
        	    for(Message mes:map){  
        	    	logger.info("开始处理报文："+mes.getContent());
        	    	String key=String.valueOf(System.currentTimeMillis()+new Random().nextInt(2147483647));
        	    	key=mes.getContent();
        	    	ll.add(key);
                	byte[] keys  = serializer.serialize(key); 
                    byte[] name = serializer.serialize(gson.toJson(mes));  
                    connection.setNX(keys, name);  
        	    } 
        	    connection.close();
                return ll;  
            }  
        }, false, true);  
        if(result!=null && result.size()>0){
        	pubMsg(DataConstant.queue,JSONObject.toJSONString(result));
        }
        return true;  
    }
*/
    /**
     * 集合添加
     * @param key
     * @param value
     */
    public void add(String key,Object value){
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        set.add(key,value);
    }

    /**
     * 集合获取
     * @param key
     * @return
     */
    public Set<Object> setMembers(String key){
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        return set.members(key);
    }
    
    /**
     * 集合删除
     * @param key 键值
     * @param value 要删除的对象
     * @return
     */
    public long removeSet(String key,Object value){
    	SetOperations<String, Object> set = redisTemplate.opsForSet();
    	return set.remove(key,value);
    }

    /**
     * 有序集合添加
     * @param key
     * @param value
     * @param scoure
     */
    public void zAdd(String key,Object value,double scoure){
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        zset.add(key,value,scoure);
    }

    /**
     * 有序集合获取
     * @param key
     * @param scoure
     * @param scoure1
     * @return
     */
    public Set<Object> rangeByScore(String key,double scoure,double scoure1){
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        return zset.rangeByScore(key, scoure, scoure1);
    }
    
    public void pubMsg(String queue,String content) {
        stringRedisTemplate.convertAndSend(queue,content);
    }
	
}
