package com.data.sms.cmcc.config;

import com.data.sms.cmcc.model.CmccSmsUtils;
import com.data.sms.cmcc.properties.CmccSmsProperties;
import com.mascloud.sdkclient.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 中国移动短信自动配置
 *
 * @author jidaojiuyou
 * @since 2022/3/23
 */
@Configuration
@EnableConfigurationProperties(CmccSmsProperties.class)
@Slf4j
public class CmccSmsAutoConfiguration {


    @Autowired
    private CmccSmsProperties cmccSmsProperties;

    /**
     * 获取Client并登陆
     *
     * @return Client
     */
    @Bean(name = "cmcc")
    @ConditionalOnMissingBean(Client.class)
    public Client client() {
        Client instance = Client.getInstance();
        boolean login = instance.login(cmccSmsProperties.getUrl(), cmccSmsProperties.getUsername(), cmccSmsProperties.getPassword(), cmccSmsProperties.getCompany());
        if (login) {
            log.debug("登陆成功");
        } else {
            log.error("登陆失败");
        }
        return instance;
    }

    @Bean
    public CmccSmsUtils cmccSmsUtils() {
        return new CmccSmsUtils();
    }
}