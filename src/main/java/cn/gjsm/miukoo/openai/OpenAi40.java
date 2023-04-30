package cn.gjsm.miukoo.openai;

import cn.gjsm.miukoo.Constants;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;

public class OpenAi40 {
    public static void main(String[] args) {
        OpenAiService service = new OpenAiService(Constants.OPENAPI_TOKEN);
        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt("头脑风暴一些关于上好课的想法：")
                .temperature(0.6D)
                .maxTokens(200)
                .topP(1D)
                .frequencyPenalty(1D)
                .presencePenalty(01D)
                .build();
        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
    }
}
