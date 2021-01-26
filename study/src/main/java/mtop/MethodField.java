package mtop;

import java.util.List;

/**
 * @author xiangjing
 * @version : MethodField, v 0.1 2020-11-21 10:32 xiangjing Exp$
 */
public class MethodField {
    private String code;
    private String type;
    private String comment;
    private String subFieldClass;
    private List<MethodField> subFields;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubFieldClass() {
        return subFieldClass;
    }

    public void setSubFieldClass(String subFieldClass) {
        this.subFieldClass = subFieldClass;
    }

    public List<MethodField> getSubFields() {
        return subFields;
    }

    public void setSubFields(List<MethodField> subFields) {
        this.subFields = subFields;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
