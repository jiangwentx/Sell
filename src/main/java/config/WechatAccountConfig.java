package config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: sell
 * @description:
 * @author: Mr.Jiang
 * @create: 2018-11-25 14:59
 **/
@Data
@Component
@ConfigurationProperties(prefix="wechat")
//这个注解以后使用就可以 wechat.mpAppId，把下面的属性封装到wechat中
public class WechatAccountConfig {
    private String mpAppId;
    private String mpAppSecret;
}

