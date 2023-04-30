package cn.gjsm.miukoo.openai;

import cn.gjsm.miukoo.Constants;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;

public class OpenAi03 {
    public static void main(String[] args) {
        OpenAiService service = new OpenAiService(Constants.OPENAPI_TOKEN);
        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt("Summarize this for a second-grade student:\n虽然我国国土辽阔，但我们要确保十三亿的人的衣食住行。我们的生活富裕了，但能源能不能持续跟上呢?希望大家能够利用废物，节约地球能源，善待地球环境，从身边的小事做起，从我做起，保护环境。还要呼吁大家共同保护赖以生存的家园!")
                .temperature(0.7D)
                .maxTokens(1000)
                .topP(1D)
                .frequencyPenalty(0D)
                .presencePenalty(0D)
                .build();
        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
    }
}
