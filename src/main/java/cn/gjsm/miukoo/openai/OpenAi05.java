package cn.gjsm.miukoo.openai;

import cn.gjsm.miukoo.Constants;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;

import java.util.Arrays;

public class OpenAi05 {
    public static void main(String[] args) {
        OpenAiService service = new OpenAiService(Constants.OPENAPI_TOKEN);
        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt("Convert this text to a programmatic command:\\n\\nExample: Ask Constance if we need some bread\\nOutput: send-msg `find constance` Do we need some bread?\\n\\n添加一个自动关机的定时任务")
                .temperature(0.0D)
                .maxTokens(1000)
                .topP(1D)
                .frequencyPenalty(0.2D)
                .presencePenalty(0D)
                .build();
        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
    }
}
