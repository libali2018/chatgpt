package cn.gjsm.miukoo.openai;

import cn.gjsm.miukoo.Constants;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;

import java.util.Arrays;

public class OpenAi44 {
    public static void main(String[] args) {
        OpenAiService service = new OpenAiService(Constants.OPENAPI_TOKEN);
        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt("Human: 你是谁？")
                .temperature(0.9D)
                .maxTokens(200)
                .topP(1D)
                .frequencyPenalty(0D)
                .presencePenalty(0.6D)
                .stop(Arrays.asList("Human:","AI:"))
                .build();
        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
    }
}
