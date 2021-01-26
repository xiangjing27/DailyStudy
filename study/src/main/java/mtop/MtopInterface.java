package mtop;

import java.util.List;

/**
 * @author xiangjing
 * @version : MtopInterface, v 0.1 2020-11-21 10:30 xiangjing Exp$
 */
public class MtopInterface {
    private String name;
    private String mtopApi;
    private String hsfApi;
    private String inputClass;
    private List<MethodField> inputParams;
    private String outputClass;
    private List<MethodField> outputParams;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMtopApi() {
        return mtopApi;
    }

    public void setMtopApi(String mtopApi) {
        this.mtopApi = mtopApi;
    }

    public String getHsfApi() {
        return hsfApi;
    }

    public void setHsfApi(String hsfApi) {
        this.hsfApi = hsfApi;
    }

    public String getInputClass() {
        return inputClass;
    }

    public void setInputClass(String inputClass) {
        this.inputClass = inputClass;
    }

    public List<MethodField> getInputParams() {
        return inputParams;
    }

    public void setInputParams(List<MethodField> inputParams) {
        this.inputParams = inputParams;
    }

    public String getOutputClass() {
        return outputClass;
    }

    public void setOutputClass(String outputClass) {
        this.outputClass = outputClass;
    }

    public List<MethodField> getOutputParams() {
        return outputParams;
    }

    public void setOutputParams(List<MethodField> outputParams) {
        this.outputParams = outputParams;
    }
}
