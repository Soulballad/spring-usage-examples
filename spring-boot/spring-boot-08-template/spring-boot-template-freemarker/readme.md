springboot无法跳转ftl模板文件？
[springboot freemarker不渲染页面返回字符串](https://blog.csdn.net/baidu_27222643/article/details/78965320)
原因在于使用了`@RestController`注解，换成`@Controller`后解决