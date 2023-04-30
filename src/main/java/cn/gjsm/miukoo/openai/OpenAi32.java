package cn.gjsm.miukoo.openai;

import cn.gjsm.miukoo.Constants;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;

import java.util.Arrays;

public class OpenAi32 {
    public static void main(String[] args) {
        OpenAiService service = new OpenAiService(Constants.OPENAPI_TOKEN);
        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("code-davinci-002")
                .prompt("You: 你最近好吗？\\n好友:")
                .temperature(0.5D)
                .maxTokens(1000)
                .topP(1D)
                .frequencyPenalty(0.5D)
                .presencePenalty(0D)
                .stop(Arrays.asList("You:"))
                .build();
        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
    }
}
