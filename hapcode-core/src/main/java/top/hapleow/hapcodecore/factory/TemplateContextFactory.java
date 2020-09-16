package top.hapleow.hapcodecore.factory;

import top.hapleow.hapcodecore.config.ApplicationConfig;
import top.hapleow.hapcodecore.context.BasicTemplateContext;
import top.hapleow.hapcodecore.model.TableModel;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * 模板上下文工厂
 *
 * @author wuyulin
 * @date 2020/9/16
 */
public class TemplateContextFactory {

    public static final Map<String, Class<? extends BasicTemplateContext>> templateMap = new HashMap<>();


    public static void autoRegistTemplate() {
        try {
            URL systemResource = ClassLoader.getSystemResource("template/");

            File file = new File(systemResource.getPath());

            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File file1 : files) {
                    String name = file1.getName();
                    String preName = name.split("\\.")[0];
                    try {
                        Class aClass = Class.forName("top.hapleow.hapcodeweb.context." + preName + "TemplateContext");
                        registTemplate(name, aClass);
                    } catch (ClassNotFoundException e) {
                        // e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 注册模板
     *
     * @param templateName
     * @param clazz
     */
    public static synchronized void registTemplate(String templateName, Class<? extends BasicTemplateContext> clazz) {

        templateMap.put(templateName, clazz);
    }

    public static BasicTemplateContext getTemplateContext(String templateName, TableModel tableModel, String prefix, ApplicationConfig applicationConfig) {

        if (templateMap.size() == 0) {
            autoRegistTemplate();
        }

        Class<? extends BasicTemplateContext> clazz = templateMap.get(templateName);
        if (clazz != null) {
            try {

                return clazz.getConstructor(TableModel.class, String.class, ApplicationConfig.class).newInstance(tableModel, prefix, applicationConfig);

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
