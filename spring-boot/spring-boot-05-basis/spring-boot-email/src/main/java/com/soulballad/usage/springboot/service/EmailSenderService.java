package com.soulballad.usage.springboot.service;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : email
 * @since ：2020/5/22 21:33
 */
public interface EmailSenderService {

    /**
     * 发送简单邮件
     * @param to 目的地
     * @param subject 主题
     * @param content 内容
     */
    void sendSimpleEmail(String to, String subject, String content);

    /**
     * 发送含有html内容的邮件
     * @param to 目的地
     * @param subject 主题
     * @param content 内容
     */
    void sendHtmlEmail(String to, String subject, String content);

    /**
     * 发送带有附件的邮件
     * @param to 目的地
     * @param subject 主题
     * @param content 内容
     * @param filePath 附件路径
     */
    void sendEmailWithAttachments(String to, String subject, String content, String filePath);

    /**
     * 发送带有静态资源（图片）的邮件
     * @param to 目的地
     * @param subject 主题
     * @param content 内容
     * @param resPath 资源路径
     * @param resId 资源id
     */
    void sendEmailWithInlineResource(String to, String subject, String content, String resPath, String resId);
}
