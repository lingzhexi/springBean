import com.stormling.aop.MainConfigOfAop;
import com.stormling.aop.MathCalculator;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: StormLing
 * @Description:
 * @Date: Created in 11:30 2020-05-29
 * @Modified By:
 */
public class IOCTestAOP {
    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAop.class);
        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
        mathCalculator.div(10, 1);
        applicationContext.close();
    }
}
