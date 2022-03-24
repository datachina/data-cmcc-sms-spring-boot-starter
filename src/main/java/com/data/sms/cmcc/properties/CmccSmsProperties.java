package com.data.sms.cmcc.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 中国移动短信配置
 *
 * @author jidaojiuyou
 * @since 2022/3/23
 */
@Data
@ConfigurationProperties(prefix = "data.sms.cmcc")
public class CmccSmsProperties {
    /**
     * 登陆url
     */
    private String url = "http://mas.ecloud.10086.cn/app/sdk/login";
    /**
     * 账号
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    /**
     * 公司
     */
    private String company;
}