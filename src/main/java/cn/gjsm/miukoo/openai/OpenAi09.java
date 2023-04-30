package cn.gjsm.miukoo.openai;

import cn.gjsm.miukoo.Constants;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;

import java.util.Arrays;

public class OpenAi09 {
    public static void main(String[] args) {
        OpenAiService service = new OpenAiService(Constants.OPENAPI_TOKEN);
        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt("A table summarizing, use Chinese:\\n我是一个活泼可爱的小女孩，我有着一双水灵灵的大眼睛；弯弯的眉毛像月亮一样；高高的鼻子下面有一张粉红色的樱桃小嘴。\\n")
                .temperature(0.0D)
                .maxTokens(100)
                .topP(1D)
                .frequencyPenalty(0D)
                .presencePenalty(0D)
                .build();
        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
    }
}
