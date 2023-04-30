package cn.gjsm.miukoo.openai;

import cn.gjsm.miukoo.Constants;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;

import java.util.Arrays;

public class OpenAi22 {
    public static void main(String[] args) {
        OpenAiService service = new OpenAiService(Constants.OPENAPI_TOKEN);
        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("code-davinci-002")
                .prompt("##### 修复下面代码的bug\n### Java\npublic class T {\n    public static void main(String[] args) {\n        System.outs.println(\"Hello Heima\");\n    }\n}\n### Java\n")
                .temperature(0D)
                .maxTokens(200)
                .topP(1D)
                .frequencyPenalty(0D)
                .presencePenalty(0D)
                .stop(Arrays.asList("###"))
                .build();
        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
    }
}
