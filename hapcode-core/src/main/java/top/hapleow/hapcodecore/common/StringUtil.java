package top.hapleow.hapcodecore.common;

/**
 * @author wuyulin
 * @date 2020/9/16
 */
public class StringUtil {


    /**
     * 下划线格式转驼峰格式
     *
     * @param str 字符串
     * @return
     */
    public static String underline2CamelCase(String str) {

        return underline2CamelCase(str, null);
    }


    /**
     * 下划线格式转驼峰格式
     *
     * @param str    字符串
     * @param prefix 前缀
     * @return
     */
    public static String underline2CamelCase(final String str, String prefix) {

        String name = str;

        if (name == null) {
            throw new NullPointerException();
        }
        if (prefix != null) {
            name = name.replace(prefix, "").toLowerCase();
        }

        String[] nameSlices = name.split("_");
        if (nameSlices.length == 1) {
            return nameSlices[0];
        }
        StringBuilder nameBuilder = new StringBuilder(nameSlices[0]);
        for (int i = 1; i < nameSlices.length; i++) {

            char[] chars = nameSlices[i].toCharArray();
            if (chars[0] >= 97 && chars[0] <= 122) {
                int aChar = chars[0];
                int bChar = aChar - 32;
                chars[0] = (char) bChar;
            }

            for (char aChar : chars) {
                nameBuilder.append(aChar);
            }
        }

        return nameBuilder.toString();
    }

    /**
     * 首字母从小写转换成大写
     *
     * @param str
     * @return
     */
    public static String firstCharUp(final String str) {

        String name = str;

        if (name == null) {
            throw new NullPointerException();
        }

        StringBuilder nameBuilder = new StringBuilder();
        char[] chars = name.toCharArray();
        if (chars[0] >= 97 && chars[0] <= 122) {
            int aChar = chars[0];
            int bChar = aChar - 32;
            chars[0] = (char) bChar;
        }
        for (char aChar : chars) {
            nameBuilder.append(aChar);
        }
        return nameBuilder.toString();
    }
}
