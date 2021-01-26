package mtop;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiangjing
 * @version : MtopCodeGen, v 0.1 2020-11-21 10:16 xiangjing Exp$
 */
public class MtopCodeGen {

    public static void main(String[] args) {
        // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
        // 写法1：
        String fileName = "/Users/xiangjing/Downloads/驿丁宝接口定义.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        MtopConfigListener mtopConfigListener = new MtopConfigListener();
        EasyExcel.read(fileName, MtopConfigData.class, mtopConfigListener).sheet().doRead();
        List<MtopConfigData> list = mtopConfigListener.getList();

        System.out.println(list.size());

        boolean enterInput = false;
        boolean enterOutput = false;
        List<MtopInterface> interfaces = new ArrayList<>();
        MtopInterface current = null;
        for (MtopConfigData mtopConfigData : list) {
            // 第三列
            String thirdColValue = mtopConfigData.getFieldCode();

            if(isNotBlank(mtopConfigData.getInterfaceName())) {
                enterOutput = false;
                MtopInterface mtopInterface = new MtopInterface();
                interfaces.add(mtopInterface);

                current = mtopInterface;
                current.setName(mtopConfigData.getInterfaceName());
            }
            if(isNotBlank(mtopConfigData.getType())) {
                if(mtopConfigData.getType().startsWith("mtop") && isNotBlank(thirdColValue)) {
                    current.setMtopApi(thirdColValue);
                }
                if(mtopConfigData.getType().startsWith("hsf") && isNotBlank(thirdColValue)) {
                    current.setHsfApi(thirdColValue);
                }
                if(mtopConfigData.getType().startsWith("入参")) {
                    enterInput = true;
                    current.setInputClass(thirdColValue);
                    current.setInputParams(new ArrayList<>());
                    continue;
                }
                if(mtopConfigData.getType().startsWith("出参")) {
                    enterInput = false;
                    enterOutput = true;
                    current.setOutputClass(thirdColValue);
                    current.setOutputParams(new ArrayList<>());
                    continue;
                }
            }
            if(enterInput) {
                buildMethodField(current.getInputParams(), mtopConfigData);
            }
            if(enterOutput) {
                buildMethodField(current.getOutputParams(), mtopConfigData);
            }
        }

        System.out.println(interfaces.size());

        CodeGenerator.genCode(interfaces);

        // 写法2：
        //ExcelReader excelReader = null;
        //try {
        //    excelReader = EasyExcel.read(fileName, MtopConfigData.class, mtopConfigListener).build();
        //    ReadSheet readSheet = EasyExcel.readSheet(0).build();
        //    excelReader.read(readSheet);
        //} finally {
        //    if (excelReader != null) {
        //        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        //        excelReader.finish();
        //    }
        //}
    }

    private static MethodField buildMethodField(List<MethodField> params, MtopConfigData mtopConfigData) {
        MethodField methodField = new MethodField();

        methodField.setCode(mtopConfigData.getFieldCode());
        methodField.setType(mtopConfigData.getFieldType());
        methodField.setComment(mtopConfigData.getFieldComment());

        if("List".equals(mtopConfigData.getFieldType())) {
            methodField.setSubFieldClass(mtopConfigData.getSubFieldCode());
            methodField.setSubFields(new ArrayList<>());
        }

        if(isNotBlank(mtopConfigData.getSubFieldCode())) {
            methodField.setCode(mtopConfigData.getSubFieldCode());
            params.get(params.size() - 1).getSubFields().add(methodField);
        }

        if(isNotBlank(mtopConfigData.getFieldCode())) {
            params.add(methodField);
        }

        return methodField;
    }

    private static boolean isNotBlank(String interfaceName) {
        return null != interfaceName && interfaceName.trim().length() > 0;
    }
}
