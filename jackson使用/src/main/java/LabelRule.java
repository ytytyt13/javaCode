import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author yang
 * 2021年03月25日 16:15:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LabelRule {

    private String productFunction;
    private List<String> toTraffics;
}
