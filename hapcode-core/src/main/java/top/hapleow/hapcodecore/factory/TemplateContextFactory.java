package top.hapleow.hapcodecore.factory;

import top.hapleow.hapcodecore.config.ApplicationConfig;
import top.hapleow.hapcodecore.model.BasicTemplateContext;
import top.hapleow.hapcodecore.model.ModelTemplateContext;
import top.hapleow.hapcodecore.model.TableModel;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * 模板上下文工厂
 *
 * @author wuyulin
 * @date 2020/9/16
 */
public class TemplateContextFactory {

    private static final Map<String, Class<? extends BasicTemplateContext>> templateMap = new HashMap<>();


    private static synchronized void initTemplateMap() {

        templateMap.put("Model.java.btl", ModelTemplateContext.class);


    }

    public static BasicTemplateContext getTemplateContext(String templateName, TableModel tableModel, String prefix, ApplicationConfig applicationConfig) {

        if (templateMap.size() == 0) {
            synchronized (templateMap) {
                if (templateMap.size() == 0) {
                    initTemplateMap();
                }
            }
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
