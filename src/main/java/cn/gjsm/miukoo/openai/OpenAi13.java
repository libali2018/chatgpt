package cn.gjsm.miukoo.openai;

import cn.gjsm.miukoo.Constants;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;

import java.util.Arrays;

public class OpenAi13 {
    public static void main(String[] args) {
        OpenAiService service = new OpenAiService(Constants.OPENAPI_TOKEN);
        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt("for (int i = 0; i < 10; i++) {\\n            System.out.println(1);\\n}\\n\\\"\\\"\\\"\\n函数的时间复杂度是 ")
                .temperature(0D)
                .maxTokens(64)
                .topP(1D)
                .frequencyPenalty(0D)
                .presencePenalty(0D)
                .stop(Arrays.asList("\n"))
                .build();
        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
    }
}
