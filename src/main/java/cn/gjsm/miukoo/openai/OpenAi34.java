package cn.gjsm.miukoo.openai;

import cn.gjsm.miukoo.Constants;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;

import java.util.Arrays;

public class OpenAi34 {
    public static void main(String[] args) {
        OpenAiService service = new OpenAiService(Constants.OPENAPI_TOKEN);
        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("code-davinci-002")
                .prompt("# Python 3.7\\n \\ndef randomly_split_dataset(folder, filename, split_ratio=[0.8, 0.2]):\\n    df = pd.read_json(folder + filename, lines=True)\\n    train_name, test_name = \\\"train.jsonl\\\", \\\"test.jsonl\\\"\\n    df_train, df_test = train_test_split(df, test_size=split_ratio[1], random_state=42)\\n    df_train.to_json(folder + train_name, orient='records', lines=True)\\n    df_test.to_json(folder + test_name, orient='records', lines=True)\\nrandomly_split_dataset('finetune_data/', 'dataset.jsonl')\\n# 上述代码的详细、高质量文档字符串：\\n\\\"\\\"\\\"")
                .temperature(0D)
                .maxTokens(1000)
                .topP(1D)
                .frequencyPenalty(0D)
                .presencePenalty(0D)
                .stop(Arrays.asList("\"\"\"","#"))
                .build();
        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
    }
}
