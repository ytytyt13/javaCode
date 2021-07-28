import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author yang
 * 2021年03月25日 16:12:00
 */
@JsonSerialize
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomModel {
    private String sId;
    private String labelName;
    private List<LabelRule> labelRule;


    public CustomModel(String sId) {
        this.sId = sId;
    }
}
