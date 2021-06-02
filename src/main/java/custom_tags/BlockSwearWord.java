package custom_tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class BlockSwearWord extends SimpleTagSupport {
    public String content;

    //Holy shit, You are bitch, right ? -> Holy ***, You are ***, right ?
    public String[] swearWords = new String[]{
            "shit",
            "bitch"
    };


    public void setContent(String content) {
        this.content = content;
        for (int i = 0; i < swearWords.length; i++) {
            this.content = this.content.replace(swearWords[i], "***");
        }
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        try {
            out.print(this.content);
        }catch (Exception e){
            throw new JspException("Error while render hello", e);
        }
    }
}
