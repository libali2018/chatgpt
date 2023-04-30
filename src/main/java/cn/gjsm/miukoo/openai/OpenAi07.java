package cn.gjsm.miukoo.openai;

import cn.gjsm.miukoo.Constants;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;

import java.util.Arrays;

public class OpenAi07 {
    public static void main(String[] args) {
        OpenAiService service = new OpenAiService(Constants.OPENAPI_TOKEN);
        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("code-davinci-002")
                .prompt("\\\"\\\"\\\"\\nUtil exposes the following:\\n\\nutil.stripe() -> authenticates & returns the stripe module; usable as stripe.Charge.create etc\\n\\\"\\\"\\\"\\nimport util\\n\\\"\\\"\\\"\\n使用一个信用卡5555-4444-3333-2222，创建一个Stripe令牌\\n\\\"\\\"\\\"")
                .temperature(0.3D)
                .maxTokens(1000)
                .topP(1D)
                .frequencyPenalty(0D)
                .presencePenalty(0D)
                .stop(Arrays.asList("\"\"\""))
                .build();
        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
    }
}
