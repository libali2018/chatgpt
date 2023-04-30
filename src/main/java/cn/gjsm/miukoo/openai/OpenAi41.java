package cn.gjsm.miukoo.openai;

import cn.gjsm.miukoo.Constants;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;

import java.util.Arrays;

public class OpenAi41 {
    public static void main(String[] args) {
        OpenAiService service = new OpenAiService(Constants.OPENAPI_TOKEN);
        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt("为以下文本提供ESRB评级:\\n\\\"i'm going to blow your brains out with my ray gun then stomp on your guts.\\\"\\nESRB排名: ")
                .temperature(0.3D)
                .maxTokens(200)
                .topP(1D)
                .frequencyPenalty(0D)
                .presencePenalty(0D)
                .stop(Arrays.asList("\n"))
                .build();
        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
    }
}
