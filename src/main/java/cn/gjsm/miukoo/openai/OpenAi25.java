package cn.gjsm.miukoo.openai;

import cn.gjsm.miukoo.Constants;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;

import java.util.Arrays;

public class OpenAi25 {
    public static void main(String[] args) {
        OpenAiService service = new OpenAiService(Constants.OPENAPI_TOKEN);
        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt("You: 你会那些模型？\\nML机器人:")
                .temperature(0.3D)
                .maxTokens(200)
                .topP(1D)
                .frequencyPenalty(0.5D)
                .presencePenalty(0D)
                .stop(Arrays.asList("You: "))
                .build();
        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
    }
}
