package cn.gjsm.miukoo.openai;

import cn.gjsm.miukoo.Constants;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;

import java.util.Arrays;

public class OpenAi08 {
    public static void main(String[] args) {
        OpenAiService service = new OpenAiService(Constants.OPENAPI_TOKEN);
        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("code-davinci-002")
                .prompt("### Mysql SQL tables, 表字段信息如下:\\n#\\n# Employee(id, name, department_id)\\n# Department(id, name, address)\\n# Salary_Payments(id, employee_id, amount, date)\\n#\\n### 创建表的语法\\n CREATE")
                .temperature(0.0D)
                .maxTokens(1000)
                .topP(1D)
                .frequencyPenalty(0D)
                .presencePenalty(0D)
                .stop(Arrays.asList("#",";"))
                .build();
        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
    }
}
