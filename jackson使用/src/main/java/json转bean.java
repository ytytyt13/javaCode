import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * @author yang
 * 2021年03月25日 19:49:00
 */
public class json转bean {

    private static final TypeReference<AllRoot> FINAL_LIST_LABERULE_REFFRENCE = new TypeReference<AllRoot>(){};
    private static final TypeReference<List<RuleData>> FINAL_DATA_REFFRENCE = new TypeReference<List<RuleData>>(){};
    public static void main(String[] args) throws IOException {
        String json = "{\n" +
                "  \"sight_engine\":{\n" +
                "    \"shards\":{\"shard1\":{\n" +
                "        \"parent\":null,\n" +
                "        \"range\":null,\n" +
                "        \"state\":\"active\",\n" +
                "        \"replicas\":{\n" +
                "          \"core_node16\":{\n" +
                "            \"core\":\"sight_engine\",\n" +
                "            \"base_url\":\"http://192.168.232.53:8083/qsearch\",\n" +
                "            \"node_name\":\"192.168.232.53:8083_qsearch\",\n" +
                "            \"state\":\"active\",\n" +
                "            \"leader\":\"true\"},\n" +
                "          \"core_node10\":{\n" +
                "            \"core\":\"sight_engine\",\n" +
                "            \"base_url\":\"http://192.168.232.58:8093/qsearch\",\n" +
                "            \"node_name\":\"192.168.232.58:8093_qsearch\",\n" +
                "            \"state\":\"down\"}}}},\n" +
                "    \"router\":{\"name\":\"implicit\"}},\n" +
                "  \"plan_engine\":{\n" +
                "    \"shards\":{\"shard1\":{\n" +
                "        \"parent\":null,\n" +
                "        \"range\":null,\n" +
                "        \"state\":\"active\",\n" +
                "        \"replicas\":{\n" +
                "          \"core_node18\":{\n" +
                "            \"core\":\"plan_engine\",\n" +
                "            \"base_url\":\"http://192.168.232.53:8083/qsearch\",\n" +
                "            \"node_name\":\"192.168.232.53:8083_qsearch\",\n" +
                "            \"state\":\"active\",\n" +
                "            \"leader\":\"true\"},\n" +
                "          \"core_node10\":{\n" +
                "            \"core\":\"plan_engine\",\n" +
                "            \"base_url\":\"http://192.168.232.58:8093/qsearch\",\n" +
                "            \"node_name\":\"192.168.232.58:8093_qsearch\",\n" +
                "            \"state\":\"down\"}}}},\n" +
                "    \"router\":{\"name\":\"implicit\"}},\n" +
                "  \"vpas_engine\":{\n" +
                "    \"shards\":{\"shard1\":{\n" +
                "        \"parent\":null,\n" +
                "        \"range\":null,\n" +
                "        \"state\":\"active\",\n" +
                "        \"replicas\":{\n" +
                "          \"core_node16\":{\n" +
                "            \"core\":\"vpas_engine\",\n" +
                "            \"base_url\":\"http://192.168.232.53:8083/qsearch\",\n" +
                "            \"node_name\":\"192.168.232.53:8083_qsearch\",\n" +
                "            \"state\":\"active\",\n" +
                "            \"leader\":\"true\"},\n" +
                "          \"core_node10\":{\n" +
                "            \"core\":\"vpas_engine\",\n" +
                "            \"base_url\":\"http://192.168.232.58:8093/qsearch\",\n" +
                "            \"node_name\":\"192.168.232.58:8093_qsearch\",\n" +
                "            \"state\":\"down\"}}}},\n" +
                "    \"router\":{\"name\":\"implicit\"}},\n" +
                "  \"vac_engine\":{\n" +
                "    \"shards\":{\"shard1\":{\n" +
                "        \"parent\":null,\n" +
                "        \"range\":null,\n" +
                "        \"state\":\"active\",\n" +
                "        \"replicas\":{\n" +
                "          \"core_node16\":{\n" +
                "            \"core\":\"vac_engine\",\n" +
                "            \"base_url\":\"http://192.168.232.53:8083/qsearch\",\n" +
                "            \"node_name\":\"192.168.232.53:8083_qsearch\",\n" +
                "            \"state\":\"active\",\n" +
                "            \"leader\":\"true\"},\n" +
                "          \"core_node10\":{\n" +
                "            \"core\":\"vac_engine\",\n" +
                "            \"base_url\":\"http://192.168.232.58:8093/qsearch\",\n" +
                "            \"node_name\":\"192.168.232.58:8093_qsearch\",\n" +
                "            \"state\":\"down\"}}}},\n" +
                "    \"router\":{\"name\":\"implicit\"}},\n" +
                "  \"vac_quality\":{\n" +
                "    \"shards\":{\"shard1\":{\n" +
                "        \"parent\":null,\n" +
                "        \"range\":null,\n" +
                "        \"state\":\"active\",\n" +
                "        \"replicas\":{\n" +
                "          \"core_node15\":{\n" +
                "            \"core\":\"vac_quality\",\n" +
                "            \"base_url\":\"http://192.168.232.53:8083/qsearch\",\n" +
                "            \"node_name\":\"192.168.232.53:8083_qsearch\",\n" +
                "            \"state\":\"active\",\n" +
                "            \"leader\":\"true\"},\n" +
                "          \"core_node10\":{\n" +
                "            \"core\":\"vac_quality\",\n" +
                "            \"base_url\":\"http://192.168.232.58:8093/qsearch\",\n" +
                "            \"node_name\":\"192.168.232.58:8093_qsearch\",\n" +
                "            \"state\":\"down\"}}}},\n" +
                "    \"router\":{\"name\":\"implicit\"}},\n" +
                "  \"vac_rank\":{\n" +
                "    \"shards\":{\"shard1\":{\n" +
                "        \"parent\":null,\n" +
                "        \"range\":null,\n" +
                "        \"state\":\"active\",\n" +
                "        \"replicas\":{\n" +
                "          \"core_node15\":{\n" +
                "            \"core\":\"vac_rank\",\n" +
                "            \"base_url\":\"http://192.168.232.53:8083/qsearch\",\n" +
                "            \"node_name\":\"192.168.232.53:8083_qsearch\",\n" +
                "            \"state\":\"active\",\n" +
                "            \"leader\":\"true\"},\n" +
                "          \"core_node10\":{\n" +
                "            \"core\":\"vac_rank\",\n" +
                "            \"base_url\":\"http://192.168.232.58:8093/qsearch\",\n" +
                "            \"node_name\":\"192.168.232.58:8093_qsearch\",\n" +
                "            \"state\":\"down\"}}}},\n" +
                "    \"router\":{\"name\":\"implicit\"}}}";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode result =  mapper.readTree(json);

        JsonNode vac_engine = result.findValue("vac_engine").findValue("shards").findValue("replicas");

        for (JsonNode jsonNode : vac_engine) {
            System.out.println(jsonNode.get("state").asText().equals("active"));
        }

        System.out.println(result);




    }
}
