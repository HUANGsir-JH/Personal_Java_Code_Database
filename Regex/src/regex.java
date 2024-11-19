import java.util.regex.Pattern;

public class regex {
    public static void main(String[] args) {
    
    }
}

/**
 * 推荐网址： https://ihateregex.io/
 */


/*
  Java正则表达式完整使用文档
 
  1. 正则表达式基础语法
  =====================
  字符类：
  [abc]     - 表示a、b、c中的任意一个字符
  [^abc]    - 表示除了a、b、c以外的任意字符
  [a-zA-Z]  - 表示a到z或A到Z的任意字符
 
  预定义字符类：
  .         - 任意字符
  \d        - 数字：[0-9]
  \D        - 非数字：[^0-9]
  \s        - 空白字符：[ \t\n\x0B\f\r]
  \S        - 非空白字符：[^\s]
  \w        - 单词字符：[a-zA-Z_0-9]
  \W        - 非单词字符：[^\w]
 
  数量词：
  X?        - X出现一次或零次
  X*        - X出现零次或多次
  X+        - X出现一次或多次
  X{n}      - X恰好出现n次
  X{n,}     - X至少出现n次
  X{n,m}    - X至少出现n次，但不超过m次
 
  边界匹配：
  ^         - 行的开头
  $         - 行的结尾
  \b        - 单词边界
  \B        - 非单词边界
 */

/**
 * 方法：
 *      1. Pattern.compile() - 用于编译正则表达式,返回一个Pattern对象,适合多次使用
 *          String.matches(regex) -  用于判断字符串是否符合正则表达式,适合单次使用，返回boolean
 *      2. Pattern.matcher() - 用于匹配字符串是否符合正则表达式，返回一个Matcher对象
 *      3. Matcher.matches() - 判断字符串是否符合正则表达式,返回boolean
 *      4. Matcher.find() - 查找下一个符合正则表达式的子串
 *      5. Matcher.replaceAll() - 替换符合正则表达式的子串
 *      6. Matcher.replaceFirst() - 替换第一个符合正则表达式的子串
 *      7. Matcher.group() - 获取匹配的子串
 *      8. Matcher.groupCount() - 获取匹配的子串个数
 *      9. Matcher.start() - 获取匹配的子串的起始位置
 *      10. Matcher.end() - 获取匹配的子串的结束位置
 */
class regex_example{
    public static void main(String[] args) {
        /**
         * 2. 手机号码规则（中国大陆）
         * - 以1开头
         * - 第二位可以是3-9
         * - 后面跟9位数字
         * - 总共11位
         */
        String phoneNumberPattern = "^1[3-9]\\d{9}$";
        Pattern PhoneNUmberCompile = Pattern.compile(phoneNumberPattern);
        boolean isPhoneNumber = PhoneNUmberCompile.matcher("13512345678").matches();
        System.out.println(isPhoneNumber);
        
        /**
         *
         * 1. 用户名规则
         * - 允许字母、数字、下划线
         * - 长度限制4-16位
         * - 必须以字母开头
         */
        String usernamePattern = "^[a-zA-Z][a-zA-Z0-9_]{3,15}$";
        Pattern usernameCompile = Pattern.compile(usernamePattern);
        boolean isUsername = usernameCompile.matcher("a123").matches();
        System.out.println(isUsername);
        
        /**
         * 3. 电子邮箱规则
         * - 用户名部分：允许字母、数字、下划线、点号、横杠
         * - @符号
         * - 域名部分：允许字母、数字、横杠
         * - 顶级域名：2-6个字符
         */
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        Pattern emailCompile = Pattern.compile(emailPattern);
        boolean isEmail = emailCompile.matcher("a@b.com").matches();
        System.out.println(isEmail);
        
        /**
         * 4. 密码强度规则
         * - 至少8位
         * - 至少包含一个大写字母
         * - 至少包含一个小写字母
         * - 至少包含一个数字
         * - 至少包含一个特殊字符
         */
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        Pattern passwordCompile = Pattern.compile(passwordPattern);
        boolean isPassword = passwordCompile.matcher("Abc123!@#").matches();
        System.out.println(isPassword);
        
        /**
         * 5. 中国身份证号码规则
         * - 18位数字
         * - 最后一位可能是X(大写)
         */
        String idCardPattern = "^[1-9]\\d{5}(19|20)\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])\\d{3}[0-9X]$";
        Pattern idCardCompile = Pattern.compile(idCardPattern);
        boolean isIdCard = idCardCompile.matcher("123456789012345678").matches();
        System.out.println(isIdCard);
        
        /**
         * 6. IPv4地址规则
         * - 四组数字，每组0-255
         * - 用点号分隔
         */
        String ipv4Pattern = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$";
        Pattern ipv4Compile = Pattern.compile(ipv4Pattern);
        boolean isIPv4 = ipv4Compile.matcher("244.178.44.111").matches();
        System.out.println(isIPv4);
    }
}
