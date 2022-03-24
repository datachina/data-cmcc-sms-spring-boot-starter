package com.data.sms.cmcc.model;

import com.mascloud.sdkclient.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 中国移动短信工具
 *
 * @author jidaojiuyou
 * @since 2022/3/23
 */
public class CmccSmsUtils {

    @Autowired
    @Qualifier(value = "cmcc")
    private Client client;

    /**
     * 发送模板短信
     *
     * @param phoneNumber   电话号码
     * @param signName      签名名称
     * @param templateCode  短信模板ID
     * @param templateParam 短信模板变量对应的实际值(数组格式)
     * @param addSerial     扩展码，默认填""
     * @return 是否成功
     */
    public Boolean sendSms(String phoneNumber, String signName, String templateCode, String[] templateParam, String addSerial) {
        String[] phone = {phoneNumber};
        int rtm = client.sendTSMS(phone, templateCode, templateParam, addSerial, 0, signName, null);
        return 1 == rtm;
    }

    /**
     * 发送模板短信
     *
     * @param phoneNumber   电话号码
     * @param signName      签名名称
     * @param templateCode  短信模板ID
     * @param templateParam 短信模板变量对应的实际值(数组格式)
     * @return 是否成功
     */
    public Boolean sendSms(String phoneNumber, String signName, String templateCode, String[] templateParam) {
        String[] phone = {phoneNumber};
        int rtm = client.sendTSMS(phone, templateCode, templateParam, "", 0, signName, null);
        return 1 == rtm;
    }
}