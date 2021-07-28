/**
 * @author yang
 * 2021年03月25日 20:17:00
 */

import java.util.List;


public class RuleData {

    private String ruleName;
    private String supplierId;
    private List<LabelRule> labelRule;
    private String businessLine;
    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }
    public String getRuleName() {
        return ruleName;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }
    public String getSupplierId() {
        return supplierId;
    }

    public void setLabelRule(List<LabelRule> labelRule) {
        this.labelRule = labelRule;
    }
    public List<LabelRule> getLabelRule() {
        return labelRule;
    }

    public void setBusinessLine(String businessLine) {
        this.businessLine = businessLine;
    }
    public String getBusinessLine() {
        return businessLine;
    }

    @Override
    public String toString() {
        return "RuleData{" +
                "ruleName='" + ruleName + '\'' +
                ", supplierId='" + supplierId + '\'' +
                ", labelRule=" + labelRule +
                ", businessLine='" + businessLine + '\'' +
                '}';
    }
}
