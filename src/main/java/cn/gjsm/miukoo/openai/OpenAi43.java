package cn.gjsm.miukoo.openai;

import cn.gjsm.miukoo.Constants;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;

public class OpenAi43 {
    public static void main(String[] args) {
        OpenAiService service = new OpenAiService(Constants.OPENAPI_TOKEN);
        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt("依据下面成分和美食，生成制作方法:\\n水煮肉片\\n成分:\\n豆芽\\n水\\n油\\n猪肉\\n鸡精\\n盐\\n辣椒\\n\\n制作方法:")
                .temperature(0.3D)
                .maxTokens(200)
                .topP(1D)
                .frequencyPenalty(0D)
                .presencePenalty(0D)
                .build();
        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
    }
}
