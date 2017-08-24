import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.util.Version;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class StandardAnalyzerTest {
    // 构造函数，   
    public StandardAnalyzerTest() {
    }

    public static void main(String[] args) {
        // 生成一个StandardAnalyzer对象   
        Analyzer aAnalyzer = new StandardAnalyzer(Version.LUCENE_46);
        // 测试字符串   
        StringReader sr = new StringReader("lighter javaeye com is the are on ");

        List<String> result = new ArrayList<String>();
        try {
            int i = 0;
            // 生成TokenStream对象   
            TokenStream tokenStream = aAnalyzer.tokenStream("name",sr);
            CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);
            tokenStream.reset();
            while (tokenStream.incrementToken()) {
                result.add(charTermAttribute.toString());
            }
            tokenStream.end();
            tokenStream.close();

           System.out.println(result);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
