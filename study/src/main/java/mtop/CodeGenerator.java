package mtop;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiangjing
 * @version : CodeGenerator, v 0.1 2020-11-23 09:40 xiangjing Exp$
 */
public class CodeGenerator {

    private static final String lineSeperator = System.getProperty("line.seperator");

    static VelocityEngine ve;

    public static void genCode(List<MtopInterface> interfaces) {

        List<Map<String, Object>> methods = new ArrayList<>();
        interfaces.forEach(p -> {
            List<Map<String, Object>> params = new ArrayList<>();
            p.getInputParams().forEach(s -> {
                Map<String, Object> pa = new HashMap<>();
                pa.put("type", s.getType());
                pa.put("name", s.getCode());
                pa.put("comment", s.getComment());

                params.add(pa);
            });

            Map<String, Object> mt = new HashMap<>();
            mt.put("comment", p.getName());
            mt.put("name", "xxx");
            mt.put("params", params);

            methods.add(mt);
        });


        //获取模板引擎
        VelocityEngine ve = getVelocityEngine();

        //获取上下文
        VelocityContext root = new VelocityContext();
        //把数据填入上下文
        root.put("package", "package");
        root.put("className", "ClassNameA");
        root.put("methods", methods);

        //输出路径
        try {
            //输出
            StringWriter w=new StringWriter();
            //获取模板
            Template template = ve.getTemplate("template/interface.vm");
            template.merge(root, w);

            w.append(lineSeperator);
            w.append(lineSeperator);
            //获取模板
            w.flush();
            template = ve.getTemplate("template/interfaceImpl.vm");
            template.merge(root, w);
            System.out.println(w);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static VelocityEngine getVelocityEngine() {
        if(null != ve) {
            return ve;
        }
        ve = new VelocityEngine();
        //模板文件所在的路径
        String templatePath = "/Users/xiangjing/IdeaProjects/DailyStudy/study/src/main/resources";
        File templateFolder = new File(templatePath + File.separator + "template");
        if(templateFolder.exists()) {
            ve.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, templatePath + "/");
        } else {
            ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
            ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        }

        //初始化模板
        ve.init();
        return ve;
    }
}
