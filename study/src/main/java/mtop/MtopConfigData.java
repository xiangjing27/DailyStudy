package mtop;

/**
 * @author xiangjing
 * @version : MtopConfigData, v 0.1 2020-11-21 10:22 xiangjing Exp$
 */
public class MtopConfigData {
    private String interfaceName;
    private String type;
    private String fieldCode;
    private String subFieldCode;
    private String fieldType;
    private String fieldComment;

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode;
    }

    public String getSubFieldCode() {
        return subFieldCode;
    }

    public void setSubFieldCode(String subFieldCode) {
        this.subFieldCode = subFieldCode;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldComment() {
        return fieldComment;
    }

    public void setFieldComment(String fieldComment) {
        this.fieldComment = fieldComment;
    }
}
