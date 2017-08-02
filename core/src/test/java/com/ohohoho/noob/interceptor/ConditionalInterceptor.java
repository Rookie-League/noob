package com.ohohoho.noob.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.List;

/**
 * @author YaoJiamin
 * @description
 * @createDate 2017/8/2
 * @createTime 11:55
 */
@Slf4j
public class ConditionalInterceptor implements IMethodInterceptor {
    /**
     * 通过在resources下面创建META-INF/services文件夹，并配置ITestNGListener的实现，
     * 可以在TestNG在启动的时候，使用ServiceLoader加载其中的条目并注册。
     * 使用这个方法可以在TestNG开始处理之前过滤掉一些不想执行的测试用例，或者在这里给测试用例重新排序，
     * 不过，如果用例被@Depend标注了，那么这种用例将不会受影响。
     * 使用这种方法并不能完美与Spring4的@Conditional进行联动。
     */
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        log.info("Conditional test case execute");
        return methods;
    }
}
