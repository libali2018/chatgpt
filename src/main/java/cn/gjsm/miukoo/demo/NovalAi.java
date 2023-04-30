package cn.gjsm.miukoo.demo;

import cn.gjsm.miukoo.Constants;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;

import java.util.Arrays;

public class NovalAi {
    public static void main(String[] args) {
        OpenAiService service = new OpenAiService(Constants.OPENAPI_TOKEN);
        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt("Q: 这里有一个prompt\n(((extremely detailed))),(((best quality))),(((masterpiece))),illustration,clear-cut margin,1 girl,white long hair,blue eyes,beautiful detailed eyes ,Hair glows,expressionless, hairs between eyes,pinafore dress,moon,night,horizon\n你能模仿这个模式写一个女孩在花园跳舞的prompt吗？(英文)\nA:")
                .temperature(0.9D)
                .maxTokens(1000)
                .topP(1D)
                .frequencyPenalty(0.5D)
                .presencePenalty(0D)
                .stop(Arrays.asList("\n"))
                .build();
        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
    }
}
