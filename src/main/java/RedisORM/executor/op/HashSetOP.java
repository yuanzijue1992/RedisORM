package RedisORM.executor.op;

import RedisORM.executor.handle.Handle;
import RedisORM.logging.Log;
import RedisORM.logging.LogFactory;
import redis.clients.jedis.Jedis;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HashSetOP extends AbstractOP{

    private Log log;

    public HashSetOP(Method method, Handle handle) {

        super(method, handle);
        log = LogFactory.getLog(HashSetOP.class);
    }

    @Override
    protected Object opreate(Jedis jedis, Object... objects) {
        Long ans=null;
        if(log.isDebugEnabled()){
            log.debug("----hset key: "+objects[0]+" field: "+objects[1]+" value: "+objects[2]);
        }
        try {
            ans = (Long) method.invoke(handle,jedis,objects[0],objects[1],objects[2]);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return ans;
    }
}