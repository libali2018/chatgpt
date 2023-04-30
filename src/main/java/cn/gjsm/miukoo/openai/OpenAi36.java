package cn.gjsm.miukoo.openai;

import cn.gjsm.miukoo.Constants;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;

import java.util.Arrays;

public class OpenAi36 {
    public static void main(String[] args) {
        OpenAiService service = new OpenAiService(Constants.OPENAPI_TOKEN);
        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("code-davinci-002")
                .prompt("将下面Java代码转成一行:\\npublic class T {\\n    public static void main(String[] args) {\\n        System.out.println(\\\"Hello hiema\\\");\\n    }\\n}\\nJava一行版本:")
                .temperature(0D)
                .maxTokens(1000)
                .topP(1D)
                .frequencyPenalty(0D)
                .presencePenalty(0D)
                .stop(Arrays.asList(";"))
                .build();
        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
    }
}
